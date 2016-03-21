package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConexionDB;
import util.MiConexionBD;

import beans.NegocioBean;
import interfaces.NegocioDAO;

public class MySqlNegocioDAO implements NegocioDAO {

	@Override
	public int registraNegocio(NegocioBean obj) {
		
		int estado=-1;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			

			conn = ConexionDB.getConexion();

			//conn = new MiConexionBD().getConexion();

			String sql="insert into tb_negocio values(null,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getDireccion());
			pstm.setString(3, obj.getTelefono());
			pstm.setString(4, obj.getEmail());
			pstm.setInt(5, obj.getCod_ubigeo());
			pstm.setInt(6, obj.getId_foto());
			pstm.setString(7, obj.getC_usuario_actualizacion());
			pstm.setString(8, obj.getC_usuario_creacion());
			pstm.setString(9, obj.getD_fecha_creacion());
			pstm.setString(9, obj.getD_fecha_actualizacion());
			pstm.setDouble(10, obj.getCalificacionfinal());
			
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
	public int modificaNegocio(NegocioBean obj) {
			
		int estado=-1;
		Connection conn=null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConexionDB.getConexion();

			//conn = new MiConexionBD().getConexion();

			String sql="update tb_negocio set nom_negocio=?,dir_negocio=?,tel_negocio=?," +
					   "email_negocio=?,cod_ubigeo=?,id_foto=?,c_Usuario_Actualizacion=?, "+
					   "c_Usuario_Creacion=?,d_fecha_creacion=?,d_fecha_actualizacion=?,calificacion_final=? where id_negocio=?";
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getDireccion());
			pstm.setString(3, obj.getTelefono());
			pstm.setString(4, obj.getEmail());
			pstm.setInt(5, obj.getCod_ubigeo());
			pstm.setInt(6, obj.getId_foto());
			pstm.setString(7, obj.getC_usuario_actualizacion());
			pstm.setString(8, obj.getC_usuario_creacion());
			pstm.setString(9, obj.getD_fecha_creacion());
			pstm.setString(9, obj.getD_fecha_actualizacion());
			pstm.setDouble(10, obj.getCalificacionfinal());
			
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
	public List<NegocioBean> buscarnegocio(String nombre, String dist)
			throws SQLException {
	
		List<NegocioBean> salida = new ArrayList<NegocioBean>();
		
		NegocioBean nb = null;
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {

			conn = ConexionDB.getConexion();
			//conn = new MiConexionBD().getConexion();

			String sql="select dir_negocio,tel_negocio,email_negocio" +
					"from tb_negocio n inner join tb_ubigeo ub" +
					"on n.cod_ubigeo = ub.cod_ubigeo " +
					"where nom_negocio=? and distrito=?";
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, nombre);
			pstm.setString(2, dist);
			
			rs = pstm.executeQuery();
			
			if(rs.next()){
				nb = new NegocioBean();
				nb.setId_negocio(rs.getInt(1));
				nb.setNombre(rs.getString(2));
				nb.setDireccion(rs.getString(3));
				nb.setTelefono(rs.getString(4));
				nb.setEmail(rs.getString(5));
				nb.setCod_ubigeo(rs.getInt(6));
				nb.setId_foto(rs.getInt(7));
				nb.setC_usuario_actualizacion(rs.getString(8));
				nb.setC_usuario_creacion(rs.getString(9));
				nb.setD_fecha_creacion(rs.getString(10));
				nb.setD_fecha_actualizacion(rs.getString(11));
				nb.setCalificacionfinal(rs.getDouble(12));
				salida.add(nb);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			try {
				if(conn!=null)
					conn.close();
				if(pstm!=null)
					pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return salida;
	}


}
