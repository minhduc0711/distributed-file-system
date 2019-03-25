package login;

import storage.Storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Session extends Remote {
    void changeDirectory(String path) throws RemoteException;

    String[] list() throws RemoteException;

    String getCurrentDir() throws RemoteException;

    byte[] read(String path) throws IOException;

    void logout() throws RemoteException;
}
