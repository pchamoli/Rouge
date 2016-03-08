package interfaces;

import java.sql.SQLException;
import java.util.List;

import beans.NegocioBean;

public interface NegocioDAO {
	
		public int registraNegocio(NegocioBean obj);
		public int modificaNegocio(NegocioBean obj);
		public abstract List<NegocioBean> buscarnegocio(String nombre,String dist) throws SQLException;
}
