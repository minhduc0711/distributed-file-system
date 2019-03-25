package login;

import naming.DirectoryTreeNode;
import naming.Naming;
import naming.NamingServer;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.Unreferenced;

public class SessionImpl extends UnicastRemoteObject implements Session, Unreferenced {
    private NamingServer namingServer;
    DirectoryTreeNode currentNode;

    public SessionImpl(NamingServer namingServer) throws RemoteException {
        super();
        this.namingServer = namingServer;
        currentNode = namingServer.rootNode;
    }

    @Override
    public void changeDirectory(String path) throws RemoteException {
        String[] nodeNames = path.split("/");
        for (int i = 0; i < nodeNames.length; i += 1) {
            if (currentNode.getChildren().containsKey(nodeNames[i])) {
                currentNode = currentNode.getChildren().get(nodeNames[i]);
            } else {
                throw new IllegalArgumentException();
            }
        }
        System.out.println(currentNode.toString());
    }

    @Override
    public String[] list() throws RemoteException {
        return currentNode.getChildren().keySet().toArray(new String[currentNode.getChildren().size()]);
    }

    @Override
    public String getCurrentDir() throws RemoteException {
        return currentNode.toString();
    }

    @Override
    public byte[] read(String path) throws IOException {
        String fullPath = Paths.get(currentNode.toString(), path).toString();
        Storage storage = namingServer.getStorage(fullPath);
        return storage.read(fullPath);
    }

    public void logout() throws RemoteException
    {
        unexportObject(this, true);
    }

    public void unreferenced()
    {
        try {
            unexportObject(this, true); // needs to be in a try/catch block of course
        } catch (NoSuchObjectException e) {
            e.printStackTrace();
        }
    }
}
