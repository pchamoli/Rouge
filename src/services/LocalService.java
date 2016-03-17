package services;

import beans.LocalBean;
import interfaces.LocalDAO;
import factory.Factory;

public class LocalService {
	Factory fabrica = Factory.getFactory(Factory.MYSQL);
	
	LocalDAO dao = fabrica.getLocalDAO();
	
	public LocalBean buscarlocalxnombre(String lugar, String nombre){
		
		try {
			return dao.buscarlocalxnombre(lugar, nombre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
