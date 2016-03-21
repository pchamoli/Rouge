package beans;

public class ParametroBean {

	private int n_codigo_parametro;
	private int n_secuencia;
	private String c_sistema;
	private String v_nombre_parametro;
	private String v_valor;
	private String v_descripcion;
	private String v_descripcion_larga;
	private String v_default;
	private String v_equivalencia;
	private String c_estado;
	private int n_codigo_padre;
	private int n_secuencia_padre;
	private String d_fecha_actualizacion;
	private String d_fecha_creacion;
	private String c_usuario_actualizacion;
	private String c_Usuario_Creacion;
	
	public ParametroBean(int n_codigo_parametro, int n_secuencia,
			String c_sistema, String v_nombre_parametro, String v_valor,
			String v_descripcion, String v_descripcion_larga, String v_default,
			String v_equivalencia, String c_estado, int n_codigo_padre,
			int n_secuencia_padre, String d_fecha_actualizacion,
			String d_fecha_creacion, String c_usuario_actualizacion,
			String c_Usuario_Creacion) {
	
		this.n_codigo_parametro = n_codigo_parametro;
		this.n_secuencia = n_secuencia;
		this.c_sistema = c_sistema;
		this.v_nombre_parametro = v_nombre_parametro;
		this.v_valor = v_valor;
		this.v_descripcion = v_descripcion;
		this.v_descripcion_larga = v_descripcion_larga;
		this.v_default = v_default;
		this.v_equivalencia = v_equivalencia;
		this.c_estado = c_estado;
		this.n_codigo_padre = n_codigo_padre;
		this.n_secuencia_padre = n_secuencia_padre;
		this.d_fecha_actualizacion = d_fecha_actualizacion;
		this.d_fecha_creacion = d_fecha_creacion;
		this.c_usuario_actualizacion = c_usuario_actualizacion;
		this.c_Usuario_Creacion = c_Usuario_Creacion;
	}

	public int getN_codigo_parametro() {
		return n_codigo_parametro;
	}

	public void setN_codigo_parametro(int n_codigo_parametro) {
		this.n_codigo_parametro = n_codigo_parametro;
	}

	public int getN_secuencia() {
		return n_secuencia;
	}

	public void setN_secuencia(int n_secuencia) {
		this.n_secuencia = n_secuencia;
	}

	public String getC_sistema() {
		return c_sistema;
	}

	public void setC_sistema(String c_sistema) {
		this.c_sistema = c_sistema;
	}

	public String getV_nombre_parametro() {
		return v_nombre_parametro;
	}

	public void setV_nombre_parametro(String v_nombre_parametro) {
		this.v_nombre_parametro = v_nombre_parametro;
	}

	public String getV_valor() {
		return v_valor;
	}

	public void setV_valor(String v_valor) {
		this.v_valor = v_valor;
	}

	public String getV_descripcion() {
		return v_descripcion;
	}

	public void setV_descripcion(String v_descripcion) {
		this.v_descripcion = v_descripcion;
	}

	public String getV_descripcion_larga() {
		return v_descripcion_larga;
	}

	public void setV_descripcion_larga(String v_descripcion_larga) {
		this.v_descripcion_larga = v_descripcion_larga;
	}

	public String getV_default() {
		return v_default;
	}

	public void setV_default(String v_default) {
		this.v_default = v_default;
	}

	public String getV_equivalencia() {
		return v_equivalencia;
	}

	public void setV_equivalencia(String v_equivalencia) {
		this.v_equivalencia = v_equivalencia;
	}

	public String getC_estado() {
		return c_estado;
	}

	public void setC_estado(String c_estado) {
		this.c_estado = c_estado;
	}

	public int getN_codigo_padre() {
		return n_codigo_padre;
	}

	public void setN_codigo_padre(int n_codigo_padre) {
		this.n_codigo_padre = n_codigo_padre;
	}

	public int getN_secuencia_padre() {
		return n_secuencia_padre;
	}

	public void setN_secuencia_padre(int n_secuencia_padre) {
		this.n_secuencia_padre = n_secuencia_padre;
	}

	public String getD_fecha_actualizacion() {
		return d_fecha_actualizacion;
	}

	public void setD_fecha_actualizacion(String d_fecha_actualizacion) {
		this.d_fecha_actualizacion = d_fecha_actualizacion;
	}

	public String getD_fecha_creacion() {
		return d_fecha_creacion;
	}

	public void setD_fecha_creacion(String d_fecha_creacion) {
		this.d_fecha_creacion = d_fecha_creacion;
	}

	public String getC_usuario_actualizacion() {
		return c_usuario_actualizacion;
	}

	public void setC_usuario_actualizacion(String c_usuario_actualizacion) {
		this.c_usuario_actualizacion = c_usuario_actualizacion;
	}

	public String getC_Usuario_Creacion() {
		return c_Usuario_Creacion;
	}

	public void setC_Usuario_Creacion(String c_Usuario_Creacion) {
		this.c_Usuario_Creacion = c_Usuario_Creacion;
	}
	
	

	
}
