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
import util.MiConexionBD;
import beans.LocalBean;
import beans.OpinionBean;
import beans.Resultado;
import beans.ServicioUsuarioBean;
import beans.UbigeoBean;
import beans.UsuarioBean;
import interfaces.OpinionDAO;

public class MySqlOpinionDAO implements OpinionDAO {

	@Override
	public Resultado registrarOpinion (String codigoUsuario, OpinionBean obj){
		Resultado res = new Resultado();
		ServicioUsuarioBean serviciousBean = new ServicioUsuarioBean();
		/* Colocar lógica de búsqueda aquí*/
		Connection conn = null;
		// Llamar a P_REGISTRAR_OPINION, y luego a P_REGISTRAR_SERVICIO_OPINION 
		try {
			conn = new MiConexionBD().getConexion();
			CallableStatement cstm =  conn.prepareCall("{call P_REGISTRAR_OPINION(?,?,?,?,?,?,?,?,?,?,?)}");
			cstm.setInt(1, 0);
			cstm.setString(2, obj.getTitulo());
			cstm.setDouble(3, obj.getCalificacion());
			cstm.setInt(4, obj.getId_usuario());
			cstm.setString(5, obj.getC_Usuario_Actualizacion());
			cstm.setString(6, obj.getC_Usuario_Creacion());
			cstm.setString(7, obj.getD_fecha_creacion());
			cstm.setString(8, obj.getD_fecha_actualizacion());
			cstm.setInt(9, obj.getId_local());
		
			cstm.registerOutParameter("id_opinion", Types.INTEGER);
			
			cstm.executeUpdate();
			
			codigoUsuario = cstm.getString(1);
			
			CallableStatement cstm1 = conn.prepareCall("{call P_REGISTRAR_SERVICIO_OPINION(?,?)}");
			cstm1.setInt(1, obj.getId_opinion());
			cstm1.setInt(2, serviciousBean.getId_servicio());
			
			cstm1.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// tantas veces como servicios eligió el cliente
		// colocar parámetros INOUT en objeto obj
		
		
		// Retorna objeto resultado
		res.setObjetoResultado(obj);		
		res.setCodigo(0);
		
		return res;
	}
	
	public Resultado listarOpinionesLocal(String codigoUsuario, int idlocal, int offset, int nroRegistros){
		//List<OpinionBean>
		List<Object> lista = new ArrayList<Object>();
		Resultado res = new Resultado();
		OpinionBean opinionBean = new OpinionBean();
		
		/* Colocar lógica de búsqueda aquí*/
		Connection conn = null;
		try {
			conn = new MiConexionBD().getConexion();
			CallableStatement cstm = conn.prepareCall("{call P_LISTAR_OPINIONES_LOCAL(?,?,?)}");
			cstm.setInt(1, idlocal);
			cstm.setInt(2, offset);
			cstm.setInt(3, nroRegistros);
			
			ResultSet rs = cstm.executeQuery();
			while(rs.next()){
				System.out.println("Revisando datos");
				opinionBean = new OpinionBean();
				opinionBean.setId_opinion(rs.getInt(1));
				opinionBean.setTitulo(rs.getString(2));
				opinionBean.setDescripcion(rs.getString(3));
				opinionBean.setId_usuario(rs.getInt(4));
				opinionBean.setC_Usuario_Actualizacion(rs.getString(5));
				opinionBean.setC_Usuario_Creacion(rs.getString(6));
				opinionBean.setD_fecha_creacion(rs.getString(7));
				opinionBean.setD_fecha_actualizacion(rs.getString(8));
				opinionBean.setId_local(rs.getInt(9));
				opinionBean.setNomlocal(rs.getString(10));
				opinionBean.setNombreusuario(rs.getString(11));
				lista.add(opinionBean);
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
		// Llamar a P_LISTAR_OPINIONES_LOCAL y llenar el objeto lista con los registros que existan
		
		
		res.setListaObjetos(lista);
		return res;
	}
	
	
	public Resultado obtenerDetalleOpinion(String codigoUsuario, int idOpinion){
		//OpinionBean
		ArrayList<Object> lista = new ArrayList<Object>();
		Resultado res = new Resultado();
		OpinionBean objOpinionBean = new OpinionBean();
		
		/* Colocar lógica de búsqueda aquí*/
		Connection conn = null;
		try {
			conn = new MiConexionBD().getConexion();
			CallableStatement cstm = conn.prepareCall("{call P_OBTENER_DETALLE_OPINION(?)}");
			cstm.setString(1, codigoUsuario);
			cstm.setInt(2, idOpinion);
			
			ResultSet rs = cstm.executeQuery();
			if(rs.next()){
				System.out.println("Revisando datos");
				objOpinionBean = new OpinionBean();
				objOpinionBean.setId_opinion(rs.getInt(1));
				objOpinionBean.setTitulo(rs.getString(2));
				objOpinionBean.setDescripcion(rs.getString(3));
				objOpinionBean.setId_usuario(rs.getInt(4));
				objOpinionBean.setC_Usuario_Actualizacion(rs.getString(5));
				objOpinionBean.setC_Usuario_Creacion(rs.getString(6));
				objOpinionBean.setD_fecha_creacion(rs.getString(7));
				objOpinionBean.setD_fecha_actualizacion(rs.getString(8));
				objOpinionBean.setId_local(rs.getInt(9));
				objOpinionBean.setNomlocal(rs.getString(10));
				objOpinionBean.setNombreusuario(rs.getString(11));
				lista.add(objOpinionBean);
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
		// Llamar a P_OBTENER_DETALLE_OPINION y llenar el objeto objOpinionBean con la información recibida
		
		res.setObjetoResultado(objOpinionBean);
		
		return res;
	}
	
	public Resultado listarOpinionesUsuario(String codigoUsuario, int offset, int nroRegistros){
		//List<OpinionBean>
		List<Object> lista = new ArrayList<Object>();
		Resultado res = new Resultado();
		OpinionBean opinionBean = new OpinionBean();
		
		/* Colocar lógica de búsqueda aquí */
		Connection conn=null;
		
		try {
			conn = new MiConexionBD().getConexion();
			CallableStatement cstm = conn.prepareCall("{call P_LISTAR_OPINIONES_USUARIO(?,?,?)}");
			
			cstm.setString(1, codigoUsuario);
			cstm.setInt(2, offset);
			cstm.setInt(3, nroRegistros);
			
			ResultSet rs = cstm.executeQuery();
			
			while(rs.next()){
				opinionBean = new OpinionBean();
				opinionBean.setId_opinion(rs.getInt(1));
				opinionBean.setTitulo(rs.getString(2));
				opinionBean.setDescripcion(rs.getString(3));
				opinionBean.setId_usuario(rs.getInt(4));
				opinionBean.setC_Usuario_Actualizacion(rs.getString(5));
				opinionBean.setC_Usuario_Creacion(rs.getString(6));
				opinionBean.setD_fecha_creacion(rs.getString(7));
				opinionBean.setD_fecha_actualizacion(rs.getString(8));
				opinionBean.setId_local(rs.getInt(9));
				opinionBean.setNomlocal(rs.getString(10));
				opinionBean.setNombreusuario(rs.getString(11));
				lista.add(opinionBean);
			}
			
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
		// Llamar a P_LISTAR_OPINIONES_USUARIO y llenar el objeto lista con los registros que existan
	
		res.setListaObjetos(lista);
		return res;
	}
	
	/*
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
	}*/
}