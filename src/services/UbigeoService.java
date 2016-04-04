package services;

import beans.Resultado;
import factory.Factory;
import interfaces.UbigeoDAO;

public class UbigeoService {
	Factory fabrica = Factory.getFactory(Factory.MYSQL);
	
	UbigeoDAO dao = fabrica.getUbigeoDAO();
	
	//List<ParametroBean>
	public Resultado obtenerUbigeo (String codigoUsuario, String codigoPais, String codigoDepartamento,
			String codigoProvincia, String codigoDistrito, int offset, int nroRegistros){
		try {
			return dao.obtenerUbigeo(codigoUsuario, codigoPais, codigoDepartamento, codigoProvincia, codigoDistrito, offset, nroRegistros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
