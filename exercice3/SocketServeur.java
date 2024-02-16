package exercice3;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketServeur {
    private static int clientIdCounter = 0;

    public static void main(String argv[]) {
        int port = 0;
        Scanner keyb = new Scanner(System.in);

        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        }

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Serveur démarré sur le port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Nouvelle connexion acceptée.");
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                Personne personne = (Personne) input.readObject();
                int clientId = generateClientId();
                personne.setId(clientId);
                output.writeInt(clientId);
                output.flush();
                System.out.println("Message reçu de : " + socket.getInetAddress() + ":" + socket.getPort());
            }
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }

    private static synchronized int generateClientId() {
        return ++clientIdCounter;
    }
}

