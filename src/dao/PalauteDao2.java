package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fi.omapizzeria.admin.bean.Palaute;
import fi.omapizzeria.admin.bean.Pizza;

public class PalauteDao2 {
	
	public List<Palaute> haePalautteet() {
		
		//admin sivun palautteiden hakemiseen tarkoitettu DAO
		
		ArrayList<Palaute> palautteet = new ArrayList<Palaute>();
		
		Connection yhteys = null;
		
		try {
			//Ladataan ajuri
			Class.forName(DBConnectionProperties.getInstance().getProperty("driver")).newInstance();
			//Avataan yhteys
			yhteys = DriverManager.getConnection(
					DBConnectionProperties.getInstance().getProperty("url"), 
					DBConnectionProperties.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance().getProperty("password"));
			
			//Suoritetaan haku kantaan
			String sql = "Select id, pvm, nimi, sahkoposti, palautepuh, viesti FROM palaute";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//K‰yd‰‰n tulokset l‰pi
			while(tulokset.next()) {
				Palaute p = new Palaute();
				palautteet.add(p);
				p.setId(tulokset.getInt("id"));
				p.setNimi(tulokset.getString("nimi"));
				p.setSahkoposti(tulokset.getString("sahkoposti"));
				p.setPalautepuh(tulokset.getString("palautepuh"));
				p.setViesti(tulokset.getString("viesti"));
				p.setPvm( tulokset.getDate("pvm"));
		
			
				

		}
		
	}catch(IOException e) {
		//Virheilmoitus
		System.out.println("Tietokantayhteyden asetuksien hakeminen aiheutti virheen.");
		e.printStackTrace();
	} catch(Exception e) {
		//Virheilmoitus
		System.out.println("Tietokantahaku aiheutti virheen");
		e.printStackTrace();
	}finally {
		//Suljetaan yhteys
		try {
			if (yhteys != null && !yhteys.isClosed())
				yhteys.close();
		} catch(Exception e) {
			System.out.println("Tietokantayhteys ei jostain syyst‰ suostu menem‰‰n kiinni.");
			e.printStackTrace();
		}
	}
	
	System.out.println("Haettiin tietokannasta palautteet: " + palautteet.toString());
	return palautteet;

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}