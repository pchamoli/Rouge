package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< HEAD
import util.ConexionDB;
=======
import util.MiConexionBD;
>>>>>>> refs/remotes/origin/branch1

import beans.UsuarioBean;
import interfaces.UsuarioDAO;

public class MySqlUsuarioDAO implements UsuarioDAO {

	@Override

	public int registrarUsuario(UsuarioBean obj){
		return 0;
	}
		
	@Override
	public UsuarioBean loguearUsuario(String login, String clave){
		return null;
	}
	
	@Override
	public UsuarioBean obtenerDatosUsuario(String codigoUsuario){
		return null;
	}
	
	@Override
	public int cerrarSesion(String codigoUsuario){
		return 0;
	}
	
	/*
	@Override

	public int RegistraUsuario(UsuarioBean obj) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try{
			cn= ConexionDB.getConexion();
			//String sql="insert into tb_usuario values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			//cn= new MiConexionBD().getConexion();
			String sql="insert into tb_usuario(id_usuario,nom_usuario,fecha_nac,email,d_fecha_creacion,codigo_usuario,contrasena,ubigeo,sexo) values(null,?,STR_TO_DATE(?,'%d-%m-%Y'),?,?,?,?,?,?)";

			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getFechanac());
			pstm.setString(3, obj.getEmail());
			pstm.setString(4, obj.getFecha_creacion());
			//pstm.setString(5, obj.getFecha_actualizacion());
			//pstm.setString(6, obj.getUsuario_actualizacion());
			//pstm.setString(7, obj.getUsuario_creacion());
			pstm.setString(5, obj.getCodigo_usuario());
			//pstm.setString(5, obj.getEstado());
			pstm.setString(6, obj.getContrasena());
			//pstm.setInt(6, obj.getTipo_usuario());
			//pstm.setInt(7, obj.getTipo_documento());
			pstm.setInt(7, obj.getUbigeo());
			pstm.setString(9, obj.getSexo());

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
		

			//conn = ConexionDB.getConexion();

			conn = new MiConexionBD().getConexion();

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
			pstm.setString(10, obj.getEstado());
			pstm.setString(11, obj.getContrasena());
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

			/*conn = new MiConexionBD().getConexion();
			String sql="select id_usuario,nom_usuario,fecha_nac,email,d_fecha_creacion,codigo_usuario,contrasena,ubigeo,sexo from tb_usuario where email=?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, correo);	
			
			rs = pstm.executeQuery();
			
			if(rs.next()){
				usu = new UsuarioBean();
				usu.setId(rs.getInt(1));
				usu.setNombre(rs.getString(2));
				usu.setFechanac(rs.getString(3));
				usu.setEmail(rs.getString(4));
				usu.setFecha_creacion(rs.getString(5));
				//usu.setFecha_actualizacion(rs.getString(6));
				//usu.setUsuario_actualizacion(rs.getString(7));
				//usu.setUsuario_creacion(rs.getString(8));
				usu.setCodigo_usuario(rs.getString(6));
				//usu.setNombre(rs.getString(10));
				///usu.setEstado(rs.getString(11));
				usu.setContrasena(rs.getString(7));
				//usu.setTipo_usuario(rs.getInt(13));
				//usu.setCod_tipo_documento(rs.getInt(14));
				usu.setUbigeo(rs.getInt(8));
				usu.setSexo(rs.getString(9));
				
			}
			
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

	}*/

}


