package login;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Session extends Remote {
    void changeDirectory(String path) throws RemoteException;

    String[] list() throws RemoteException;

    String getCurrentDir() throws RemoteException;

    byte[] read(String path) throws IOException;

    void uploadFile(String path, byte[] buffer) throws RemoteException;

    void delete(String path) throws RemoteException;

    void logout() throws RemoteException;
}
