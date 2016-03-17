package services;

import beans.UsuarioBean;
import interfaces.UsuarioDAO;
import factory.Factory;

public class UsuarioService {

	Factory fabrica = Factory.getFactory(Factory.MYSQL);
	
	UsuarioDAO dao = fabrica.getUsuarioDAO();
	
	
	public int RegistraUsuario(UsuarioBean obj){
	
		try {
			
			return dao.RegistraUsuario(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	public int ModificaUsuario(UsuarioBean obj){
		
		try {
			
			return dao.ModificaUsuario(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public UsuarioBean logueausuario(String correo){
		
		try {
			
			return dao.logueausuario(correo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
}
