package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.service.ListService;
import es.salesianos.model.Owner;

public class ListadoServlet extends HttpServlet {
	
	private ListService servicio = new  ListService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Owner> listAllOwners = servicio.listAllOwners();
		req.setAttribute("listAllOwners", listAllOwners);
		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listOwner.jsp");
		dispatcher.forward(req,resp);
	}
}
