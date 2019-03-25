package naming;

import storage.Storage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Naming extends Remote {
    void register(ArrayList<String> pathList, ArrayList<Boolean> isDir, String storageId, String storageAddress) throws RemoteException;

    boolean isDirectory(String path) throws RemoteException;

    boolean createDirectory(String path) throws RemoteException;

    Storage getStorage(String path) throws RemoteException;

    void uploadFile(String path, byte[] buffer) throws RemoteException;
}
