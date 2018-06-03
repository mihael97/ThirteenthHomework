package hr.fer.zemris.java.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.fer.zemris.java.strcutures.BandStructure;

public class ServletGraphic extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder builder = new StringBuilder();
		List<BandStructure> list = (List<BandStructure>) req.getAttribute("sorted");

		for (BandStructure structure : list) {
			builder.append("&").append(structure.getId()).append("=").append(structure.getVote());
		}

		builder = new StringBuilder(builder.substring(1));
		resp.sendRedirect(req.getContextPath() + "/reportImage?" + builder.toString());
	}
}
