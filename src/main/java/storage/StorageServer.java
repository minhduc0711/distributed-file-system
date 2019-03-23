package storage;

import naming.Registration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StorageServer implements Storage {
    Storage storageSkeleton;
    String storageId;

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
        String path = "localStorage/";
        try {
            Files.walk(Paths.get(path)).forEach(p -> {
                pathList.add("/" + p.toString().replace(path, ""));
                isDirList.add(Files.isDirectory(p));
            });
            isDirList.remove(0);
            pathList.remove(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Registry registry = LocateRegistry.getRegistry();
            Registration registrationStub = (Registration) registry.lookup("Registration");
            registrationStub.register(pathList, isDirList, storageId);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        StorageServer storageServer = new StorageServer(11111);
        storageServer.start();
    }
}
