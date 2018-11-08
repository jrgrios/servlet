package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Pet;

public class PetAssembler {
	public static Pet assembleOwnerFrom(HttpServletRequest req) {
		Pet owner = new Pet();
		String codOwner=req.getParameter("codOwner");
		if(null != codOwner) {
			owner.setCodOwner(Integer.parseInt(codOwner));
		}
		String name = req.getParameter("name");
		String lastname = req.getParameter("surname");
		owner.setName(name);
		owner.setSurname(lastname);
		return owner;
	}
}
