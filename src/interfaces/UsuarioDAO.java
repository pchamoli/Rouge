package interfaces;

import beans.UsuarioBean;

public interface UsuarioDAO {
	
	public int RegistraUsuario(UsuarioBean obj);
	public int ModificaUsuario(UsuarioBean obj);
	public UsuarioBean logueausuario(String login, String clave);
	
}
