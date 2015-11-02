package fi.omapizzeria.admin.bean;

import java.util.ArrayList;

public class Pizza {
	

	private int id;
	private String nimi;
	private double hinta;
	private ArrayList<Tayte> taytteet;
	

	public Pizza(int id, String nimi, double hinta) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
	}

	
	public int getId(){		
		return id;		
	}
	
	public String getNimi(){		
		return nimi;		
	}
	
	public double getHinta(){		
		return hinta;		
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}


	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	

	public ArrayList<Tayte> getTaytteet() {
		return taytteet;
	}


	public void setTaytteet(ArrayList<Tayte> taytteet) {
		this.taytteet = taytteet;
	}


	@Override
	public String toString() {
		return "Pizza [id=" + id + ", nimi=" + nimi + ", hinta=" + hinta
				+ ", taytteet=" + taytteet + "]";
	}

	

}
