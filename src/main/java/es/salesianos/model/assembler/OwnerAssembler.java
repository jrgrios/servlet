package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Owner;
import es.salesianos.model.Pelicula;

public class OwnerAssembler {

	public static Actor assembleOwnerFrom(HttpServletRequest req) {
		Actor actor = new Actor();
		String lugarNacimiento=req.getParameter("lugarNacimiento");
		String nomActor=req.getParameter("nomActor");
		String apellidos=req.getParameter("apellidos");
		actor.setLugarNacimiento(lugarNacimiento);
		actor.setNomActor(nomActor);
		actor.setApellidos(apellidos);
		return actor;
	}
	
	public static Pelicula assemblePeliculaFrom(HttpServletRequest req) {
		Pelicula pelicula = new Pelicula();
		String titulo=req.getParameter("titulo");
		String ano=req.getParameter("ano");
		String comentario=req.getParameter("comentario");
		String trailer=req.getParameter("trailer");

		pelicula.setTitulo(titulo);
		pelicula.setAno(ano);
		pelicula.setComentario(comentario);
		pelicula.setTrailer(trailer);
		
		
		return pelicula;
	}
}