package naming;

import storage.Storage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class NamingServer implements Service, Registration {
    DirectoryTreeNode rootNode;
    Registration registrationSkeleton;
    Service serviceSkeleton;

    public NamingServer() {
        rootNode = new DirectoryTreeNode();
    }

    public void start() {
        try {
            registrationSkeleton = (Registration) UnicastRemoteObject.exportObject(this, 12345);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Registration", registrationSkeleton);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("Naming server is running...");
    }

    @Override
    public void register(ArrayList<String> pathList, ArrayList<Boolean> isDirList, String storageId) throws RemoteException {
        Registry registry = LocateRegistry.getRegistry();
        try {
            Storage storageStub = (Storage) registry.lookup(storageId);
            assert pathList.size() == isDirList.size();

            for (int i = 0; i < pathList.size(); i += 1) {
                Path p = Paths.get(pathList.get(i));
                rootNode.addPath(p, isDirList.get(i), storageStub);
            }

            System.out.println(storageId + " registered successfully!");
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isDirectory(String path) throws RemoteException {
        return false;
    }

    @Override
    public boolean createFile(String path) throws RemoteException {
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
