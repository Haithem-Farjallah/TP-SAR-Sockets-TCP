package exercice3;

import java.io.Serializable;

public class Personne implements Serializable {
    private int age;
    private String nom;
    private int id;

    public Personne(int age, String nom, int id) {
        this.age = age;
        this.nom = nom;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

	public void setId(int clientId) {
		this.id=clientId;
		
	}
}
