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

public class PizzaDAO {
	
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
			String sql = "SELECT id, nimi, hinta FROM tuote";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//K‰yd‰‰n tulokset l‰pi
			while(tulokset.next()) {	
				int id = tulokset.getInt("id");
				String nimi = tulokset.getString("nimi");
				String strinkhinta = tulokset.getString("hinta");
				
				Double hinta = Double.parseDouble(strinkhinta);
			
				
			//Lis‰t‰‰n pizza listaan
			Pizza p = new Pizza(id, nimi, hinta);
			pizzat.add(p);
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