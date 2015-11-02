package fi.omapizzeria.admin.bean;

public class Tayte {
	private int id;
	private String nimi;
	
	public Tayte(int id, String nimi) {
		this.id = id;
		this.nimi = nimi;
	}
	
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
	
	@Override
	public String toString() {
		return "Tayte [id=" + id + ", nimi=" + nimi + "]";
	}
}
