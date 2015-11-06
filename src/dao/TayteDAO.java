package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.admin.bean.Pizza;
import fi.omapizzeria.admin.bean.Tayte;

public class TayteDAO {
	
	public List<Pizza> haePizzat() {
		
		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
		
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
			String sql = "SELECT t.id, t.nimi as pizza, t.hinta, s1.nimi as tayte1, s2.nimi as tayte2, s3.nimi as tayte3, s4.nimi as tayte4, s5.nimi as tayte5, s6.nimi as tayte6 FROM tuotteentaytteet as tt left JOIN tuote as t ON t.id = tt.tuote_id left JOIN tayte as s1 ON tt.tayte1_id = s1.id left JOIN tayte as s2 ON tt.tayte2_id = s2.id left JOIN tayte as s3 ON tt.tayte3_id = s3.id left JOIN tayte as s4 ON tt.tayte4_id = s4.id left JOIN tayte as s5 ON tt.tayte5_id = s5.id left JOIN tayte as s6 ON tt.tayte6_id = s6.id";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//K‰yd‰‰n tulokset l‰pi
			while(tulokset.next()) {	
				Pizza p = new Pizza();
				pizzat.add(p);
				p.setId(tulokset.getInt("id"));
				p.setNimi(tulokset.getString("pizza"));
				p.setHinta(tulokset.getDouble("hinta"));

				String tayte1 = tulokset.getString("tayte1");
				if (tayte1 != null) {
					p.getTaytteet().add(new Tayte(tayte1));
					String tayte2 = tulokset.getString("tayte2");
					if (tayte2 != null) {
						p.getTaytteet().add(new Tayte(tayte2));
						String tayte3 = tulokset.getString("tayte3");
						if (tayte3 != null) {
							p.getTaytteet().add(new Tayte(tayte3));
							String tayte4 = tulokset.getString("tayte4");
							if (tayte4 != null) {
								p.getTaytteet().add(new Tayte(tayte4));
								String tayte5 = tulokset.getString("tayte5");
								if (tayte5 != null) {
									p.getTaytteet().add(new Tayte(tayte5));
									String tayte6 = tulokset.getString("tayte6");
									if (tayte6 != null) {
										p.getTaytteet().add(new Tayte(tayte6));
									}
								}
							}
						}
					}
				}
				
				
				

			
				
			
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
	
	System.out.println("Haettiin tietokannasta pizzat: " + pizzat.toString());
	return pizzat;

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}