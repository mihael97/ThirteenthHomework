package hr.fer.zemris.java.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.fer.zemris.java.strcutures.BandStructure;
import hr.fer.zemris.java.util.Util;

/**
 * Class represents servlet which analyzes our vote
 * 
 * @author Mihael
 *
 */
public class GlasanjeGlasajServlet extends HttpServlet {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Method catches band id and increment number of votes for that band in file
	 * form disc
	 * 
	 * @param req
	 *            - request
	 * @param resp
	 *            - response
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Path path = Paths.get(req.getServletContext().getRealPath("/WEB-INF/glasanje-rezultati.txt"));
		Integer idVote = Integer.parseInt((String) req.getParameter("id"));

		Map<Integer, Integer> map = new LinkedHashMap<>();

		if (Files.exists(path)) { // file already exists
			map = Util.getResults(req);
			map.merge(idVote, 1, (i, j) -> i + j);
		} else { // file doesn't exist
			for (BandStructure band : Util.loadBends(req)) {
				map.put(Integer.parseInt(band.getId()), (idVote == Integer.parseInt(band.getId().trim())) ? 1 : 0);
			}
		}

		StringBuilder builder = new StringBuilder();
		map.forEach((i, j) -> builder.append(i + "\t" + j + "\n"));
		Files.write(path, builder.toString().substring(0, builder.length() - 1).getBytes());

		resp.sendRedirect(req.getContextPath() + "/glasanje-rezultati");
	}
}
