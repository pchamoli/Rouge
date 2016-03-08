package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

	public static Connection getConexion(){
		Connection cn=null;
		
		try{
			
			Class.forName("com.mysql.jdbc.driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/rouge/","root","mysql");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return cn;
	}
}
