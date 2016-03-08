package services;

import java.sql.SQLException;
import java.util.List;

import beans.NegocioBean;
import interfaces.NegocioDAO;
import factory.Factory;

public class NegocioService {

	Factory fabrica = Factory.getFactory(Factory.MYSQL);
	
	NegocioDAO dao=  fabrica.getNegocioDAO();
	
	public int registraNegocio(NegocioBean obj){
		
		try {
			
			return dao.registraNegocio(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public int modificaNegocio(NegocioBean obj){
		
		try {
			return dao.modificaNegocio(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<NegocioBean> buscarnegocio(String nombre,String dist) throws SQLException{
		
		try {
			return dao.buscarnegocio(nombre, dist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
