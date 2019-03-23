package naming;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote {
    boolean isDirectory(String path) throws RemoteException;

    boolean createFile(String path) throws RemoteException;

    boolean createDirectory(String path) throws RemoteException;
}
