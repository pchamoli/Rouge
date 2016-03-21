package beans;

public class UbigeoBean {

	private int cod_ubigeo;
	private String pais;
	private String cod_departamento;
	private String cod_provincia;
	private String cod_distrito;
	private String descripcion;
	private String v_descripcion_larga;
	
	public UbigeoBean(int cod_ubigeo, String pais, String cod_departamento,
			String cod_provincia, String cod_distrito, String descripcion,
			String v_descripcion_larga) {
		this.cod_ubigeo = cod_ubigeo;
		this.pais = pais;
		this.cod_departamento = cod_departamento;
		this.cod_provincia = cod_provincia;
		this.cod_distrito = cod_distrito;
		this.descripcion = descripcion;
		this.v_descripcion_larga = v_descripcion_larga;
	}

	public int getCod_ubigeo() {
		return cod_ubigeo;
	}

	public void setCod_ubigeo(int cod_ubigeo) {
		this.cod_ubigeo = cod_ubigeo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCod_departamento() {
		return cod_departamento;
	}

	public void setCod_departamento(String cod_departamento) {
		this.cod_departamento = cod_departamento;
	}

	public String getCod_provincia() {
		return cod_provincia;
	}

	public void setCod_provincia(String cod_provincia) {
		this.cod_provincia = cod_provincia;
	}

	public String getCod_distrito() {
		return cod_distrito;
	}

	public void setCod_distrito(String cod_distrito) {
		this.cod_distrito = cod_distrito;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getV_descripcion_larga() {
		return v_descripcion_larga;
	}

	public void setV_descripcion_larga(String v_descripcion_larga) {
		this.v_descripcion_larga = v_descripcion_larga;
	}
	
	
	
}
