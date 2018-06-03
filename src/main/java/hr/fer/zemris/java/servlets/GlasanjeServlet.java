package hr.fer.zemris.java.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.fer.zemris.java.strcutures.BandStructure;

public class GlasanjeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getServletContext().getRealPath("/WEB-INF/glasanje-definicija.txt");
		resp.setStatus(HttpServletResponse.SC_ACCEPTED);
		resp.setContentType("html/text; charset=utf-8");

		List<String> bandList = Files.readAllLines(Paths.get(fileName));
		List<BandStructure> list = new ArrayList<>();
		for (String line : bandList) {
			String[] array = line.split("\t");

			list.add(new BandStructure(array[0].trim(), array[1].trim(), array[2].trim()));
		}

		list.forEach(e -> e.getName());
		req.getSession().setAttribute("bands", list);
		req.getRequestDispatcher("/WEB-INF/pages/glasanjeIndex.jsp").forward(req, resp);
	}
}
