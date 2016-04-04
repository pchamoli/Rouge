package beans;

import java.util.*;

public class OpinionBean {
	
	private int id_opinion;
	private String titulo;
	private String descripcion;
	private	int calificacion;
	private int id_usuario;
	private String c_Usuario_Actualizacion; 
	private String c_Usuario_Creacion;
	private String d_fecha_creacion;
	private String d_fecha_actualizacion;
	private int id_local;
	private String nomlocal;
	private String nombreusuario;
	private List<ServicioUsuarioBean> ListaServiciosUsuario;
	
	public int getId_opinion() {
		return id_opinion;
	}
	public void setId_opinion(int id_opinion) {
		this.id_opinion = id_opinion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getC_Usuario_Actualizacion() {
		return c_Usuario_Actualizacion;
	}
	public void setC_Usuario_Actualizacion(String c_Usuario_Actualizacion) {
		this.c_Usuario_Actualizacion = c_Usuario_Actualizacion;
	}
	public String getC_Usuario_Creacion() {
		return c_Usuario_Creacion;
	}
	public void setC_Usuario_Creacion(String c_Usuario_Creacion) {
		this.c_Usuario_Creacion = c_Usuario_Creacion;
	}
	public String getD_fecha_creacion() {
		return d_fecha_creacion;
	}
	public void setD_fecha_creacion(String d_fecha_creacion) {
		this.d_fecha_creacion = d_fecha_creacion;
	}
	public String getD_fecha_actualizacion() {
		return d_fecha_actualizacion;
	}
	public void setD_fecha_actualizacion(String d_fecha_actualizacion) {
		this.d_fecha_actualizacion = d_fecha_actualizacion;
	}
	public int getId_local() {
		return id_local;
	}
	public void setId_local(int id_local) {
		this.id_local = id_local;
	}
	public String getNomlocal() {
		return nomlocal;
	}
	public void setNomlocal(String nomlocal) {
		this.nomlocal = nomlocal;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	
	public List<ServicioUsuarioBean> getListaServiciosUsuario(){
		return ListaServiciosUsuario;
	}
	
}
