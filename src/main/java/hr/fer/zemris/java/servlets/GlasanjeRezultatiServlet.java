package hr.fer.zemris.java.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.fer.zemris.java.strcutures.BandStructure;

public class GlasanjeRezultatiServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Path path = Paths.get(req.getServletContext().getRealPath("/WEB-INF/glasanjerezultati.txt"));

		Map<String, Integer> map = new LinkedHashMap<>();

		if (Files.exists(path)) {
			for (String string : Files.readAllLines(path)) {
				String[] array = string.split("\t");
				map.put(array[0], Integer.parseInt(array[1]));
			}
		} else {
			for (BandStructure band : (List<BandStructure>) req.getSession().getAttribute("bands")) {
				map.put(band.getId(), 0);
			}
		}

		List<BandStructure> sorted = new ArrayList<>();
		List<BandStructure> best = new ArrayList<>();

		getResults(sorted, best, map);

		req.getSession().setAttribute("sorted", sorted);
		req.getSession().setAttribute("best", best);

		req.getRequestDispatcher("/WEB-INF/pages/glasanjeRez.jsp").forward(req, resp);
	}

	private void getResults(List<BandStructure> sorted, List<BandStructure> best, Map<String, Integer> map) {

		Collection<Integer> values = map.values();
		Collections.sort(new ArrayList<>(values));
		Collections.reverse(new ArrayList<>(values));

		boolean bestFlag = true;

		for (Integer value : values) {
			for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
				BandStructure struc = new BandStructure(mapEntry.getKey(), null, null, value);
				sorted.add(struc);
				if (bestFlag) {
					best.add(struc);
				}
			}

			bestFlag = false;
		}
	}
}
