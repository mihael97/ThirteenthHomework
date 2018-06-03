package hr.fer.zemris.java.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.fer.zemris.java.strcutures.BandStructure;

public class GlasanjeGlasajServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Path path = Paths.get(req.getServletContext().getRealPath("/WEB-INF/glasanjerezultati.txt"));
		Integer idVote = Integer.parseInt((String) req.getAttribute("id"));

		Map<String, Integer> map = new LinkedHashMap<>();

		if (Files.exists(path)) { // file already exists
			for (String line : Files.readAllLines(path)) {
				String[] array = line.split("\t");
				Integer value = Integer.parseInt(array[0]);
				map.put(array[0], (idVote == value ? value + 1 : value));
			}
		} else { // file doesn't exist
			for (BandStructure band : (List<BandStructure>) req.getSession().getAttribute("bands")) {
				map.put(band.getId(), (idVote == Integer.parseInt(band.getId())) ? 1 : 0);
			}
		}

		StringBuilder builder = new StringBuilder();
		map.forEach((i, j) -> builder.append(i + "\t" + j + "\n"));
		Files.write(path, builder.toString().substring(0, builder.length() - 1).getBytes());

		resp.sendRedirect(req.getContextPath() + "/glasanje-rezultati");
	}
}
