package interfaces;

import java.sql.SQLException;
import java.util.List;

import beans.OpinionBean;
import beans.Resultado;

public interface OpinionDAO {

	//int
	public Resultado registrarOpinion (String codigoUsuario, OpinionBean obj);
	//List<OpinionBean>
	public Resultado listarOpinionesLocal(String codigoUsuario, int idlocal, int offset, int nroRegistros);
	//OpinionBean
	public Resultado obtenerDetalleOpinion(String codigoUsuario, int idOpinion);
	//List<OpinionBean>
	public Resultado listarOpinionesUsuario(String codigoUsuario, int offset, int nroRegistros);
}
