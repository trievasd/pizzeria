package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.admin.bean.Pizza;
import fi.omapizzeria.admin.bean.Tayte;
import dao.DataAccessObject;

public class OstoskoriDAO extends DataAccessObject {
	
	//uutta
	private Pizza read(ResultSet resultSet) throws SQLException {
		int tuoteid = new Integer(resultSet.getInt("t.id"));
		String nimi = resultSet.getString("pizza");
		double hinta = new Double(resultSet.getDouble("hinta"));
		Pizza pizza = new Pizza();
		pizza.setId(tuoteid);
		pizza.setNimi(nimi);
		pizza.setHinta(hinta);
		return pizza;
		}
	
	public Pizza find(int tuoteid) {
		
		
		//uutta
		PreparedStatement statement = null;
		ResultSet rs = null;
		Connection yhteys = null;
		Pizza pizza = null;
		
		try {
			//Ladataan ajuri
			Class.forName(DBConnectionProperties.getInstance().getProperty("driver")).newInstance();
			//Avataan yhteys
			yhteys = DriverManager.getConnection(
					DBConnectionProperties.getInstance().getProperty("url"), 
					DBConnectionProperties.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance().getProperty("password"));
			
			//Suoritetaan haku kantaan
			String sql = "SELECT t.id, t.nimi as pizza, h.ryhmahinta as hinta, s1.nimi as tayte1, s2.nimi as tayte2, s3.nimi as tayte3, s4.nimi as tayte4, s5.nimi as tayte5, s6.nimi as tayte6 FROM tuotteentaytteet as tt left JOIN tuote as t ON t.id = tt.tuote_id left JOIN hintaryhma as h ON h.id = t.hinta_id left JOIN tayte as s1 ON tt.tayte1_id = s1.id left JOIN tayte as s2 ON tt.tayte2_id = s2.id left JOIN tayte as s3 ON tt.tayte3_id = s3.id left JOIN tayte as s4 ON tt.tayte4_id = s4.id left JOIN tayte as s5 ON tt.tayte5_id = s5.id left JOIN tayte as s6 ON tt.tayte6_id = s6.id WHERE t.id=?";
			System.out.println("Tuoteid kyselyss‰ on " + tuoteid);
			statement = yhteys.prepareStatement(sql);
			statement.setInt(1, tuoteid);
			Statement haku = yhteys.createStatement();
			//ResultSet tulokset = haku.executeQuery(sql);
			
			//uutta
		
			rs = statement.executeQuery();
			if (!rs.next()){
				pizza = null;
			}else{
			pizza = read(rs);
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
	
		return pizza;

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}