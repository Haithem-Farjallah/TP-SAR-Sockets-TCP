package exercice1;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketServeur {
    public static void main(String argv[]) {
        int port = 0;
        Scanner keyb = new Scanner(System.in);

        //saisir le port d'écoute
        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        }
        try {
            // Création d'un objet ServerSocket lié au port spécifié
            ServerSocket serverSocket = new ServerSocket(port);
            // Le serveur se met en attente d'une connexion entrante
            Socket socket = serverSocket.accept();
            // Création d'objets ObjectOutputStream et ObjectInputStream pour envoyer et recevoir des objets via le socket
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            // Lecture de la chaîne envoyée par le client à travers le flux d'entrée
            String chaine = (String) input.readObject();
            System.out.println(" recu : " + chaine);
            // Affichage de l'adresse IP et du port du client
            System.out.println(" ca vient de : " + socket.getInetAddress() + ":" + socket.getPort());
            // Envoi d'une réponse au client à travers le flux de sortie
            output.writeObject(new String("bien recu"));
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
