package dao;

import java.util.ArrayList;
import java.util.List;

import beans.Resultado;
import interfaces.UbigeoDAO;

public class MySqlUbigeoDAO implements UbigeoDAO {

	@Override
	public Resultado obtenerUbigeo(String codigoUsuario, String codigoPais, String codigoDepartamento,
			String codigoProvincia, String codigoDistrito, int offset, int nroRegistros) {
		
		//List<UbigeoBean>
		List<Object> lista = new ArrayList<Object>();
		Resultado res = new Resultado();
		
		/* Colocar l�gica de b�squeda aqu�*/
		
		res.setListaObjetos(lista);
		
		return null;
	}

}
