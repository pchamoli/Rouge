package interfaces;

import beans.OpinionBean;
import beans.Resultado;
import factory.Factory;

public interface ParametroDAO {
	
	//List<ParametroBean>
	public Resultado obtenerParametro (String codigoUsuario, int codigoParametro);

}
