package ec.com.lemas.DAO;

import java.util.Date;

import ec.com.lemas.controller.FrmUsuario;

public class UsuarioDao {
	
	private String codigoUsuario;
	private String usuario;
	private String clave;
	private String factor1;
	private String factor2;
	private String estado;
	private Date fechaActualizacion;
	private String usuarioCreacion;

	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getFactor1() {
		return factor1;
	}
	public void setFactor1(String factor1) {
		this.factor1 = factor1;
	}
	public String getFactor2() {
		return factor2;
	}
	public void setFactor2(String factor2) {
		this.factor2 = factor2;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	
	

}
