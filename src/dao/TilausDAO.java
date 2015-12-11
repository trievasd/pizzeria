package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fi.omapizzeria.admin.bean.AdminTilausRivi;
import fi.omapizzeria.admin.bean.Palaute;
import fi.omapizzeria.admin.bean.Tilaus2;
import fi.omapizzeria.admin.bean.TilausRivi;

public class TilausDAO {


	public TilausDAO() throws DAOPoikkeus {
		try {
			Class.forName(DBConnectionProperties.getInstance().getProperty("driver")).newInstance();
		} catch(Exception e) {
			throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
		}
	}
	
	private Connection avaaYhteys() throws DAOPoikkeus {
		
		try {
			return DriverManager.getConnection(
					DBConnectionProperties.getInstance().getProperty("url"), 
					DBConnectionProperties.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance().getProperty("password"));
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokantayhteyden avaaminen epäonnistui", e);
		}
	}
	
	private void suljeYhteys(Connection yhteys) throws DAOPoikkeus {
		try {
			if (yhteys != null && !yhteys.isClosed())
				yhteys.close();
		} catch(Exception e) {
			throw new DAOPoikkeus("Tietokantayhteys ei jostain syystä suostu menemään kiinni.", e);
		}
	}
	
	/**
	 * Hakee kaikki palautteet kannasta
	 * @return listallinen palautteita
	 */
	public int haeTilaus(Date nykyhetki) throws DAOPoikkeus{		
		
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	
		int tilaus_id = 0;
		
		//avataan yhteys
		PreparedStatement statement = null;
		ResultSet rs = null;
		Connection yhteys = avaaYhteys();
		
		try {
			
			//suoritetaan haku
			System.out.println("kantatest" + formatter.format(nykyhetki).toString());
			String sql = "Select id, tilauspvm FROM tilaus WHERE tilauspvm = ?";
			statement = yhteys.prepareStatement(sql);
			statement.setString(1, formatter.format(nykyhetki).toString());;
			Statement haku = yhteys.createStatement();
			rs = statement.executeQuery();
			
			while(rs.next()) {
				tilaus_id = rs.getInt("id");
			}
			//käydään hakutulokset läpi
			
			

			
			
		} catch(Exception e) {
			//JOTAIN VIRHETTÄ TAPAHTUI
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}finally {
			//LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys(yhteys);
		}
		
		System.out.println("HAETTIIN TIETOKANNASTA tilausID: " +tilaus_id);
		
		return tilaus_id;
}
	
	
	/**
	 * Lisää palautteen tietokantaan
	 * @param t Lisättävän palautteen tiedot
	 */
	public void lisaa(Tilaus2 t) throws DAOPoikkeus{
			
		//avataan yhteys
		Connection yhteys = avaaYhteys();
		
		try {
			
			//suoritetaan haku
			SimpleDateFormat formatter;
			formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			
			//alustetaan sql-lause
			String sql = "INSERT INTO tilaus (tilausos, postinro, postitmp, tilauspvm, hintasumma, asiaketun, asiaksukun, asiakpuh) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			
			//daten testaus, miksi ei mennyt kantaan ja missä mmuodossa on
			//System.out.println("testi "+formatter.format(p.getPvm()).toString());
			
			//täytetään puuttuvat tiedot
			lause.setString(1, t.getTilausos());
			lause.setString(2, t.getPostinro());
			lause.setString(3, t.getPostitmp());
			lause.setString(4, formatter.format(t.getTilauspvm()).toString());
			lause.setDouble(5, t.getHintasumma());
			lause.setString(6, t.getEtunimi());
			lause.setString(7, t.getSukunimi());
			lause.setString(8, t.getPuhnro());
			
			
			//suoritetaan lause
			lause.executeUpdate();
			System.out.println("LISÄTTIIN TILAUS TIETOKANTAAN: "+t);
		} catch(Exception e) {
			//JOTAIN VIRHETTÄ TAPAHTUI
			throw new DAOPoikkeus("Tilauksen lisäämisyritys aiheutti virheen", e);
		}finally {
			//LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys(yhteys);
		}

	}
	
	public void lisaaRivi(TilausRivi til) throws DAOPoikkeus{
		
		//avataan yhteys
		Connection yhteys = avaaYhteys();
		
		try {
			
			//suoritetaan haku
			SimpleDateFormat formatter;
			formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			
			//alustetaan sql-lause
			String sql = "INSERT INTO tilausrivi (maara, tilaus_id, tuote_id, rivihinta, oregano, valkosipuli) VALUES(?,?,?,?,?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			
			//daten testaus, miksi ei mennyt kantaan ja missä mmuodossa on
			//System.out.println("testi "+formatter.format(p.getPvm()).toString());
			
			//täytetään puuttuvat tiedot
			lause.setInt(1, til.getMaara());
			lause.setInt(2, til.getTilaus_id());
			lause.setInt(3, til.getTuote_id());
			lause.setDouble(4, til.getRivihinta());
			lause.setBoolean(5, til.isOregano());
			lause.setBoolean(6, til.isValkosipuli());

			
			
			//suoritetaan lause
			lause.executeUpdate();
			System.out.println("LISÄTTIIN TILAUSRivi TIETOKANTAAN: "+til);
		} catch(Exception e) {
			//JOTAIN VIRHETTÄ TAPAHTUI
			throw new DAOPoikkeus("Tilauksen lisäämisyritys aiheutti virheen", e);
		}finally {
			//LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys(yhteys);
		}

	}
	
	
	
	

}
