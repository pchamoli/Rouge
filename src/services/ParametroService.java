package services;

import beans.Resultado;
import factory.Factory;
import interfaces.ParametroDAO;

public class ParametroService {
	Factory fabrica = Factory.getFactory(Factory.MYSQL);
	
	ParametroDAO dao = fabrica.getParametroDAO();
	

	//List<ParametroBean>
	public Resultado obtenerParametro (String codigoUsuario, int codigoParametro){
		try {
			return dao.obtenerParametro(codigoUsuario, codigoParametro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
