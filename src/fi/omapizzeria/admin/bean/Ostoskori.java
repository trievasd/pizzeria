package fi.omapizzeria.admin.bean;

public class Ostoskori {

	private int tuote_id;
	private double rivihinta;
	private boolean oregano;
	private boolean valkosipuli;
	private String tuote_nimi;
	
	public Ostoskori() 
	{
		
	}
	
	public Ostoskori(int tuote_id, double rivihinta, boolean oregano,
			boolean valkosipuli, String tuote_nimi) {
		
		this.tuote_id = tuote_id;
		this.rivihinta = rivihinta;
		this.oregano = oregano;
		this.valkosipuli = valkosipuli;
		this.tuote_nimi = tuote_nimi;
	}
	
	
	
	@Override
	public String toString() {
		return "Ostoskori [tuote_id=" + tuote_id + ", rivihinta=" + rivihinta
				+ ", oregano=" + oregano + ", valkosipuli=" + valkosipuli
				+ ", tuote_nimi=" + tuote_nimi + "]";
	}
	
	
	public int getTuote_id() {
		return tuote_id;
	}
	public void setTuote_id(int tuote_id) {
		this.tuote_id = tuote_id;
	}
	public double getRivihinta() {
		return rivihinta;
	}
	public void setRivihinta(double rivihinta) {
		this.rivihinta = rivihinta;
	}
	public boolean isOregano() {
		return oregano;
	}
	public void setOregano(boolean oregano) {
		this.oregano = oregano;
	}
	public boolean isValkosipuli() {
		return valkosipuli;
	}
	public void setValkosipuli(boolean valkosipuli) {
		this.valkosipuli = valkosipuli;
	}
	public String getTuote_nimi() {
		return tuote_nimi;
	}
	public void setTuote_nimi(String tuote_nimi) {
		this.tuote_nimi = tuote_nimi;
	}

	
	
	
	
}
