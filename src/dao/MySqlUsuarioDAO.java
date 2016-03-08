package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConexionDB;

import beans.UsuarioBean;
import interfaces.UsuarioDAO;

public class MySqlUsuarioDAO implements UsuarioDAO {

	@Override
	public int RegistraUsuario(UsuarioBean obj) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try{
			cn= ConexionDB.getConexion();
			String sql="insert into tb_usuario values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getFechanac());
			pstm.setString(3, obj.getEmail());
			pstm.setString(4, obj.getFecha_creacion());
			pstm.setString(5, obj.getFecha_actualizacion());
			pstm.setString(6, obj.getUsuario_actualizacion());
			pstm.setString(7, obj.getUsuario_creacion());
			pstm.setString(8, obj.getCodigo_usuario());
			pstm.setString(9, obj.getNombre());
			pstm.setInt(10, obj.getEstado());
			pstm.setString(11, obj.getContraseña());
			pstm.setInt(12, obj.getTipo_usuario());
			pstm.setInt(13, obj.getTipo_documento());
			pstm.setInt(14, obj.getUbigeo());
			pstm.setString(15, obj.getSexo());
			estado = pstm.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		try{
			if(cn!=null)
				cn.close();
			if(pstm!=null)
				pstm.close();
		}catch(Exception e2){
			e2.printStackTrace();
		}
			}
		return estado;
	}

	@Override
	public int ModificaUsuario(UsuarioBean obj) {
		
		int estado=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
		
			conn = ConexionDB.getConexion();
			String sql="UPDATE tb_usuario" +
					  " set nom_usuario=?,fecha_nac=?," +
					  " email=?,d_fecha_creacion=?,d_fecha_actualizacion=?," +
					  " c_usuario_creacion=?,codigo_usuario=?,estado=?,contraseña=?," +
					  " tipo_usuario=?,numero_documento=?,tipo_documento=?,ubigeo=?,sexo=? where id_usuario=?";
			
			pstm =conn.prepareStatement(sql);
			pstm.setString(1,obj.getNombre());
			pstm.setString(2,obj.getFechanac());
			pstm.setString(3,obj.getEmail());
			pstm.setString(4, obj.getFecha_creacion());
			pstm.setString(5, obj.getFecha_actualizacion());
			pstm.setString(6, obj.getUsuario_actualizacion());
			pstm.setString(7, obj.getUsuario_creacion());
			pstm.setString(8, obj.getCodigo_usuario());
			pstm.setString(9, obj.getNombre());
			pstm.setInt(10, obj.getEstado());
			pstm.setString(11, obj.getContraseña());
			pstm.setInt(12, obj.getTipo_usuario());
			pstm.setInt(13, obj.getTipo_documento());
			pstm.setInt(14, obj.getUbigeo());
			pstm.setString(15, obj.getSexo());
			
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
	public UsuarioBean logueausuario(String login, String clave) {
		
		UsuarioBean usu = null;
		Connection conn= null;
		PreparedStatement pstm= null;
		ResultSet rs= null;
		
		try {
			
			conn = ConexionDB.getConexion();
			String sql="select * from tb_usuario where codigo_usuario=? and contraseña=?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, login);
			pstm.setString(2, clave);
			
			rs = pstm.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally{
			try{
				if(conn!=null)
					conn.close();
				if(pstm!=null)
					pstm.close();
				if(rs!=null)
					rs.close();
			}catch(SQLException e2){
				e2.printStackTrace();
			}
		}
		return usu;
	}
		}

