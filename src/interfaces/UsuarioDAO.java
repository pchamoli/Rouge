package interfaces;

import beans.UsuarioBean;

public interface UsuarioDAO {
	
	public int registrarUsuario(UsuarioBean obj);
	public UsuarioBean loguearUsuario(String login, String clave);
	public UsuarioBean obtenerDatosUsuario(String codigoUsuario);
	public int cerrarSesion(String codigoUsuario);

	
}
