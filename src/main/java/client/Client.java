package client;

import login.Login;
import login.Session;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    static final String NAMING_SERVER_IP = null;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(NAMING_SERVER_IP);
            Login loginStub = (Login) registry.lookup("Login");
            Session session = loginStub.login();

            Scanner scanner = new Scanner(System.in);

            ApplicationLoop:
            while (true) {
                System.out.print(session.getCurrentDir() + "$ ");
                String[] inputs = scanner.nextLine().split(" ");
                switch (inputs[0]) {
                    case "ls":
                        System.out.println(Arrays.toString(session.list()));
                        break;
                    case "cd":
                        session.changeDirectory(inputs[1]);
                        break;
                    case "cat":
                        byte[] bytes = session.read(inputs[1]);
                        System.out.println(new String(bytes, StandardCharsets.UTF_8));
                        break;
                    case "q":
                        break ApplicationLoop;
                    default:
                        System.out.println("Invalid command");
                }
            }
            session.logout();
            // Test write
//            uploadToServer("/media/minhduc0711/Libraries/Pictures/Wallpapers/799035.jpg", "slides", namingStub);

//            // Test read
//            String p = "799035.png";
//
//            Storage storage = namingStub.getStorage(p);
//            byte[] ret = storage.read(p);
//            System.out.println(new String(ret, StandardCharsets.UTF_8));

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
