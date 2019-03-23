package naming;

import storage.Storage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Registration extends Remote {
    void register(ArrayList<String> pathList, ArrayList<Boolean> isDir, String storageId) throws RemoteException;
}
