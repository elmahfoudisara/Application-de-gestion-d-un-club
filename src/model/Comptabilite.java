package model;



public class Comptabilite {
	private int id_compta;
	private String charge;
	private String montant_charge;
	public Comptabilite(int id_compta, String charge, String montant_charge) {
		super();
		this.id_compta = id_compta;
		this.charge = charge;
		this.montant_charge = montant_charge;
	}
	public int getId_compta() {
		return id_compta;
	}
	public void setId_compta(int id_compta) {
		this.id_compta = id_compta;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getMontant_charge() {
		return montant_charge;
	}
	public void setMontant_charge(String montant_charge) {
		this.montant_charge = montant_charge;
	}
	@Override
	public String toString() {
		return "Comptabilite [id_compta=" + id_compta + ", charge=" + charge + ", montant_charge=" + montant_charge
				+ "]";
	}
	

}
