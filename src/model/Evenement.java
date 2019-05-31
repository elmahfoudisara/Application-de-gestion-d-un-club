package model;

import java.awt.Image;

public class Evenement {
	private int id_event;
	private String nom_event;
	private Image image;
	private String apropos;
	public Evenement(int id_event, String nom_event, Image image, String apropos) {
		super();
		this.id_event = id_event;
		this.nom_event = nom_event;
		this.image = image;
		this.apropos = apropos;
	}
	public int getId_event() {
		return id_event;
	}
	public void setId_event(int id_event) {
		this.id_event = id_event;
	}
	public String getNom_event() {
		return nom_event;
	}
	public void setNom_event(String nom_event) {
		this.nom_event = nom_event;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getApropos() {
		return apropos;
	}
	public void setDate(String apropos) {
		this.apropos = apropos;
	}
	@Override
	public String toString() {
		return "Evenement [id_event=" + id_event + ", nom_event=" + nom_event + ", image=" + image + ", apropos=" + apropos
				+ "]";
	}
	
	

}
