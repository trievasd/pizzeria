package pizzeria.admin.bean;

public class Pizza {
	
	public Pizza(int id, String nimi, double hinta) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;


	}



	int id;
	String nimi;
	double hinta;
	
	
	
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

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", nimi=" + nimi + ", hinta=" + hinta + "]";
	}



}
