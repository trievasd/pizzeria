package fi.omapizzeria.admin.bean;

public class TilausRivi {

	private int id;
	private int maara;
	private int tilaus_id;
	private int tuote_id;
	private double rivihinta;
	private boolean oregano;
	private boolean valkosipuli;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaara() {
		return maara;
	}
	public void setMaara(int maara) {
		this.maara = maara;
	}
	public int getTilaus_id() {
		return tilaus_id;
	}
	public void setTilaus_id(int tilaus_id) {
		this.tilaus_id = tilaus_id;
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
	
	@Override
	public String toString() {
		return "TilausRivi [id=" + id + ", maara=" + maara + ", tilaus_id="
				+ tilaus_id + ", tuote_id=" + tuote_id + ", rivihinta="
				+ rivihinta + ", oregano=" + oregano + ", valkosipuli="
				+ valkosipuli + "]";
	}
	
	public TilausRivi(int id, int maara, int tilaus_id, int tuote_id,
			double rivihinta, boolean oregano, boolean valkosipuli) {
		super();
		this.id = id;
		this.maara = maara;
		this.tilaus_id = tilaus_id;
		this.tuote_id = tuote_id;
		this.rivihinta = rivihinta;
		this.oregano = oregano;
		this.valkosipuli = valkosipuli;
	}
	
	public TilausRivi(int maara, int tilaus_id, int tuote_id,
			double rivihinta, boolean oregano, boolean valkosipuli) {
		super();
		this.maara = maara;
		this.tilaus_id = tilaus_id;
		this.tuote_id = tuote_id;
		this.rivihinta = rivihinta;
		this.oregano = oregano;
		this.valkosipuli = valkosipuli;
	}
	
	
}
