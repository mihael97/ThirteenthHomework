package hr.fer.zemris.java.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.fer.zemris.java.strcutures.BandStructure;

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
		List<BandStructure> bands = (List<BandStructure>) req.getSession().getAttribute("bands");

		if (Files.exists(path)) {
			for (String string : Files.readAllLines(path)) {
				String[] array = string.split("\t");
				int id = Integer.parseInt(array[0]);
				bands.get(id - 1).setVote(Integer.parseInt(array[1]));
				list.add(bands.get(id - 1));
			}
		} else {
			Files.createFile(path);
			for (BandStructure band : bands) {
				band.setVote(0);
				list.add(band);
			}
		}

		List<BandStructure> best = new ArrayList<>();

		getResults(best, list, req);

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
	private void getResults(List<BandStructure> best, List<BandStructure> list, HttpServletRequest req) {
		int max = 0;

		for (BandStructure band : list) {
			max = Math.max(max, band.getVote());
		}

		final int max2 = max;
		best = list.stream().filter(e -> e.getVote() == max2).collect(Collectors.toList());
		req.getSession().setAttribute("best", best);
	}
}
