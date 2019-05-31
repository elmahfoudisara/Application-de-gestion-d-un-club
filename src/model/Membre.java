package model;

public class Membre {
	
	private int id_membre;
	private String login;
	private String nom;
	private String prenom;
	private String email;
	private String role;
	private String password;
	
	public Membre(int id_membre, String login, String nom, String prenom, String email, String role,String password) {
		super();
		this.id_membre = id_membre;
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.role = role;
		this.password = password;
		
	}

	public int getId_membre() {
		return id_membre;
	}

	public void setId_membre(int id_membre) {
		this.id_membre = id_membre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "Membre [id_membre=" + id_membre + ", login=" + login + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", role=" + role + ", password=" + password + "]";
	}
	
	
	
}
	
	