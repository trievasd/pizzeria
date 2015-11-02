package fi.omapizzeria.admin.bean;

import java.util.ArrayList;

public class Tilaus {
	
	private String etunimi;
	private String sukunimi;
	private String puhnro;
	private double yhteensa;
	
	private ArrayList<TilausRivi> tilausrivit;
	
	
	public Tilaus(String etunimi, String sukunimi, String puhnro,
			double yhteensa, ArrayList<TilausRivi> tilausrivit) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.puhnro = puhnro;
		this.yhteensa = yhteensa;
		this.tilausrivit = tilausrivit;
	}




	public double getYhteensa() {
		return yhteensa;
	}

	public void setYhteensa(double yhteensa) {
		this.yhteensa = yhteensa;
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

	public ArrayList<TilausRivi> getTilausrivit() {
		return tilausrivit;
	}

	public void setTilausrivit(ArrayList<TilausRivi> tilausrivit) {
		this.tilausrivit = tilausrivit;
	}


	
}
