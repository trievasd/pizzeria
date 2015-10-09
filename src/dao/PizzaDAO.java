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
import fi.softala.jee.demo.d08.bean.Henkilo;
import fi.softala.jee.demo.d08.dao.DAOPoikkeus;

public class PizzaDAO {
	
	public List<Pizza> haeKaikki() {
		
		
		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
		
		Connection yhteys = null;
		
		try {
			//YHTEYDEN AVAUS JA HAKU
			//ajurin lataus
			Class.forName(DBConnectionProperties.getInstance().getProperty("driver")).newInstance();
			//avataan yhteys
			yhteys = DriverManager.getConnection(
					DBConnectionProperties.getInstance().getProperty("url"), 
					DBConnectionProperties.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance().getProperty("password"));
			
			//suoritetaan haku
			String sql = "select ID, Nimi, Hinta from Pizza";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//k�yd��n hakutulokset l�pi
			while(tulokset.next()) {
				int id = tulokset.getInt("ID");
				String nimi = tulokset.getString("Nimi");
				String strinkhinta = tulokset.getString("Hinta");
				
				Double hinta = Double.parseDouble(strinkhinta);
				
				//lis�t��n henkil� listaan
				Pizza h = new Pizza(id, nimi, hinta);
				pizzat.add(h);
			}
		} catch(IOException e) {
			System.out.println("Tietokantayhteyden asetuksien hakeminen aiheutti virheen.");
			e.printStackTrace();
		} catch(Exception e) {
			//JOTAIN VIRHETT� TAPAHTUI
			System.out.println("Tietokantahaku aiheutti virheen");
			e.printStackTrace();
		}finally {
			//LOPULTA AINA SULJETAAN YHTEYS
			try {
				if (yhteys != null && !yhteys.isClosed())
					yhteys.close();
			} catch(Exception e) {
				System.out.println("Tietokantayhteys ei jostain syyst� suostu menem��n kiinni.");
				e.printStackTrace();
			}
		}
		
		System.out.println("HAETTIIN TIETOKANNASTA HENKIL�T: " +pizzat.toString());
		return pizzat;
	}
	public void lisaa(Pizza h) throws DAOPoikkeus{
		
		//avataan yhteys
		Connection yhteys = avaaYhteys();
		
		try {
			
			//suoritetaan haku
			
			//alustetaan sql-lause
			String sql = "insert into henkilo(etunimi, sukunimi) values(?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			
			//t�ytet��n puuttuvat tiedot
			lause.setString(1, h.getEtunimi());
			lause.setString(2, h.getSukunimi());
			
			//suoritetaan lause
			lause.executeUpdate();
			System.out.println("LIS�TTIIN HENKIL� TIETOKANTAAN: "+h);
		} catch(Exception e) {
			//JOTAIN VIRHETT� TAPAHTUI
			throw new DAOPoikkeus("Henkil�n lis��misyritys aiheutti virheen", e);
		}finally {
			//LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys(yhteys);
		}

	}

}
