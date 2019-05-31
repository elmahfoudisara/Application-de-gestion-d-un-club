package model;

public class TPv {
	private int id_pv;
	private String ordreJour;
	private String heureLevee;
	private String resume;
	private String signature;
	private String AnimReunion;
	public TPv(int id_pv, String ordreJour, String heureLevee, String resume, String signature, String animReunion) {
		super();
		this.id_pv = id_pv;
		this.ordreJour = ordreJour;
		this.heureLevee = heureLevee;
		this.resume = resume;
		this.signature = signature;
		AnimReunion = animReunion;
	}
	public int getId_pv() {
		return id_pv;
	}
	public void setId_pv(int id_pv) {
		this.id_pv = id_pv;
	}
	public String getOrdreJour() {
		return ordreJour;
	}
	public void setOrdreJour(String ordreJour) {
		this.ordreJour = ordreJour;
	}
	public String getHeureLevee() {
		return heureLevee;
	}
	public void setHeureLevee(String heureLevee) {
		this.heureLevee = heureLevee;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getAnimReunion() {
		return AnimReunion;
	}
	public void setAnimReunion(String animReunion) {
		AnimReunion = animReunion;
	}
	@Override
	public String toString() {
		return "Pv [id_pv=" + id_pv + ", ordreJour=" + ordreJour + ", heureLevee=" + heureLevee + ", resume=" + resume
				+ ", signature=" + signature + ", AnimReunion=" + AnimReunion + "]";
	}
	

}
