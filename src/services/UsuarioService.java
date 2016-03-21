package services;

import beans.UsuarioBean;
import interfaces.UsuarioDAO;
import factory.Factory;

public class UsuarioService {

	Factory fabrica = Factory.getFactory(Factory.MYSQL);
	
	UsuarioDAO dao = fabrica.getUsuarioDAO();
	
	public int registrarUsuario(UsuarioBean obj){
	
		try {
			
			return dao.registrarUsuario(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	
	public UsuarioBean loguearUsuario(String login, String clave){
		
		try {
			
			return dao.loguearUsuario(login, clave);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}			
			
/*
	public int ModificaUsuario(UsuarioBean obj){
		
		try {
			
			return dao.ModificaUsuario(obj);
	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
*/
			
	public UsuarioBean obtenerDatosUsuario(String codigoUsuario){
		return null;
	}
	
	public int cerrarSesion(String codigoUsuario){
		return 0;
	}
	
}
