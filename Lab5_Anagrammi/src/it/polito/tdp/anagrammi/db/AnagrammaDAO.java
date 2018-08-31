package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AnagrammaDAO {

	public boolean isCorrect(String anagramma){

		String sql = 
				"SELECT nome " +
				"FROM parola " +
				"WHERE nome=?" ;
		
		String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=piradime" ;
		boolean result;
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL) ;
			
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			st.setString(1, anagramma);
			
			ResultSet res = st.executeQuery() ;
			
			if(res.next()) {
				result = true;
				
			} else {
				result = false;
			}
			
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false ;
		}
		return result ;
	}
	
}

