package es.salesianos.model;

import java.util.Date;

public class Owner {
	private Integer codOwner;
	private String name;
	private String surname;

	public void setName(String name) {
		this.name=name;
		
	}

	public String getName() {
		return name;
	}
	
	public void setCodOwner(Integer codOwner) {
		this.codOwner=codOwner;
	}
	
	public Integer getCodOwner() {
		return codOwner;
	}

	public void setSurname(String surname) {
		this.surname=surname;
	}
	
	public String getSurname() {
		return surname;
	}

	@Override
	public String toString() {
		return "User [codOwner="+codOwner+ "name=" + name + ", surname=" + surname + "]";
	}
	

}
