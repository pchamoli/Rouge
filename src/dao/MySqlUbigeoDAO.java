package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Resultado;
import beans.UbigeoBean;
import interfaces.UbigeoDAO;
import util.MiConexionBD;

public class MySqlUbigeoDAO implements UbigeoDAO {

	@Override
	public Resultado obtenerUbigeo(String codigoUsuario, String codigoPais, String codigoDepartamento,
			String codigoProvincia, String codigoDistrito, int offset, int nroRegistros) {
		
		//List<UbigeoBean>
		UbigeoBean ubig = new UbigeoBean();
		List<Object> lista = new ArrayList<Object>();
		Resultado res = new Resultado();
		
		/* Colocar lógica de búsqueda aquí*/
		Connection conn = null;
		
		// Invocar a P_OBTENER_UBIGEO
		try {
			conn = new MiConexionBD().getConexion();
			System.out.println("llamando sp" +codigoUsuario+codigoPais+codigoDepartamento+codigoProvincia+codigoDistrito+offset+nroRegistros);
			CallableStatement cstm = conn.prepareCall("{call P_OBTENER_UBIGEO(?,?,?,?,?,?,?,?)}");
			cstm.setString(1, codigoUsuario);
			cstm.setString(2, codigoPais);
			cstm.setString(3, codigoDepartamento);
			cstm.setString(4, codigoProvincia);
			cstm.setString(5, codigoDistrito);
			cstm.setString(6, "");
			cstm.setInt(7, offset);
			cstm.setInt(8, nroRegistros);
			ResultSet rs = cstm.executeQuery();
			
			while(rs.next()){
				System.out.println("entrando a la lista");
				ubig = new UbigeoBean();
				ubig.setCod_ubigeo(rs.getInt(1));
				System.out.println("devolviendo codigo" +rs.getInt(1));
				ubig.setPais(rs.getString(2));
				ubig.setCod_departamento(rs.getString(3));
				ubig.setCod_provincia(rs.getString(4));
				ubig.setCod_distrito(rs.getString(5));
				ubig.setDescripcion(rs.getString(6));
				ubig.setV_descripcion_larga(rs.getString(7));
				lista.add(ubig);
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		// Devolver la lista de Ubigeos en objeto Resultado
		res.setListaObjetos(lista);
		res.setCodigo(0);
		res.setMensaje("");
		
		return res;
	}

}
