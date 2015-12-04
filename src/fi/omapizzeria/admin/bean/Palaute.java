package fi.omapizzeria.admin.bean;

import java.util.Date;

public class Palaute {

	private int id;
	private String nimi;
	private String sahkoposti;
	private String palautepuh;
	private String viesti;
	private Date pvm;
	
	
	public int getId() {
		return id;
	}
	public String getNimi() {
		return nimi;
	}
	public String getSahkoposti() {
		return sahkoposti;
	}
	public String getPalautepuh() {
		return palautepuh;
	}
	public String getViesti() {
		return viesti;
	}
	public Date getPvm() {
		return pvm;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public void setSahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}
	public void setPalautepuh(String palautepuh) {
		this.palautepuh = palautepuh;
	}
	public void setViesti(String viesti) {
		this.viesti = viesti;
	}
	public void setPvm(Date pvm) {
		this.pvm = pvm;
	}
	public Palaute(int id, String nimi, String sahkoposti, String palautepuh,
			String viesti, Date pvm) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.sahkoposti = sahkoposti;
		this.palautepuh = palautepuh;
		this.viesti = viesti;
		this.pvm = pvm;
	}
	public Palaute(String nimi, String sahkoposti, String palautepuh,
			String viesti, Date pvm) {
		super();
		this.nimi = nimi;
		this.sahkoposti = sahkoposti;
		this.palautepuh = palautepuh;
		this.viesti = viesti;
		this.pvm = pvm;
	}
	@Override
	public String toString() {
		return "Palaute [id=" + id + ", nimi=" + nimi + ", sahkoposti="
				+ sahkoposti + ", palautepuh=" + palautepuh + ", viesti="
				+ viesti + ", pvm=" + pvm + "]";
	}
	
}
