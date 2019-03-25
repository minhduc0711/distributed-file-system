package naming;

import storage.Storage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NamingServer implements Naming {
    private static final int NUM_REPLICAS = 1;

    DirectoryTreeNode rootNode;
    Naming namingSkeleton;
    ArrayList<Storage> connectedStorages;

    public NamingServer() {
        rootNode = new DirectoryTreeNode();
        connectedStorages = new ArrayList<>();
    }

    public void start() {
        try {
            namingSkeleton = (Naming) UnicastRemoteObject.exportObject(this, 54321);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Naming", namingSkeleton);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("Naming server is running...");
    }

    @Override
    public void register(ArrayList<String> pathList, ArrayList<Boolean> isDirList, String storageId) throws RemoteException {
        assert pathList.size() == isDirList.size();

        try {
            Registry registry = LocateRegistry.getRegistry();
            Storage storageStub = (Storage) registry.lookup(storageId);

            for (int i = 0; i < pathList.size(); i += 1) {
                Path p = Paths.get(pathList.get(i));
                DirectoryTreeNode fileNode = rootNode.getLastNodeInPath(p);
                if (fileNode == null) {
                    rootNode.addPath(p, isDirList.get(i), storageStub);
                } else {
                    fileNode.getStorageList().add(storageStub);
                }
            }
            System.out.println(storageStub.getId() + " registered successfully!");
            connectedStorages.add(storageStub);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Storage getStorage(String path) throws RemoteException {
        System.out.println(path);

        Path p = Paths.get(path);
        DirectoryTreeNode fileNode = rootNode.getLastNodeInPath(p);
        List<Storage> storageList = fileNode.getStorageList();
        for (Storage storage : storageList) {
            try {
                storage.alive();
                return storage;
            } catch (RemoteException e) {
                continue;
            }
        }
        return null;
    }

    @Override
    public void uploadFile(String path, byte[] buffer) throws RemoteException {
        Path p = Paths.get(path);

        if (connectedStorages.size() < NUM_REPLICAS) {
            throw new IllegalStateException("Not enough servers are running to replicate");
        }

        List<Storage> luckyStorages = new ArrayList<>();
        while (luckyStorages.size() < NUM_REPLICAS) {
            int randomId = new Random().nextInt(connectedStorages.size());
            Storage storage = connectedStorages.get(randomId);
            if (!luckyStorages.contains(storage)) {
                luckyStorages.add(storage);
            }
        }

        for (Storage storage : luckyStorages) {
            DirectoryTreeNode fileNode = rootNode.getLastNodeInPath(p);
            if (fileNode == null) {
                rootNode.addPath(p, false, storage);
            } else {
                fileNode.getStorageList().add(storage);
            }
            storage.write(path, buffer);
        }
    }

    @Override
    public boolean isDirectory(String path) throws RemoteException {
        return false;
    }

    @Override
    public boolean createDirectory(String path) throws RemoteException {
        return false;
    }

    public static void main(String[] args) {
        NamingServer namingServer = new NamingServer();
        namingServer.start();
    }
}
