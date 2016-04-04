package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import util.ConexionDB;

import beans.LocalBean;
import beans.NegocioBean;
import beans.UsuarioBean;
import beans.UbigeoBean;
import beans.Resultado;
import beans.ServicioUsuarioBean;
import util.MiConexionBD;

import interfaces.LocalDAO;
//import sun.lwawt.macosx.CSystemTray;

public class MySqlLocalDAO implements LocalDAO {

	/*@Override
	public LocalBean buscarLocalNombre(String nombreLocal, String nombre){
		
		LocalBean lb = null;
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {

			conn = ConexionDB.getConexion();

			//conn = new MiConexionBD().getConexion();

			String sql="select * from tb_local where dir_local=? and nom_local=?";
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
		
	}*/
	
	@Override
	public Resultado buscarLocalNombre(String nombreLocal, int offset, int nroRegistros){
		//List<LocalBean>
		LocalBean lcb = new LocalBean();
		List<Object> lista = new ArrayList<Object>();
		Resultado res = new Resultado();
		
		/* Colocar l�gica de b�squeda aqu�*/
		Connection conn = null;
		try {
			// Invocar a P_BUSCAR_LOCAL_NOMBRE y colocar informaci�n de retorno en objeto lista
			conn = new MiConexionBD().getConexion();
			CallableStatement cstm = conn.prepareCall("{call P_BUSCAR_LOCAL_NOMBRE(?,?,?)}");
			System.out.println("buscando local " +nombreLocal+" "+offset+" "+nroRegistros);
			cstm.setString(1, nombreLocal);
			cstm.setInt(2, offset);
			cstm.setInt(3, nroRegistros);
			ResultSet rs = cstm.executeQuery();
			
			while(rs.next()){
				lcb = new LocalBean();
				lcb.setId(rs.getInt(1));
				lcb.setNom_local(rs.getString(2));
				lcb.setDir_local(rs.getString(3));
				lcb.setTel_local(rs.getString(4));
				lcb.setEmail(rs.getString(5));
				lcb.setCod_ubigeo(rs.getInt(6));
				lcb.setId_negocio(rs.getInt(7));
				lcb.setC_Usuario_Actualizacion(rs.getString(8));
				lcb.setC_Usuario_Creacion(rs.getString(9));
				lcb.setD_fecha_creacion(rs.getString(10));
				lcb.setD_fecha_actualizacion(rs.getString(11));
				lista.add(lcb);
			
			}
			System.out.println("Cantidad de registros");
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
		
		// Retorna objeto lista en objeto Resultado
		res.setListaObjetos(lista);
		res.setCodigo(0);
		res.setMensaje("");
		
		return res;
	}
	
	@Override
	public Resultado buscarLocalLugar(int lugar, int offset, int nroRegistros){
		//List<LocalBean>
		LocalBean lcb = new LocalBean();
		List<Object> lista = new ArrayList<Object>();
		Resultado res = new Resultado();

		/* Colocar l�gica de b�squeda aqu�*/
		Connection conn = null;
		try {
			conn = new MiConexionBD().getConexion();
			CallableStatement cstm = conn.prepareCall("{call P_BUSCAR_LOCAL_LUGAR(?,?,?)}");
			System.out.println("Verificando local " +lugar+offset+nroRegistros);
			cstm.setInt(1, lugar);
			cstm.setInt(2, offset);
			cstm.setInt(3, nroRegistros);
			
			ResultSet rs = cstm.executeQuery();
			
			while(rs.next()){
				lcb = new LocalBean();
				lcb.setId(rs.getInt(1));
				lcb.setNom_local(rs.getString(2));
				lcb.setDir_local(rs.getString(3));
				lcb.setTel_local(rs.getString(4));
				lcb.setEmail(rs.getString(5));
				lcb.setCod_ubigeo(rs.getInt(6));
				lcb.setId_negocio(rs.getInt(7));
				lcb.setC_Usuario_Actualizacion(rs.getString(8));
				lcb.setC_Usuario_Creacion(rs.getString(9));
				lcb.setD_fecha_creacion(rs.getString(10));
				lcb.setD_fecha_actualizacion(rs.getString(11));
				lista.add(lcb);
			}
			
			System.out.println("Cantidad de registros");
			System.out.println(lista.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException e2){
				e2.printStackTrace();
			}
		}
		
		// Invocar a P_BUSCAR_LOCAL_LUGAR y colocar informaci�n de retorno en objeto lista
		
		res.setListaObjetos(lista);
		res.setCodigo(0);
		res.setMensaje("");
		
		return res;
	}
	
	@Override
	public Resultado buscarLocalServicio(String codigoUsuario, List<Integer> servicios, int offset, int nroRegistros){
		//List<LocalBean>
		List<Object> lista = new ArrayList<Object>();
		Resultado res = new Resultado();
		LocalBean localBean = new LocalBean();
		NegocioBean negocioBean = new NegocioBean();
		UbigeoBean ubigeoBean = new UbigeoBean();
		//List<ServicioUsuarioBean> listaservicio = new ArrayList<ServicioUsuarioBean>();
		
		/* Colocar l�gica de b�squeda aqu�*/
		Connection conn = null;
	
		// Invocar a P_BUSCAR_LOCAL_SERVICIO y colocar informaci�n de retorno en objeto lista
		try {
			conn = new MiConexionBD().getConexion();
			CallableStatement cstm = conn.prepareCall("{call P_BUSCAR_LOCAL_SERVICIO(?,?,?,?)}");
			cstm.setString(1, codigoUsuario);
			cstm.setObject(2, servicios);
			cstm.setInt(3, offset);
			cstm.setInt(4, nroRegistros);
			
			ResultSet rs = cstm.executeQuery();
			while(rs.next()){
				localBean = new LocalBean();
				localBean.setId(rs.getInt(1));
				localBean.setNom_local(rs.getString(2));
				localBean.setDir_local(rs.getString(3));
				localBean.setTel_local(rs.getString(4));
				localBean.setEmail(rs.getString(5));
				localBean.setCod_ubigeo(rs.getInt(6));
				localBean.setId_negocio(rs.getInt(7));
				localBean.setC_Usuario_Actualizacion(rs.getString(8));
				localBean.setC_Usuario_Creacion(rs.getString(9));
				localBean.setD_fecha_creacion(rs.getString(10));
				localBean.setD_fecha_actualizacion(rs.getString(11));
				lista.add(localBean);
				negocioBean = new NegocioBean();
				negocioBean.setId_negocio(rs.getInt(1));
				negocioBean.setNombre(rs.getString(2));
				negocioBean.setDireccion(rs.getString(3));
				negocioBean.setTelefono(rs.getString(4));
				negocioBean.setEmail(rs.getString(5));
				negocioBean.setCod_ubigeo(rs.getInt(6));
				negocioBean.setId_negocio(rs.getInt(7));
				negocioBean.setC_usuario_actualizacion(rs.getString(8));
				negocioBean.setC_usuario_creacion(rs.getString(9));
				negocioBean.setD_fecha_creacion(rs.getString(10));
				negocioBean.setD_fecha_actualizacion(rs.getString(11));
				negocioBean.setCalificacionfinal(rs.getDouble(12));
				lista.add(negocioBean);
				ubigeoBean = new UbigeoBean();
				ubigeoBean.setCod_ubigeo(rs.getInt(1));
				ubigeoBean.setPais(rs.getString(2));
				ubigeoBean.setCod_departamento(rs.getString(3));
				ubigeoBean.setCod_provincia(rs.getString(4));
				ubigeoBean.setCod_distrito(rs.getString(5));
				ubigeoBean.setDescripcion(rs.getString(6));
				ubigeoBean.setV_descripcion_larga(rs.getString(7));
				lista.add(ubigeoBean);		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException e2){
				e2.printStackTrace();
			}
		}

		res.setListaObjetos(lista);
		res.setCodigo(0);
		res.setMensaje("");
		
		return res;
	}
	
	@Override
	public Resultado obtenerDetalleLocal(String codigoUsuario, int codigoLocal){
		//LocalBean
		ArrayList<Object> lista = new ArrayList<Object>();
		LocalBean localBean = new LocalBean();
		NegocioBean negocioBean = new NegocioBean();
		UbigeoBean ubigeoBean = new UbigeoBean();
		Resultado res = new Resultado();
		
		/* Colocar l�gica de b�squeda aqu� */
		Connection conn = null;
		// Invocar a P_OBTENER_DETALLE_LOCAL y colocar informaci�n de retorno en objeto localBean
		try{
			conn = new MiConexionBD().getConexion();
			CallableStatement cstm = conn.prepareCall("{call P_OBTENER_DETALLE_LOCAL(?,?)}");
			cstm.setString(1, codigoUsuario);
			cstm.setInt(2, codigoLocal);
			
			ResultSet rs = cstm.executeQuery();
			if(rs.next()){
				System.out.println("Revisando datos");
				localBean = new LocalBean();
				localBean.setId(rs.getInt(1));
				localBean.setNom_local(rs.getString(2));
				localBean.setDir_local(rs.getString(3));
				localBean.setTel_local(rs.getString(4));
				localBean.setEmail(rs.getString(5));
				localBean.setCod_ubigeo(rs.getInt(6));
				localBean.setId_negocio(rs.getInt(7));
				localBean.setC_Usuario_Actualizacion(rs.getString(8));
				localBean.setC_Usuario_Creacion(rs.getString(9));
				localBean.setD_fecha_creacion(rs.getString(10));
				localBean.setD_fecha_actualizacion(rs.getString(11));
				lista.add(localBean);
				negocioBean = new NegocioBean();
				negocioBean.setId_negocio(rs.getInt(1));
				negocioBean.setNombre(rs.getString(2));
				negocioBean.setDireccion(rs.getString(3));
				negocioBean.setTelefono(rs.getString(4));
				negocioBean.setEmail(rs.getString(5));
				negocioBean.setCod_ubigeo(rs.getInt(6));
				negocioBean.setId_negocio(rs.getInt(7));
				negocioBean.setC_usuario_actualizacion(rs.getString(8));
				negocioBean.setC_usuario_creacion(rs.getString(9));
				negocioBean.setD_fecha_creacion(rs.getString(10));
				negocioBean.setD_fecha_actualizacion(rs.getString(11));
				negocioBean.setCalificacionfinal(rs.getDouble(12));
				lista.add(negocioBean);
				ubigeoBean = new UbigeoBean();
				ubigeoBean.setCod_ubigeo(rs.getInt(1));
				ubigeoBean.setPais(rs.getString(2));
				ubigeoBean.setCod_departamento(rs.getString(3));
				ubigeoBean.setCod_provincia(rs.getString(4));
				ubigeoBean.setCod_distrito(rs.getString(5));
				ubigeoBean.setDescripcion(rs.getString(6));
				ubigeoBean.setV_descripcion_larga(rs.getString(7));
				lista.add(ubigeoBean);
				
				System.out.println("Cantidad de Listas");
				System.out.println(lista.size());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException e2){
				e2.printStackTrace();
			}
		}
		
		res.setListaObjetos(lista);
		res.setCodigo(0);
		res.setMensaje("");
		
		return res;
	}
	
	@Override
	public Resultado obtenerDatosUsuarioNegocio(String codigoUsuario, int codigoLocal, int codigoNegocio){
		//LocalBean
		LocalBean localBean = new LocalBean();
		NegocioBean negocioBean = new NegocioBean();
		UbigeoBean ubigeoBean = new UbigeoBean();
		UsuarioBean usuarioBean = new UsuarioBean();
		List<Object> listaObjetos = new ArrayList<Object>();
		
		Resultado res = new Resultado();
		
		/* Colocar l�gica de b�squeda aqu� */
		// Invocar a P_OBTENER_DATOS_USUARIO_NEGOCIO y colocar informaci�n de retorno en objetos
		// localBean / negocioBean / ubigeoBean / usuarioBean
		
		//Env�a informaci�n de objetos a objeto Resultado
		listaObjetos.add(localBean);
		listaObjetos.add(negocioBean);
		listaObjetos.add(ubigeoBean);
		listaObjetos.add(usuarioBean);
		
		res.setListaObjetos(listaObjetos);
		res.setCodigo(0);
		res.setMensaje("");
		
		return res;
	}
	
	@Override
	public Resultado registrarNegocio(UsuarioBean objUsuario, NegocioBean objNegocio){ 
		//int
		int idusuario = 0;
		int idnegocio = 0;
		int codigoRetorno = 0;
		//int codigoError = 0;
		
		Resultado res = new Resultado();
		List<Object> listaObjetos = new ArrayList<Object>();
		UsuarioBean usuarioBean = new UsuarioBean();
		NegocioBean negocioBean = new NegocioBean();
		
		/* Colocar l�gica de b�squeda aqu� */
		Connection conn = null;
		
		// Invocar a P_REGISTRAR_NEGOCIO y colocar informaci�n de retorno en objUsuario y objNegocio
		try {
			conn = new MiConexionBD().getConexion();
			CallableStatement cstm = conn.prepareCall("{call P_REGISTRAR_NEGOCIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstm.setInt(1, 0);
			cstm.setString(2, usuarioBean.getNombre());
			cstm.setString(3, usuarioBean.getFechanac());
			cstm.setString(4, usuarioBean.getEmail());
			cstm.setString(5, usuarioBean.getFecha_creacion());
			cstm.setString(6, usuarioBean.getFecha_actualizacion());
			cstm.setString(7, usuarioBean.getUsuario_actualizacion());
			cstm.setString(8, usuarioBean.getUsuario_creacion());
			cstm.setString(9, usuarioBean.getCodigo_usuario());
			cstm.setString(10, usuarioBean.getEstado());
			cstm.setInt(11, usuarioBean.getTipo_usuario());
			cstm.setInt(12, usuarioBean.getNumero_documento());
			cstm.setInt(13, usuarioBean.getTipo_documento());
			cstm.setInt(14, usuarioBean.getUbigeo());
			cstm.setInt(15, 0);
			cstm.setString(16, usuarioBean.getSexo());
			cstm.setString(17, usuarioBean.getContrasena());
			cstm.setInt(18, 0);
			cstm.setString(19, negocioBean.getNombre());
			cstm.setString(20, negocioBean.getDireccion());
			cstm.setString(21, negocioBean.getTelefono());
			cstm.setString(22, negocioBean.getEmail());
			cstm.setInt(23, negocioBean.getCod_ubigeo());
			cstm.setInt(24, negocioBean.getId_foto());
			cstm.setString(25, negocioBean.getC_usuario_actualizacion());
			cstm.setString(26, negocioBean.getC_usuario_creacion());
			cstm.setString(27, negocioBean.getD_fecha_creacion());
			cstm.setString(28, negocioBean.getD_fecha_actualizacion());
			cstm.setDouble(29, negocioBean.getCalificacionfinal());
			cstm.setInt(30, 0);
			
			cstm.registerOutParameter("tb_usuario_id_usuario", Types.INTEGER);
			cstm.registerOutParameter("tb_negocio_id_negocio", Types.INTEGER);
			cstm.registerOutParameter("codigoRetorno", Types.INTEGER);
			
			cstm.executeUpdate();
			
			idusuario = cstm.getInt(1);
			idnegocio = cstm.getInt(18);
			codigoRetorno = cstm.getInt(30);
			
			objUsuario.setId(idusuario);
			objNegocio.setId_negocio(idnegocio);
			
			System.out.println(codigoRetorno);
			System.out.println("Negocio Registrado");
					
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
					
		//Env�a informaci�n de objetos a objeto Resultado
		listaObjetos.add(objUsuario);
		listaObjetos.add(objNegocio);
		
		res.setCodigo(codigoRetorno);
		res.setMensaje("");
		
		return res;
	}

}
