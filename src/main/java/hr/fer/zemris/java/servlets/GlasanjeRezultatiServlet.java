package hr.fer.zemris.java.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.fer.zemris.java.strcutures.BandStructure;
import hr.fer.zemris.java.util.Util;

/**
 * Class represents voting analyzer
 * 
 * @author Mihael
 *
 */
public class GlasanjeRezultatiServlet extends HttpServlet {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Method loads document from disc and analyzes results
	 * 
	 * @param req
	 *            - request
	 * @param resp
	 *            - response
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Path path = Paths.get(req.getServletContext().getRealPath("/WEB-INF/glasanje-rezultati.txt"));

		ArrayList<BandStructure> list = new ArrayList<>();
		List<BandStructure> bands = Util.loadBends(req);

		if (Files.exists(path)) {
			for (Map.Entry<Integer, Integer> map : Util.getResults(req).entrySet()) {
				bands.get(map.getKey() - 1).setVote(map.getValue());
				list.add(bands.get(map.getKey() - 1));
			}
		} else {
			Files.createFile(path);
			for (BandStructure band : bands) {
				band.setVote(0);
				list.add(band);
			}

			String results = Util.resultToString(list);
			Files.write(path, results.getBytes());
		}

		getResults(list, req);

		req.getSession().setAttribute("allItems", list);

		req.getRequestDispatcher("/WEB-INF/pages/glasanjeRez.jsp").forward(req, resp);
	}

	/**
	 * Method analyzes current voting results
	 * 
	 * @param best
	 *            - list of best bands(with higher number of votes)
	 * @param list
	 *            - list of all bands with results
	 * @param req
	 *            - request
	 */
	private void getResults(List<BandStructure> list, HttpServletRequest req) {
		int max = 0;

		for (BandStructure band : list) {
			max = Math.max(max, band.getVote());
		}

		List<BandStructure> best = new ArrayList<>();
		final int max2 = max;
		best = list.stream().filter(e -> e.getVote() == max2).collect(Collectors.toList());
		req.getSession().setAttribute("best", best);
	}
}
