package exercice2;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class serveurVoiture {
    public static void main(String argv[]) {
        int port = 0;
        Scanner keyb = new Scanner(System.in);
        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le paramètre n'est pas un entier.");
            System.exit(-1);
        }
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            voiture voitureDuClient = (voiture) input.readObject();

            int quantite=keyb.nextInt();
            voitureDuClient.setCarburant(quantite);

            output.writeObject(voitureDuClient);
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}