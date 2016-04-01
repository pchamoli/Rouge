package interfaces;

import beans.UsuarioBean;
import beans.Resultado;

public interface UsuarioDAO {
	
	//public int registrarUsuario(UsuarioBean obj);
	public Resultado registrarUsuario(UsuarioBean obj);
	//public UsuarioBean loguearUsuario(String login, String clave);
	public Resultado loguearUsuario(String login, String clave);
	//public UsuarioBean obtenerDatosUsuario(String codigoUsuario);
	public Resultado obtenerDatosUsuario(String codigoUsuario);
	//public int cerrarSesion(String codigoUsuario);
	public Resultado cerrarSesion(String codigoUsuario);
	
	public UsuarioBean obtenerDatosUsuarioBean(String codigoUsuario);
	
}
