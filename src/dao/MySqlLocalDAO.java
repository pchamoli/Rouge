package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConexionDB;

import beans.LocalBean;
import interfaces.LocalDAO;

public class MySqlLocalDAO implements LocalDAO {

	@Override
	public LocalBean buscarlocalxnombre(String lugar, String nombre){
		
		LocalBean lb = null;
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = ConexionDB.getConexion();
			String sql="select * from local where dir_local=? and nom_local=?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, lugar);
			pstm.setString(2, nombre);
			
			rs= pstm.executeQuery();
			
			if(rs.next()){
				lb = new LocalBean();
				lb.setId(rs.getInt(1));
				lb.setNom_local(rs.getString(2));
				lb.setDir_local(rs.getString(3));
				lb.setTel_local(rs.getString(4));
				lb.setEmail(rs.getString(5));
				lb.setCod_ubigeo(rs.getInt(6));
				lb.setId_negocio(rs.getInt(7));
				lb.setC_Usuario_Actualizacion(rs.getString(8)); 
				lb.setC_Usuario_Creacion(rs.getString(9));
				lb.setD_fecha_creacion(rs.getString(10));
				lb.setD_fecha_actualizacion(rs.getString(11));	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null)
					conn.close();
				if(pstm!=null)
					pstm.close();
				if(rs!=null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lb;
		
	}

}
