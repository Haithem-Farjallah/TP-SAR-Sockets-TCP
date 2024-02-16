package exercice3;


import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
public class SocketClient { 
 public static void main(String argv[]) { 
 int port = 0; 
 String host = ""; 
 Scanner keyb = new Scanner(System.in); 

 System.out.print("Nom du serveur : "); 
 host = keyb.next(); 
 System.out.print("Port du serveur : "); 
  
 try { 
 port = keyb.nextInt(); 
 } catch (NumberFormatException e) { 
 System.err.println("Le second paramètre n'est pas un entier."); 
  System.exit(-1); 
 } 

 try { 

 InetAddress adr = InetAddress.getByName(host); 
  Socket socket = new Socket(adr, port); 
  ObjectOutputStream output=new ObjectOutputStream(socket.getOutputStream());  
ObjectInputStream input = new ObjectInputStream(socket.getInputStream()); 
System.out.print("Saisir l'âge de la personne : ");
int age = keyb.nextInt();
keyb.nextLine(); 
System.out.print("Saisir le nom de la personne : ");
String nom = keyb.nextLine();
Personne personne = new Personne(age, nom, 0); 
output.writeObject(personne);
output.flush();
int clientId = input.readInt();
System.out.println("Id du client : " + clientId);  }
catch (Exception e) { 
 System.err.println("Erreur : " + e); 
 } 
 } 
}