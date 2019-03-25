package login;

import naming.Naming;
import naming.NamingServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class LoginImpl implements Login {
    private NamingServer namingServer = new NamingServer();

    @Override
    public Session login() throws RemoteException {
        return new SessionImpl(namingServer); // or whatever
    }

    @Override
    public void register(ArrayList<String> pathList, ArrayList<Boolean> isDirList, String storageId, String storageAddress) throws RemoteException {
        namingServer.register(pathList, isDirList, storageId, storageAddress);
    }

    public static void main(String[] args) {
        Login login = new LoginImpl();
        try {
            Login skeleton = (Login) UnicastRemoteObject.exportObject(login, 54321);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Login", skeleton);
            System.out.println("Naming server is running...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

