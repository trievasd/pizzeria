package fi.omapizzeria.admin.bean;

public class Tayte {
	private String nimi;
	
	public Tayte(String nimi) {
		this.nimi = nimi;
	}
	
	

	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	@Override
	public String toString() {
		return "Tayte [nimi=" + nimi + "]";
	}
}
