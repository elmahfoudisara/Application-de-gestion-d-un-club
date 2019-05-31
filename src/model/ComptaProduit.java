package model;



public class ComptaProduit {
	private int id_produit;
	private String produit;
	private String montant;
	public ComptaProduit(int id_produit, String produit, String montant) {
		super();
		this.id_produit = id_produit;
		this.produit = produit;
		this.montant = montant;
	}
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public String getProduit() {
		return produit;
	}
	public void setProduit(String produit) {
		this.produit = produit;
	}
	public String getMontant() {
		return montant;
	}
	public void setMontant(String montant) {
		this.montant = montant;
	}
	@Override
	public String toString() {
		return "ComptaProduit [id_produit=" + id_produit + ", produit=" + produit + ", montant=" + montant + "]";
	}
	
}
