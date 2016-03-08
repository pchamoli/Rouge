package interfaces;

import java.sql.SQLException;
import java.util.List;

import beans.OpinionBean;

public interface OpinionDAO {

	public int registraopinion (OpinionBean obj);
	public List<OpinionBean> listaropinionesxlocal() throws SQLException;
}
