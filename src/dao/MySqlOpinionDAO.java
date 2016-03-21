package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import util.ConexionDB;
import util.MiConexionBD;


import beans.OpinionBean;
import interfaces.OpinionDAO;

public class MySqlOpinionDAO implements OpinionDAO {

	@Override
	public int registraopinion(OpinionBean obj) {
		
		int estado=-1;
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {

			conn = ConexionDB.getConexion();

			//conn = new MiConexionBD().getConexion();

			String sql = "insert into tb_opinion values(null,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, obj.getTitulo());
			pstm.setString(2, obj.getDescripcion());
			pstm.setInt(3, obj.getCalificacion());
			pstm.setInt(4, obj.getId_usuario());
			pstm.setString(5, obj.getC_Usuario_Actualizacion());
			pstm.setString(6, obj.getC_Usuario_Creacion());
			pstm.setString(7, obj.getD_fecha_creacion());
			pstm.setString(8, obj.getD_fecha_actualizacion());
			pstm.setInt(9, obj.getId_local());
			
			estado = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null)
					conn.close();
				if(pstm!=null)
					pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return estado;
	}

	@Override
	public List<OpinionBean> listaropinionesxlocal() throws SQLException {
		
		List <OpinionBean> salida = new ArrayList<OpinionBean>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			

			conn = ConexionDB.getConexion();

			//conn = new MiConexionBD().getConexion();

			String sql="SELECT op.titulo,op.calificacion,lc.nom_local FROM tb_opinion op inner join tb_local lc on lc.id_local=op.id_local" +
					"where lc.nom_local=?";
			
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			OpinionBean op = null;
			
			while(rs.next()){
				op = new OpinionBean();
				op.setId_opinion(rs.getInt(1));
				op.setTitulo(rs.getString(2));
				op.setDescripcion(rs.getString(3));
				op.setCalificacion(rs.getInt(4));
				op.setNombreusuario(rs.getString(5));
				op.setC_Usuario_Actualizacion(rs.getString(6));
				op.setC_Usuario_Creacion(rs.getString(7));
				op.setD_fecha_creacion(rs.getString(8));
				op.setD_fecha_actualizacion(rs.getString(9));
				op.setNomlocal(rs.getString(10));
				
				salida.add(op);
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
		
		return salida;

}}
