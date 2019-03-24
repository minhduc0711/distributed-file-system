package client;

import naming.Naming;
import storage.Storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            Naming namingStub = (Naming) registry.lookup("Naming");

            // Test read
//            String p = "slides/notes_on_final.txt";
//
//            Storage storage = namingStub.getStorage(p);
//            byte[] ret = storage.read(p);
//            System.out.println(new String(ret, StandardCharsets.UTF_8));

            // Test write
            uploadToServer("/home/minhduc0711/grid_random_search.png", "/", namingStub);

           //  Test read
            String p = "grid_random_search.png";

            Storage storage = namingStub.getStorage(p);
            byte[] ret = storage.read(p);
            System.out.println(new String(ret, StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void uploadToServer(String pathToFile, String dirOnServer, Naming namingStub) {
        Path pFile = Paths.get(pathToFile);
        Path pServer = Paths.get(dirOnServer, pFile.getFileName().toString());

        try {
            byte[] buffer = new byte[4096];
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            while (true) {
                int numBytesRead = fileInputStream.read(buffer);
                if (numBytesRead == -1) {
                    break;
                }
                namingStub.uploadFile(pServer.toString(), buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
