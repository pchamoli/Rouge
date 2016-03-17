package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MiConexionBD {

	public Connection getConexion(){
		Connection cn=null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rouge","root","mysql");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return cn;
	}
}
