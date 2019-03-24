package storage;

import naming.Naming;
import org.apache.commons.io.FileUtils;
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
    private String STORAGE_DIR = "localStorage/";
    private Storage storageSkeleton;
    public String storageId;

    public StorageServer(int portNumber) {
        storageId = "Storage" + portNumber;
        try {
            storageSkeleton = (Storage) UnicastRemoteObject.exportObject(this, portNumber);
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
            Registry registry = LocateRegistry.getRegistry();
            Naming namingStub = (Naming) registry.lookup("Naming");
            namingStub.register(pathList, isDirList, storageId);
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
    public String getId() throws RemoteException {
        return storageId;
    }

    private Path convertToLocalPath(Path remotePath) {
        return Paths.get(STORAGE_DIR + "/" + remotePath);
    }

    public static void main(String[] args) {
        StorageServer storageServer = new StorageServer(11111);
        storageServer.start();
    }
}
