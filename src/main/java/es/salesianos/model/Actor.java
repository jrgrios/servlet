package es.salesianos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Actor {
	private Integer codActor;
	private String lugarNacimiento;
	private String nomActor;
	private String apellidos;
	public Integer getCodActor() {
		return codActor;
	}
	public void setCodActor(Integer codActor) {
		this.codActor = codActor;
	}
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}
	public void setLugarNacimiento(String i) {
		this.lugarNacimiento = i;
	}
	public String getNomActor() {
		return nomActor;
	}
	public void setNomActor(String nomActor) {
		this.nomActor = nomActor;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	

}
