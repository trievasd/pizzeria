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

import fi.omapizzeria.admin.bean.Tilaus2;

public class AdminTilausDAO {
	
	public List<Tilaus2> haeTilaukset() {
		
		ArrayList<Tilaus2> tilaukset = new ArrayList<Tilaus2>();
		
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
			String sql = "Select id, tilausos, postinro, tilauspvm, asiaketun, asiaksukun, asiakpuh FROM tilaus";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//K‰yd‰‰n tulokset l‰pi
			while(tulokset.next()) {
				Tilaus2 t = new Tilaus2();
				tilaukset.add(t);
				t.setId(tulokset.getInt("id"));
				t.setEtunimi(tulokset.getString("nimi"));
				t.setSukunimi(tulokset.getString("nimi"));
				t.setSahkoposti(tulokset.getString("sahkoposti"));
				t.setPalautepuh(tulokset.getString("palautepuh"));
				t.setViesti(tulokset.getString("viesti"));
				t.setPvm( tulokset.getDate("pvm"));
		
			
				

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