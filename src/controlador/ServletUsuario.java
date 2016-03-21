package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UsuarioBean;

import services.UsuarioService;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	UsuarioService servi = new UsuarioService();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String metodo = request.getParameter("metodo");
		
		if(metodo.equals("registrar")){
			registrar(request,response);
		}
		else if(metodo.equals("modificar")){
			modificar(request,response);
		}
		else if(metodo.equals("iniciasesion")){
			iniciarsesion(request,response);
		}
		else if(metodo.equals("cierrasesion")){
			cerrarsesion(request,response);
		}
		
	}
	
	private void cerrarsesion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.setAttribute("msg", "iniciar sesion");
		request.getRequestDispatcher("").forward(request, response);
		
	}

	private void iniciarsesion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String correo = request.getParameter("txtEmail");
		String clave = request.getParameter("txtPassword");
		
		UsuarioBean obj = servi.logueausuario(correo);
		
		if(obj!=null){
			if(obj.getContrasena().equals(clave)){
				HttpSession sesion = request.getSession();
				sesion.setAttribute("datos", obj);
				request.getRequestDispatcher("/inicio.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "contraseña incorrecta");
				request.getRequestDispatcher("/iniciar-sesi-n.jsp").forward(request, response);
			}
		}
		else{
			request.setAttribute("msg", "usuario no existe");
			request.getRequestDispatcher("/iniciar-sesi-n.jsp").forward(request, response);
		}
		
	}

	private void modificar(HttpServletRequest request,
			HttpServletResponse response) {
	
		int	id = Integer.parseInt(request.getParameter("txtId"));
		String nombre = request.getParameter("txtNombre");
		String fechanac = request.getParameter("txtFecha");
		String email = request.getParameter("txtEmail");
		String fecha_creacion = request.getParameter("txtFechac");
		String fecha_actualizacion = request.getParameter("txtFechaa");
		String usuario_creacion = request.getParameter("txtUsuc");
		String usuario_actualizacion = request.getParameter("txtUsuac");
		String codigo_usuario = request.getParameter("txtCodus");
		String estado = request.getParameter("lblEstado");
		String contrasena = request.getParameter("txtPassword");
		int	tipo_usuario = Integer.parseInt(request.getParameter("txtTipousu"));
		int	numero_documento = Integer.parseInt(request.getParameter("txtNumdoc"));
		int ubigeo = Integer.parseInt(request.getParameter("cboDistrito"));
		//String distrito = request.getParameter("txtDistrito");
		String sexo = request.getParameter("cboSexo");
		
		UsuarioBean bean = new UsuarioBean();
		
		bean.setId(id);
		bean.setNombre(nombre);
		bean.setFechanac(fechanac);
		bean.setEmail(email);
		bean.setFecha_creacion(fecha_creacion);
		bean.setFecha_actualizacion(fecha_actualizacion);
		bean.setUsuario_creacion(usuario_creacion);
		bean.setUsuario_actualizacion(usuario_actualizacion);
		bean.setCodigo_usuario(codigo_usuario);
		bean.setEstado(estado);
		bean.setContrasena(contrasena);
		bean.setTipo_usuario(tipo_usuario);
		bean.setNumero_documento(numero_documento);
		bean.setUbigeo(ubigeo);
		bean.setSexo(sexo);
		
		servi.ModificaUsuario(bean);
		
		
	}
	
	private void registrar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
		String nombre = request.getParameter("txtNombre");
		String fechanac = request.getParameter("txtFecha");
		String email = request.getParameter("txtEmail");
		//String fecha_creacion = request.getParameter("txtFechac");
		//String fecha_actualizacion = request.getParameter("txtFechaa");
		//String usuario_creacion = request.getParameter("txtUsuc");
		//String usuario_actualizacion = request.getParameter("txtUsuac");
		String codigo_usuario = request.getParameter("txtCodus");
		//String estado = request.getParameter("lblEstado");
		String contrasena = request.getParameter("txtPassword");
		//int tipo_usuario = Integer.parseInt(request.getParameter("txtTipousu"));
		//int numero_documento = Integer.parseInt(request.getParameter("txtNumdoc"));
		//int tipo_documento = Integer.parseInt(request.getParameter("txtTipodoc"));
		int ubigeo = Integer.parseInt(request.getParameter("cboDistrito"));
		String sexo = request.getParameter("cboSexo");
		
		
		UsuarioBean bean = new UsuarioBean();
		
		bean.setNombre(nombre);
		bean.setFechanac(fechanac);
		bean.setEmail(email);
		//bean.setFecha_creacion(fecha_creacion);
		//bean.setFecha_actualizacion(fecha_actualizacion);
		//bean.setUsuario_actualizacion(usuario_creacion);
		//bean.setUsuario_actualizacion(usuario_actualizacion);
		bean.setCodigo_usuario(codigo_usuario);
		//bean.setEstado(estado);
		bean.setContrasena(contrasena);
		//bean.setTipo_usuario(tipo_usuario);
		//bean.setNumero_documento(numero_documento);
		//bean.setCod_tipo_documento(tipo_documento);
		bean.setUbigeo(ubigeo);
		bean.setSexo(sexo);
		
		servi.RegistraUsuario(bean);
		
		request.getRequestDispatcher("/reg-strate.jsp").forward(request,response);
		
	}
	
	

}
