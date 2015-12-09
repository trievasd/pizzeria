package fi.omapizzeria.admin.bean;



public class Hintaryhma {
	

	private int id;
	private String nimi;
	private double ryhmahinta;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public double getRyhmahinta() {
		return ryhmahinta;
	}
	public void setRyhmahinta(double ryhmahinta) {
		this.ryhmahinta = ryhmahinta;
	}
	@Override
	public String toString() {
		return "Hintaryhma [id=" + id + ", nimi=" + nimi + ", ryhmahinta="
				+ ryhmahinta + "]";
	}
	
	public Hintaryhma(int id, String nimi, double ryhmahinta) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.ryhmahinta = ryhmahinta;
	}


}
