package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fi.omapizzeria.admin.bean.AdminTilausRivi;
import fi.omapizzeria.admin.bean.Pizza;
import fi.omapizzeria.admin.bean.Tilaus2;

public class AdminTilausDAO extends DataAccessObject{
	
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
			String sql = "Select id, tilausos, postinro, postitmp, tilauspvm, asiaketun, asiaksukun, asiakpuh, hintasumma FROM tilaus";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//K‰yd‰‰n tulokset l‰pi
			while(tulokset.next()) {
				Tilaus2 t = new Tilaus2();
				tilaukset.add(t);
				t.setId(tulokset.getInt("id"));
				t.setEtunimi(tulokset.getString("asiaketun"));
				t.setSukunimi(tulokset.getString("asiaksukun"));
				t.setHintasumma(tulokset.getDouble("hintasumma"));
				t.setPuhnro(tulokset.getString("asiakpuh"));
				t.setTilausos(tulokset.getString("tilausos"));
				t.setTilauspvm( tulokset.getDate("tilauspvm"));
				t.setPostinro(tulokset.getString("postinro"));
				t.setPostitmp(tulokset.getString("postitmp"));
				
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
	
	System.out.println("Haettiin tietokannasta tilaukset: " + tilaukset.toString());
	return tilaukset;

		
	}
	
		//uutta

		
		public List<AdminTilausRivi> find(int tilaus_id) {
			
			ArrayList<AdminTilausRivi> tilausrivit = new ArrayList<AdminTilausRivi>();
			
			//uutta
			PreparedStatement statement = null;
			ResultSet rs = null;
			Connection yhteys = null;
			AdminTilausRivi tilausrivi = null;
			
			try {
				//Ladataan ajuri
				Class.forName(DBConnectionProperties.getInstance().getProperty("driver")).newInstance();
				//Avataan yhteys
				yhteys = DriverManager.getConnection(
						DBConnectionProperties.getInstance().getProperty("url"), 
						DBConnectionProperties.getInstance().getProperty("username"),
						DBConnectionProperties.getInstance().getProperty("password"));
				
				//Suoritetaan haku kantaan
				String sql = "SELECT tilausrivi.id, tilausrivi.tilaus_id, t.nimi as pizza,tilausrivi.maara, tilausrivi.rivihinta FROM tilausrivi INNER JOIN tuote as t ON t.id = tilausrivi.tuote_id WHERE tilaus_id=?";
				System.out.println("Tilaus_id kyselyss‰ on " + tilaus_id);
				statement = yhteys.prepareStatement(sql);
				statement.setInt(1, tilaus_id);
				Statement haku = yhteys.createStatement();
				//ResultSet tulokset = haku.executeQuery(sql);
				
				//uutta
			
				rs = statement.executeQuery();
								
				while(rs.next()) {
					AdminTilausRivi t = new AdminTilausRivi();
					tilausrivit.add(t);
					t.setId(rs.getInt("tilausrivi.id"));
					t.setTilaus_id(rs.getInt("tilausrivi.tilaus_id"));
					t.setPizza(rs.getString("pizza"));
					t.setMaara(rs.getInt("tilausrivi.maara"));
					t.setRivihinta(rs.getDouble("tilausrivi.rivihinta"));

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
			close(rs, statement, yhteys);
		}
		
			return tilausrivit;

			
		}
		
			
	}
	
	
		
