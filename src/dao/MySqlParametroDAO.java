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
		
		/* Colocar lógica de búsqueda aquí*/
		
		res.setListaObjetos(lista);
		
		return res;
	}
}
