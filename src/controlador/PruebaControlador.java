package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UsuarioBean;
import beans.Resultado;
import services.UsuarioService;

/**
 * Servlet implementation class ClienteControlador
 */

class Respuesta {
	String os_descripcion_error="";
	int oi_codigo_error=0;
	int oi_nivel_error;
	String[] objetoString;
	Object objeto;

	public void setRespuesta(String respuesta){
		os_descripcion_error = respuesta;
	}
	
	public void setCodigoError(int codigo){
		oi_codigo_error = codigo;
	}
	
	public String getRespuesta(){
		return os_descripcion_error;
	}
	
	public int getCodigoError(){
		return oi_codigo_error;
	}
	
	public void setObjeto(Object objParm){
		objeto = objParm;
	}
	
	public Object getObjeto(){
		return objeto;
	}
}

@WebServlet("/usuario")
public class PruebaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioService service = new UsuarioService();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Respuesta obj = new Respuesta();
		UsuarioBean lc = new UsuarioBean();
		UsuarioBean lc2 = new UsuarioBean();
		
		String metodo=request.getParameter("metodo");
		
		//modificaRespuesta(obj);
		//System.out.println(obj.os_descripcion_error);
		
		/*lc.setCodigo_usuario("Petter");
		lc.setEstado("A");
		
		obj.setObjeto(lc);
		
		lc2 = (UsuarioBean) obj.getObjeto();
		
		System.out.println("LC2");
		System.out.println(lc2.getCodigo_usuario());
		System.out.println(lc2.getEstado());
		System.out.println("LC");
		System.out.println(lc2.getCodigo_usuario());
		System.out.println(lc2.getEstado());
		*/
		UsuarioService us = new UsuarioService();
		Resultado res = new Resultado();
		
		//res = us.registrarUsuario(lc2);
		res = us.loguearUsuario("pet.cham@gmail.com", "UPRUEBA");
	
		res = us.cerrarSesion("UPRUEBA");
		
		lc.setId(2);
		lc.setNombre("Jhon");
		lc.setFechanac("2015-12-11");
		lc.setFecha_creacion("2015-12-11");
		lc.setFecha_actualizacion("2015-12-11");
		lc.setUsuario_creacion("jh");
		lc.setUsuario_actualizacion("jhp");
		lc.setCodigo_usuario("jh2");
		lc.setEstado("e");
		lc.setContrasena("loki");
		lc.setUbigeo(10000);
		lc.setTipo_usuario(1);
		
		res = us.registrarUsuario(lc);
	
		if (res != null) {
			/*UsuarioBean ub = (UsuarioBean) res.getObjetoResultado();
						
			System.out.println("Estado: " + ub.getEstado());
			System.out.println("Código Usuario: " + ub.getCodigo_usuario());*/
			System.out.println(res.getCodigo());
			
		}
		
		if(metodo.equals("registrar")){
			registrar(request, response);
		}
				
		else if(metodo.equals("listar")){
			listar(request, response);
		}
		
		else if (metodo.equals("validar")){
			eliminar(request, response);
		}

		else if (metodo.equals("actualizar")){
			actualizar(request, response);
		}
				
	}
	
	public void modificaRespuesta(Respuesta obj){
		obj.setCodigoError(5);
		obj.setRespuesta("Respuesta modificada");
	}
	
	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre =request.getParameter("txtNombre");
		String apellidoPaterno=request.getParameter("txtApellidoPaterno");
		String apellidoMaterno =request.getParameter("txtApellidoMaterno");
	   String dni =request.getParameter("txtDni");
		String telefono=request.getParameter("txtTelefono");
		String direccion =request.getParameter("txtDireccion");
		String correo =request.getParameter("txtCorreo");
		
		UsuarioBean c = new UsuarioBean();
		/*
		 c.setNombreCliente(nombre);
		 
		c.setApellidoPaterno(apellidoPaterno);
		c.setApellidoMaterno(apellidoMaterno);
		c.setDni(dni);
		c.setTelefono(telefono);
		c.setDireccion(direccion);
		c.setCorreo(correo);

		
		service.registrarCliente(c);
		listar(request, response);
		*/
		
		
	}
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("DataCliente", service.listar());
		
		request.getRequestDispatcher("/FrmListarCliente.jsp").forward(request, response);
	
	}
	protected void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo=Integer.parseInt(request.getParameter("codigo"));
		
		String nombre =request.getParameter("txtNombre");
		String apellidoPaterno=request.getParameter("txtApellidoPaterno");
		String apellidoMaterno =request.getParameter("txtApellidoMaterno");
	   String dni =request.getParameter("txtDni");
		String telefono=request.getParameter("txtTelefono");
		String direccion =request.getParameter("txtDireccion");
		String correo =request.getParameter("txtCorreo");
	
		
		UsuarioBean c = new UsuarioBean();
		/*c.setCodigoCliente(codigo);
		c.setNombreCliente(nombre);
		c.setApellidoPaterno(apellidoPaterno);
		c.setApellidoMaterno(apellidoMaterno);
		c.setDni(dni);
		c.setTelefono(telefono);
		c.setDireccion(direccion);
		c.setCorreo(correo);

		
		service.actualizarCliente(c);
		listar(request, response);*/
		
	}
protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		int codigo=Integer.parseInt(request.getParameter("codigo"));
	
		service.eliminar(codigo);
		listar(request, response);
		*/

	}


protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	/*
	int codigo=Integer.parseInt(request.getParameter("codigo"));

	request.setAttribute("Listar", service.buscar(codigo));
   	request.getRequestDispatcher("/FrmActualizarCliente.jsp").forward(request, response);
	*/
	
}

}
