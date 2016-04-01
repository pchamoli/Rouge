package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import util.ConexionDB;
import util.MiConexionBD;

import beans.UsuarioBean;
import beans.Resultado;
import interfaces.UsuarioDAO;

public class MySqlUsuarioDAO implements UsuarioDAO {

	@Override

	/*public int registrarUsuario(UsuarioBean obj){
		return 0;
	}*/
	public Resultado registrarUsuario(UsuarioBean obj){
	
		int id=0;
		int codigoRetorno=0;
		Resultado res = new Resultado();
		UsuarioBean ur = new UsuarioBean();
		
		Connection conn = null;
		
		try {
			conn = new MiConexionBD().getConexion();
			
			CallableStatement cstm = conn.prepareCall("{call P_INS_REGISTRAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstm.setInt(1, 0);
			cstm.setString(2, obj.getNombre());
			cstm.setString(3, obj.getFechanac());
			cstm.setString(4, obj.getEmail());
			cstm.setString(5, obj.getFecha_creacion());
			cstm.setString(6, obj.getFecha_actualizacion());
			cstm.setString(7, obj.getUsuario_creacion());
			cstm.setString(8,obj.getUsuario_actualizacion());
			cstm.setString(9,obj.getCodigo_usuario());
			cstm.setString(10,obj.getEstado());
			cstm.setString(11,obj.getContrasena());
			cstm.setInt(12,obj.getTipo_usuario());
			cstm.setInt(13,obj.getNumero_documento());
			cstm.setInt(14,obj.getTipo_documento());
			cstm.setInt(15,obj.getUbigeo());
			cstm.setString(16,obj.getSexo());
			cstm.setInt(17,0);
			
			cstm.registerOutParameter("id", Types.INTEGER);
			cstm.registerOutParameter("codigoRetorno", Types.INTEGER);
			
			cstm.executeUpdate();
			
			codigoRetorno = cstm.getInt(17);
			id = cstm.getInt(1);
			obj.setId(id);
			
			System.out.println(codigoRetorno);
			System.out.println("Usuario registrado");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Invocar a P_INS_REGISTRAR_USUARIO con los parámetros indicados en obj
				
		// Obtener el id del usuario e ingresarlo en el obj
		
		// Se envía obj como retorno
		res.setCodigo(codigoRetorno);
		res.setMensaje("");
		
		return res;
	}
		
	@Override
	public Resultado loguearUsuario(String login, String clave){
		int codigoRetorno=0;
		String codigoUsuario="";
		
		UsuarioBean usuario = null;
		Resultado res = new Resultado();
		
		/* lógica de negocio aquí */
		
		/* fin lógica de negocio */
		
		// Invocar a P_LOGUEAR_USUARIO con login y clave
		Connection conn = null;

		try {
			conn = new MiConexionBD().getConexion();
			
			CallableStatement cstm = conn.prepareCall("{call P_LOGUEAR_USUARIO(?,?,?,?)}");
			
			cstm.setString(1, login);
			cstm.setString(2, clave);
			
			cstm.registerOutParameter(3, Types.INTEGER);
			cstm.setInt(3, 0);
			cstm.registerOutParameter(4, Types.VARCHAR);	
			cstm.setString(4, "");
			
			cstm.execute();
			
			codigoRetorno = cstm.getInt(3);
			codigoUsuario = cstm.getString(4);
			
			System.out.println(codigoRetorno);
			System.out.println(codigoUsuario);
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// Si el logueo está correcto invocar a obtenerDatosUsuarioBean 
		if (codigoRetorno == 0){
			usuario = obtenerDatosUsuarioBean(codigoUsuario);
			res.setMensaje("");
		}

		// Envía objeto usuario como parte del Resultado
		res.setCodigo(codigoRetorno);
		res.setObjetoResultado(usuario);

		return res;
	}
	
	public UsuarioBean obtenerDatosUsuarioBean(String codigoUsuario){
		UsuarioBean usuario = new UsuarioBean();

		/* lógica de negocio aquí */
		Connection conn = null;
		List<UsuarioBean>lista = new ArrayList<UsuarioBean>();
		
		try {
			conn = new MiConexionBD().getConexion();
			System.out.println("llamando sp" +codigoUsuario);
			CallableStatement cstm = conn.prepareCall("{call P_OBTENER_DATOS_USUARIO(?)}");
			cstm.setString(1,codigoUsuario);
				
			ResultSet rs = cstm.executeQuery();
			
			if(rs.next()){
				usuario = new UsuarioBean();
				usuario.setId(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setFechanac(rs.getString(3));
				usuario.setEmail(rs.getString(4));
				usuario.setFecha_creacion(rs.getString(5));
				usuario.setFecha_actualizacion(rs.getString(6));
				usuario.setUsuario_actualizacion(rs.getString(7));
				usuario.setUsuario_creacion(rs.getString(8));
				usuario.setCodigo_usuario(rs.getString(9));
				usuario.setEstado(rs.getString(10));
				usuario.setContrasena(rs.getString(11));
				usuario.setTipo_usuario(rs.getInt(12));
				usuario.setNumero_documento(rs.getInt(13));
				usuario.setUbigeo(rs.getInt(14));
				usuario.setSexo(rs.getString(15));
				lista.add(usuario);
				
			}
			System.out.println("cantidad de registros");
			System.out.println(lista.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
					e2.printStackTrace();
			}
		}
		
		// Invocar a P_OBTENER_DATOS_USUARIO
		
		// Colocar información en objeto usuario

		return usuario;
	}
	
	@Override
	public Resultado obtenerDatosUsuario(String codigoUsuario){
		UsuarioBean usuario = new UsuarioBean();
		Resultado res = new Resultado();

		/* lógica de negocio aquí */
		
		// Invocar a obtenerDatosUsuarioBean 
		
		usuario = obtenerDatosUsuarioBean(codigoUsuario);
		
		// Colocar objeto de retorno en objeto Resultado
		
		
		res.setObjetoResultado(usuario);
		
		return res;
	}
	
	@Override
	public Resultado cerrarSesion(String codigoUsuario){
		
		int codError = 0;
		Resultado res = new Resultado();
		
		/* lógica de negocio aquí*/
		// Invocar a P_CERRAR_SESION
		Connection conn = null;
		try {
			conn = new MiConexionBD().getConexion();
			CallableStatement cstm = conn.prepareCall("{call P_CERRAR_SESION (?,?)}");
			
			cstm.setString(1,codigoUsuario);
			cstm.setInt(2,0);
			
			cstm.registerOutParameter("codError", Types.INTEGER);
			cstm.execute();
			
			codError = cstm.getInt(2);
			
			System.out.println("Salio de sesion");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		res.setCodigo(codError);
		res.setMensaje("");
		
		return res;
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


