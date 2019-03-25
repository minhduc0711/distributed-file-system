package storage;

import naming.Naming;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StorageServer implements Storage {
    private String namingAddress;

    private String storageAddress;
    private String STORAGE_DIR = "localStorage/";
    private Storage storageSkeleton;
    public String storageId;

    public StorageServer(String namingAddress, String storageAddress, int storagePort) {
        this.namingAddress = namingAddress;
        this.storageAddress = storageAddress;
        storageId = "Storage " + storageAddress + ":" + storagePort;
        try {
            storageSkeleton = (Storage) UnicastRemoteObject.exportObject(this, storagePort);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(storageId, storageSkeleton);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        ArrayList<String> pathList = new ArrayList<>();
        ArrayList<Boolean> isDirList = new ArrayList<>();
        try {
            Files.walk(Paths.get(STORAGE_DIR)).forEach(p -> {
                pathList.add("/" + p.toString().replace(STORAGE_DIR, ""));
                isDirList.add(Files.isDirectory(p));
            });
            isDirList.remove(0);
            pathList.remove(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Registry registry = LocateRegistry.getRegistry(this.namingAddress);
            Naming namingStub = (Naming) registry.lookup("Naming");
            namingStub.register(pathList, isDirList, storageId, this.storageAddress);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] read(String path) throws IOException {
        Path p = Paths.get(path);
        Path localPath = convertToLocalPath(p);
        InputStream inputStream = new FileInputStream(localPath.toString());
        return IOUtils.toByteArray(inputStream);
    }

    @Override
    public void write(String path, byte[] buffer) throws RemoteException {
        Path p = Paths.get(path);
        Path localPath = convertToLocalPath(p);

        File file = new File(localPath.toString());
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(String path) throws RemoteException {
        return false;
    }

    @Override
    public boolean copyTo(String path, Storage storage) throws RemoteException {
        Path p = Paths.get(path);
        Path localPath = convertToLocalPath(p);
        byte[] buffer = new byte[4096];

        try {
            FileInputStream fileInputStream = new FileInputStream(localPath.toString());
            while (true) {
                int numBytesRead = fileInputStream.read(buffer);
                if (numBytesRead == -1) {
                    break;
                }
            }
            storage.write(path, buffer);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String getId() throws RemoteException {
        return storageId;
    }

    @Override
    public void alive() throws RemoteException {
    }

    private Path convertToLocalPath(Path remotePath) {
        return Paths.get(STORAGE_DIR + "/" + remotePath);
    }

    public static void main(String[] args) {
        StorageServer storageServer = new StorageServer("192.168.1.125", null, 11111);
        storageServer.start();
    }
}
