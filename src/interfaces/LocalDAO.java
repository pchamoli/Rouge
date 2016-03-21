package interfaces;

import beans.*;
import java.util.*;

public interface LocalDAO {

	public List<LocalBean> buscarLocalNombre(String nombreLocal, int offset, int nroRegistros);
	public List<LocalBean> buscarLocalLugar(int lugar, int offset, int nroRegistros);
	public List<LocalBean> buscarLocalServicio(String codigoUsuario, List<Integer> servicios, int offset, int nroRegistros);
	public LocalBean obtenerDetalleLocal(String codigoUsuario, int codigoLocal);
	public LocalBean obtenerDatosUsuarioNegocio(String codigoUsuario, int codigoLocal, int codigoNegocio);
	public int registrarNegocio(UsuarioBean objUsuario, NegocioBean objNegocio);

	
}