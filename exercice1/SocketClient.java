package exercice1;
import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClient {
    public static void main(String argv[]) {
    int port = 0;
    String host = "";
    Scanner keyb = new Scanner(System.in);
    // Nom du domaine + port
    System.out.print("Nom du serveur : ");
    host = keyb.next();
    System.out.print("Port du serveur : ");
    try {
    port = keyb.nextInt();
    } catch (NumberFormatException e) {
    System.err.println("Le second paramètre n'est pas un entier.");
    System.exit(-1);
    }
    // se connecter au serveur
    try {
    // demande l'adresse du serveur
    InetAddress adr = InetAddress.getByName(host);
    // création du socket Client
    Socket socket = new Socket(adr, port);
    // Initialiser les messages d'entré et sortie
    ObjectOutputStream output =
    new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream input =
    new ObjectInputStream(socket.getInputStream());
    // envoyer le message
    output.writeObject(new String("ma première socket"));
    // recevoir le message
    String chaine = (String) input.readObject();
    System.out.println(" recu du serveur : " + chaine);
    } catch (Exception e) {
    System.err.println("Erreur : " + e);
    }
    }
    }