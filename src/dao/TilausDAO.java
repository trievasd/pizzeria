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

import fi.omapizzeria.admin.bean.Palaute;
import fi.omapizzeria.admin.bean.Tilaus2;

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
			throw new DAOPoikkeus("Tietokantayhteyden avaaminen ep�onnistui", e);
		}
	}
	
	private void suljeYhteys(Connection yhteys) throws DAOPoikkeus {
		try {
			if (yhteys != null && !yhteys.isClosed())
				yhteys.close();
		} catch(Exception e) {
			throw new DAOPoikkeus("Tietokantayhteys ei jostain syyst� suostu menem��n kiinni.", e);
		}
	}
	
	/**
	 * Hakee kaikki palautteet kannasta
	 * @return listallinen palautteita
	 */
	public List<Palaute> haePalautteet() throws DAOPoikkeus{		
		
		ArrayList<Palaute> palautteet = new ArrayList<Palaute>();
		
		//avataan yhteys
		Connection yhteys = avaaYhteys();
		
		try {
			
			//suoritetaan haku
			String sql = "Select id, pvm, nimi, sahkoposti, palautepuh, viesti FROM palaute";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//k�yd��n hakutulokset l�pi
			while(tulokset.next()) {
				int id = tulokset.getInt("id");
				String nimi = tulokset.getString("nimi");
				String sahkoposti = tulokset.getString("sahkoposti");
				String palautepuh = tulokset.getString("palautepuh");
				String viesti = tulokset.getString("viesti");
				Date pvm = tulokset.getDate("pvm");
				
				//lis�t��n henkil� listaan
				Palaute p = new Palaute(id, nimi, sahkoposti, palautepuh, viesti, pvm);
				palautteet.add(p);
			}
			
		} catch(Exception e) {
			//JOTAIN VIRHETT� TAPAHTUI
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}finally {
			//LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys(yhteys);
		}
		
		System.out.println("HAETTIIN TIETOKANNASTA palautteet: " +palautteet.toString());
		
		return palautteet;
	}
	
	
	/**
	 * Lis�� palautteen tietokantaan
	 * @param t Lis�tt�v�n palautteen tiedot
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
			
			//daten testaus, miksi ei mennyt kantaan ja miss� mmuodossa on
			//System.out.println("testi "+formatter.format(p.getPvm()).toString());
			
			//t�ytet��n puuttuvat tiedot
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
			System.out.println("LIS�TTIIN TILAUS TIETOKANTAAN: "+t);
		} catch(Exception e) {
			//JOTAIN VIRHETT� TAPAHTUI
			throw new DAOPoikkeus("Tilauksen lis��misyritys aiheutti virheen", e);
		}finally {
			//LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys(yhteys);
		}

	}
	
	
	
	

}
