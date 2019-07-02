package sistbancario.main.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	private String rut;
	@Column(name="nombres")
	private String nombres;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="email")
	private String email;
	@Column(name="celular")
	private String celular;
	
	//------------------------------------Constructor---------------------------
	
	public Cliente(String rut, String nombres, String apellidos, String email, String celular) {
		this.rut = rut;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.celular = celular;
	}
	
	public Cliente() {
		this.rut = "";
		this.nombres = "";
		this.apellidos = "";
		this.email = "";
		this.celular = "";
	}
	
	//--------------------------------getter and setter----------------------
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public boolean equals(Cliente otro) {
		if(!this.rut.equals(otro.rut))
			return false;
		if(!this.nombres.equals(otro.nombres))
			return false;
		if(!this.apellidos.equals(otro.apellidos))
			return false;
		if(!this.email.equals(otro.email))
			return false;
		return this.celular.equals(otro.celular);
	}
	
}
