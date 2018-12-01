package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Owner;

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
}