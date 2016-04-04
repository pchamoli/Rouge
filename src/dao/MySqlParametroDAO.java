package dao;

import interfaces.ParametroDAO;
import util.MiConexionBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Resultado;
import beans.ParametroBean;

public class MySqlParametroDAO implements ParametroDAO {

	public Resultado obtenerParametro (String codigoUsuario, int codigoParametro){
		//List<ParametroBean>
		ParametroBean prm = new ParametroBean();
		List<Object> lista = new ArrayList<Object>();
		Resultado res = new Resultado();
		
		/* Colocar lógica de búsqueda aquí*/
		Connection conn = null;
		// Llamar a P_OBTENER_PARAMETRO y colocar resultado en objeto lista
		try {
			conn = new MiConexionBD().getConexion();
			CallableStatement cstm = conn.prepareCall("{call P_OBTENER_PARAMETRO (?)}");
			cstm.setInt(1,codigoParametro);
			
			ResultSet rs = cstm.executeQuery();
			
			while(rs.next()){
				System.out.println("entrando a la lista");
				prm = new ParametroBean();
				prm.setN_codigo_parametro(rs.getInt(1));
				prm.setN_secuencia(rs.getInt(2));     
				prm.setC_sistema(rs.getString(3));            
				prm.setV_nombre_parametro(rs.getString(4));
				prm.setV_valor(rs.getString(5));
				prm.setV_descripcion(rs.getString(6));
				prm.setV_descripcion_larga(rs.getString(7));
				prm.setV_default(rs.getString(8));    
				prm.setV_equivalencia(rs.getString(9));
				prm.setC_estado(rs.getString(10));
				prm.setN_codigo_padre(rs.getInt(11));
				prm.setN_secuencia_padre(rs.getInt(12));
				prm.setD_fecha_actualizacion(rs.getString(13));
				prm.setD_fecha_creacion(rs.getString(14));
				prm.setC_usuario_actualizacion(rs.getString(15));
				prm.setC_Usuario_Creacion(rs.getString(16));
				lista.add(prm);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
		// Envía objeto lista a objeto Resultado	
		res.setListaObjetos(lista);
		res.setCodigo(0);
		res.setMensaje("");
		
		return res;
	}
}
