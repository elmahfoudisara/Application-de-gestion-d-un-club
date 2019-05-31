package model;



public class Absence {
	private int id;
	
	private String dateAbsence;
	private String raison;
	private String nom;

public Absence(int id, String dateAbsence, String raison, String nom) {
		super();
		this.id = id;
		this.dateAbsence = dateAbsence;
		this.raison = raison;
		this.nom = nom;
	}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDateAbsence() {
	return dateAbsence;
}

public void setDateAbsence(String dateAbsence) {
	this.dateAbsence = dateAbsence;
}

public String getRaison() {
	return raison;
}

public void setRaison(String raison) {
	this.raison = raison;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

@Override
public String toString() {
	return "Absence [id=" + id + ", dateAbsence=" + dateAbsence + ", raison=" + raison + ", nom=" + nom + "]";
}
}