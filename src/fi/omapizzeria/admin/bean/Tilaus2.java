package fi.omapizzeria.admin.bean;

import java.util.Date;

public class Tilaus2 {
	
	private int id;
	private String etunimi;
	private String sukunimi;
	private String puhnro;
	private double hintasumma;
	private String tilausos;
	private String postinro;
	private String postitmp;
	private Date tilauspvm;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public String getPuhnro() {
		return puhnro;
	}
	public void setPuhnro(String puhnro) {
		this.puhnro = puhnro;
	}
	public double getHintasumma() {
		return hintasumma;
	}
	public void setHintasumma(double hintasumma) {
		this.hintasumma = hintasumma;
	}
	public String getTilausos() {
		return tilausos;
	}
	public void setTilausos(String tilausos) {
		this.tilausos = tilausos;
	}
	public String getPostinro() {
		return postinro;
	}
	public void setPostinro(String postinro) {
		this.postinro = postinro;
	}
	public String getPostitmp() {
		return postitmp;
	}
	public void setPostitmp(String postitmp) {
		this.postitmp = postitmp;
	}
	public Date getTilauspvm() {
		return tilauspvm;
	}
	public void setTilauspvm(Date tilauspvm) {
		this.tilauspvm = tilauspvm;
	}
	
	public Tilaus2(int id, String etunimi, String sukunimi, String puhnro,
			double hintasumma, String tilausos, String postinro,
			String postitmp, Date tilauspvm) {
		super();
		this.id = id;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.puhnro = puhnro;
		this.hintasumma = hintasumma;
		this.tilausos = tilausos;
		this.postinro = postinro;
		this.postitmp = postitmp;
		this.tilauspvm = tilauspvm;
	}
	
	public Tilaus2() {

	}
	@Override
	public String toString() {
		return "Tilaus2 [id=" + id + ", etunimi=" + etunimi + ", sukunimi="
				+ sukunimi + ", puhnro=" + puhnro + ", hintasumma="
				+ hintasumma + ", tilausos=" + tilausos + ", postinro="
				+ postinro + ", postitmp=" + postitmp + ", tilauspvm="
				+ tilauspvm + "]";
	}




}
