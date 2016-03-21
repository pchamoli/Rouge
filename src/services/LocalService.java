package services;

import java.util.List;

import beans.LocalBean;
import beans.NegocioBean;
import beans.UsuarioBean;

import interfaces.LocalDAO;
import factory.Factory;

public class LocalService {
	Factory fabrica = Factory.getFactory(Factory.MYSQL);
	
	LocalDAO dao = fabrica.getLocalDAO();
	
	public List<LocalBean> buscarLocalNombre(String nombreLocal, int offset, int nroRegistros){
		
		try {
			return dao.buscarLocalNombre(nombreLocal, offset, nroRegistros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public List<LocalBean> buscarLocalLugar(int lugar, int offset, int nroRegistros){
		try {
			return dao.buscarLocalLugar(lugar, offset, nroRegistros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<LocalBean> buscarLocalServicio(String codigoUsuario, List<Integer> servicios, int offset, int nroRegistros){
		try {
			return dao.buscarLocalServicio(codigoUsuario, servicios, offset, nroRegistros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public LocalBean obtenerDetalleLocal(String codigoUsuario, int codigoLocal){
		try {
			return dao.obtenerDetalleLocal(codigoUsuario, codigoLocal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public LocalBean obtenerDatosUsuarioNegocio(String codigoUsuario, int codigoLocal, int codigoNegocio){
		try {
			return dao.obtenerDatosUsuarioNegocio(codigoUsuario, codigoLocal, codigoNegocio);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}
	
	public int registrarNegocio(UsuarioBean objUsuario, NegocioBean objNegocio){
		try {
			return dao.registrarNegocio(objUsuario, objNegocio);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;

		
	}
}