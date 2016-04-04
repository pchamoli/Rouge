package factory;

import interfaces.LocalDAO;
import interfaces.NegocioDAO;
import interfaces.OpinionDAO;
import interfaces.UsuarioDAO;
import interfaces.ParametroDAO;
import interfaces.UbigeoDAO;
import dao.MySqlDAOFactory;

public abstract class Factory {

	public static final int MYSQL = 1;
	public static final int SQLSERVER= 2;
	
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract NegocioDAO getNegocioDAO();
	public abstract LocalDAO getLocalDAO();
	public abstract OpinionDAO getOpinionDAO();
	public abstract UbigeoDAO getUbigeoDAO();
	public abstract ParametroDAO getParametroDAO();
	
	public static Factory getFactory(int tipo){
		switch(tipo){
		case MYSQL:
			return new MySqlDAOFactory();
		default:
			return null;
		}
	}
	
}
