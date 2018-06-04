package hr.fer.zemris.java.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.fer.zemris.java.strcutures.BandStructure;


public class ServletGraphic extends HttpServlet {
	/**
	 * Method puts all names with votes in valid form and then redirect
	 * informations to graph generator
	 * 
	 * @param req
	 *            - request
	 * @param resp
	 *            - response
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder builder = new StringBuilder();
		List<BandStructure> list = (List<BandStructure>) req.getSession().getAttribute("allItems");

		for (BandStructure struc : list) {
			builder.append("&").append(struc.getName()).append("=").append(struc.getVote());
		}

		resp.sendRedirect(req.getContextPath() + "/reportImage?" + builder.toString().substring(1));
	}
}
