package dao;

import interfaces.ParametroDAO;

import java.util.ArrayList;
import java.util.List;
import beans.Resultado;
import beans.ParametroBean;

public class MySqlParametroDAO implements ParametroDAO {

	public Resultado obtenerParametro (String codigoUsuario, int codigoParametro){
		//List<ParametroBean>
		List<Object> lista = new ArrayList<Object>();
		Resultado res = new Resultado();
		
		/* Colocar l�gica de b�squeda aqu�*/
		
		// Llamar a P_OBTENER_PARAMETRO y colocar resultado en objeto lista
		
		// Env�a objeto lista a objeto Resultado	
		res.setListaObjetos(lista);
		res.setCodigo(0);
		res.setMensaje("");
		
		return res;
	}
}
