package es.salesianos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pelicula {
	private Integer codPelicula;
	private String titulo;
	private String ano;
	private String comentario;
	private String trailer;
	
	
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public Integer getCodPelicula() {
		return codPelicula;
	}
	public void setCodPelicula(Integer codPelicula) {
		this.codPelicula = codPelicula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
