package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConexionDB;

import beans.LocalBean;
import beans.NegocioBean;
import beans.UsuarioBean;
import beans.UbigeoBean;
import beans.Resultado;

import util.MiConexionBD;

import interfaces.LocalDAO;

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
		
		/* Colocar lógica de búsqueda aquí*/
		Connection conn = null;
		try {
			// Invocar a P_BUSCAR_LOCAL_NOMBRE y colocar información de retorno en objeto lista
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
		List<Object> lista = new ArrayList<Object>();
		Resultado res = new Resultado();

		/* Colocar lógica de búsqueda aquí*/
		// Invocar a P_BUSCAR_LOCAL_LUGAR y colocar información de retorno en objeto lista
		
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

		/* Colocar lógica de búsqueda aquí*/
		// Invocar a P_BUSCAR_LOCAL_SERVICIO y colocar información de retorno en objeto lista
		
		res.setListaObjetos(lista);
		res.setCodigo(0);
		res.setMensaje("");
		
		return res;
	}
	
	@Override
	public Resultado obtenerDetalleLocal(String codigoUsuario, int codigoLocal){
		//LocalBean
		LocalBean localBean = new LocalBean();
		Resultado res = new Resultado();
		
		/* Colocar lógica de búsqueda aquí */
		// Invocar a P_OBTENER_DETALLE_LOCAL y colocar información de retorno en objeto localBean
		
		res.setObjetoResultado(localBean);
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
		
		/* Colocar lógica de búsqueda aquí */
		// Invocar a P_OBTENER_DATOS_USUARIO_NEGOCIO y colocar información de retorno en objetos
		// localBean / negocioBean / ubigeoBean / usuarioBean
		
		//Envía información de objetos a objeto Resultado
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
		int codigoError = 0;
		
		Resultado res = new Resultado();
		List<Object> listaObjetos = new ArrayList<Object>();
				
		/* Colocar lógica de búsqueda aquí */
		// Invocar a P_REGISTRAR_NEGOCIO y colocar información de retorno en objUsuario y objNegocio
		
				
		//Envía información de objetos a objeto Resultado
		listaObjetos.add(objUsuario);
		listaObjetos.add(objNegocio);
		
		res.setCodigo(codigoError);
		res.setMensaje("");
		
		return res;
	}

}
