package services;

import java.sql.SQLException;
import java.util.List;

import beans.OpinionBean;
import beans.Resultado;
import interfaces.OpinionDAO;
import factory.Factory;

public class OpinionService {
	
	Factory fabrica = Factory.getFactory(Factory.MYSQL);
	
	OpinionDAO dao = fabrica.getOpinionDAO();
	
	//int
	public Resultado registrarOpinion (String codigoUsuario, OpinionBean obj){
		try {
			return dao.registrarOpinion(codigoUsuario, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//List<OpinionBean>
	public Resultado listarOpinionesLocal(String codigoUsuario, int idlocal, int offset, int nroRegistros){
		try {
			return dao.listarOpinionesLocal(codigoUsuario, idlocal, offset, nroRegistros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;		
	}
	
	//OpinionBean
	public Resultado obtenerDetalleOpinion(String codigoUsuario, int idOpinion){
		try {
			return dao.obtenerDetalleOpinion(codigoUsuario, idOpinion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Resultado listarOpinionesUsuario(String codigoUsuario, int offset, int nroRegistros){
		try {
			return dao.listarOpinionesUsuario(codigoUsuario, offset, nroRegistros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
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
	*/
}
