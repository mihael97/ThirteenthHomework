package hr.fer.zemris.java.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.fer.zemris.java.util.Util;

/**
 * Method represents data loader for voting form
 * 
 * @author MIhael
 *
 */
public class GlasanjeServlet extends HttpServlet {
	/**
	 * serialVersonUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Method loads bends informations form disc
	 * 
	 * @param req
	 *            - request
	 * @param resp
	 *            - response
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(HttpServletResponse.SC_ACCEPTED);
		resp.setContentType("html/text; charset=utf-8");

		req.getSession().setAttribute("bands", Util.loadBends(req));
		req.getRequestDispatcher("/WEB-INF/pages/glasanjeIndex.jsp").forward(req, resp);
	}
}
