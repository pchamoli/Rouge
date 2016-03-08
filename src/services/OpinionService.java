package services;

import java.sql.SQLException;
import java.util.List;

import beans.OpinionBean;
import interfaces.OpinionDAO;
import factory.Factory;

public class OpinionService {
	
	Factory fabrica = Factory.getFactory(Factory.MYSQL);
	
	OpinionDAO dao = fabrica.getOpinionDAO();
	
	public int registraopinion(OpinionBean obj){
		
		try {
			return registraopinion(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public List<OpinionBean> listaropinionesxlocal() throws SQLException{
		
		try {
			return listaropinionesxlocal();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
		
		
}

}
