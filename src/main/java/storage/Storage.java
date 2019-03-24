package storage;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Storage extends Remote, Serializable {
    byte[] read(String path) throws IOException;

    void write(String path, byte[] buffer) throws RemoteException;

    String getId() throws RemoteException;
}
