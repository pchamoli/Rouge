package interfaces;

import beans.Resultado;

public interface UbigeoDAO {
	public Resultado obtenerUbigeo(String codigoUsuario, String codigoPais, String codigoDepartamento, String codigoProvincia, String codigoDistrito, int offset, int nroRegistros);
}
