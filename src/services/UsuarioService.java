package services;

import beans.UsuarioBean;
import beans.Resultado;
import interfaces.UsuarioDAO;
import factory.Factory;

public class UsuarioService {

	Factory fabrica = Factory.getFactory(Factory.MYSQL);
	
	UsuarioDAO dao = fabrica.getUsuarioDAO();
	
	//public int registrarUsuario(UsuarioBean obj){
	public Resultado registrarUsuario(UsuarioBean obj){
	
		try {
			
			return dao.registrarUsuario(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return 0;
		return null;
		
	}

	
	public Resultado loguearUsuario(String login, String clave){
		
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
			
	public Resultado obtenerDatosUsuario(String codigoUsuario){

		try {
			
			return dao.obtenerDatosUsuario(codigoUsuario);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
	
	public Resultado cerrarSesion(String codigoUsuario){
		try {
			
			return dao.cerrarSesion(codigoUsuario);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
}
