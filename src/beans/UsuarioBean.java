package beans;

public class UsuarioBean {
	private int id;
	private String nombre;
	private String fechanac;
	private String email;
	private String fecha_creacion;
	private String fecha_actualizacion;
	private String usuario_creacion;
	private String usuario_actualizacion;
	private String codigo_usuario;
	private String estado;
	private String contrasena; 
	private int tipo_usuario;
	private int numero_documento; 
	private int tipo_documento;
	private int ubigeo;
	private String sexo;
	private String nombre_tipo_usuario;
	private String nombre_tipo_documento;
	
	public UsuarioBean(){
		
	}
	
	public UsuarioBean(int id, String nombre, String fechanac, String email,
			String fecha_creacion, String fecha_actualizacion,
			String usuario_creacion, String usuario_actualizacion,
			String codigo_usuario, String estado, String contrasena,
			int tipo_usuario, int numero_documento, int cod_tipo_documento,
			int ubigeo, String sexo, String nombre_tipo_usuario,
			String nombre_tipo_documento, int tipo_documento) {
		super();

		this.id = id;
		this.nombre = nombre;
		this.fechanac = fechanac;
		this.email = email;
		this.fecha_creacion = fecha_creacion;
		this.fecha_actualizacion = fecha_actualizacion;
		this.usuario_creacion = usuario_creacion;
		this.usuario_actualizacion = usuario_actualizacion;
		this.codigo_usuario = codigo_usuario;
		this.estado = estado;
		this.contrasena = contrasena;
		this.tipo_usuario = tipo_usuario;
		this.numero_documento = numero_documento;
		this.tipo_documento = tipo_documento;
		this.ubigeo = ubigeo;
		this.sexo = sexo;
		this.nombre_tipo_usuario = nombre_tipo_usuario;
		this.nombre_tipo_documento = nombre_tipo_documento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechanac() {
		return fechanac;
	}

	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getFecha_actualizacion() {
		return fecha_actualizacion;
	}

	public void setFecha_actualizacion(String fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public String getUsuario_creacion() {
		return usuario_creacion;
	}

	public void setUsuario_creacion(String usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}

	public String getUsuario_actualizacion() {
		return usuario_actualizacion;
	}

	public void setUsuario_actualizacion(String usuario_actualizacion) {
		this.usuario_actualizacion = usuario_actualizacion;
	}

	public String getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(String codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public int getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(int numero_documento) {
		this.numero_documento = numero_documento;
	}

	public int getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(int tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public int getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(int ubigeo) {
		this.ubigeo = ubigeo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getNombre_tipo_usuario() {
		return nombre_tipo_usuario;
	}

	public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
		this.nombre_tipo_usuario = nombre_tipo_usuario;
	}

	public String getNombre_tipo_documento() {
		return nombre_tipo_documento;
	}

	public void setNombre_tipo_documento(String nombre_tipo_documento) {
		this.nombre_tipo_documento = nombre_tipo_documento;
	}


	
}
