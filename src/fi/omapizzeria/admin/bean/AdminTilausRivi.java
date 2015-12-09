package fi.omapizzeria.admin.bean;

public class AdminTilausRivi {
	
	private int id;
	private int tilaus_id;
	private String pizza;
	private int maara;
	private double rivihinta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTilaus_id() {
		return tilaus_id;
	}
	public void setTilaus_id(int tilaus_id) {
		this.tilaus_id = tilaus_id;
	}
	public String getPizza() {
		return pizza;
	}
	public void setPizza(String pizza) {
		this.pizza = pizza;
	}
	public int getMaara() {
		return maara;
	}
	public void setMaara(int maara) {
		this.maara = maara;
	}
	public double getRivihinta() {
		return rivihinta;
	}
	public void setRivihinta(double rivihinta) {
		this.rivihinta = rivihinta;
	}
	@Override
	public String toString() {
		return "AdminTilausRivi [id=" + id + ", tilaus_id=" + tilaus_id
				+ ", pizza=" + pizza + ", maara=" + maara + ", rivihinta="
				+ rivihinta + "]";
	}
	public AdminTilausRivi(int id, int tilaus_id, String pizza, int maara,
			double rivihinta) {
		super();
		this.id = id;
		this.tilaus_id = tilaus_id;
		this.pizza = pizza;
		this.maara = maara;
		this.rivihinta = rivihinta;
	}
	public AdminTilausRivi() {
		// TODO Auto-generated constructor stub
	}

}
