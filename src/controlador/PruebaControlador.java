package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UsuarioBean;
import services.UsuarioService;

/**
 * Servlet implementation class ClienteControlador
 */
@WebServlet("/usuario")
public class PruebaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioService service = new UsuarioService();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String metodo=request.getParameter("metodo");
		
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
