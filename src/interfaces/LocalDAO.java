package interfaces;

import beans.*;
import java.util.*;

public interface LocalDAO {

	//List<LocalBean>
	public Resultado buscarLocalNombre(String nombreLocal, int offset, int nroRegistros);
	
	//List<LocalBean>
	public Resultado buscarLocalLugar(int lugar, int offset, int nroRegistros);
	
	//List<LocalBean>
	public Resultado buscarLocalServicio(String codigoUsuario, List<Integer> servicios, int offset, int nroRegistros);
	
	//LocalBean
	public Resultado obtenerDetalleLocal(String codigoUsuario, int codigoLocal);
	
	//LocalBean
	public Resultado obtenerDatosUsuarioNegocio(String codigoUsuario, int codigoLocal, int codigoNegocio);
	
	//int
	public Resultado registrarNegocio(UsuarioBean objUsuario, NegocioBean objNegocio);

	
}