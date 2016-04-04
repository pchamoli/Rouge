package beans;

import java.util.List;

public class Resultado {
	private Object objetoResultado;
	private List<Object> listaObjetos;
	private List<String[]> tabla;
	private int codigo;
	private int cantidad;
	private String mensaje;
	
	public int getCantidad(){
		return cantidad;
	}
	
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	
	public Object getObjetoResultado(){
		return objetoResultado;
	}
	
	public void setObjetoResultado(Object objetoParametro){
		objetoResultado = objetoParametro;
	}

	public List<Object> getListaObjetos(){
		return listaObjetos;
	}
	
	public void setListaObjetos(List<Object> listaObjetosParm){
		listaObjetos = listaObjetosParm;
	}
	
	public List<String[]> getTabla(){
		return tabla;
	}
	
	public void setTabla(List<String[]> tablaParm){
		tabla = tablaParm;
	}	
	
	public int getCodigo(){
		return codigo;
	}
	
	public void setCodigo(int codigoParm){
		codigo = codigoParm;
	}	

	public String getMensaje(){
		return mensaje;
	}
	
	public void setMensaje(String mensajeParm){
		mensaje = mensajeParm;
	}	
}
