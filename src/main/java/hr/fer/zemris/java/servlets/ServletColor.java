package hr.fer.zemris.java.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class represents servlet for background color changing
 * 
 * @author Mihael
 *
 */
public class ServletColor extends HttpServlet {
	/**
	 * serialUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Method catches picked background color form session attribute and forwards
	 * request to <code>colors.jsp</code>
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		resp.setStatus(HttpServletResponse.SC_ACCEPTED);

		req.getSession().setAttribute("pickedBgCol", req.getParameter("pickedBgCol"));
		req.getRequestDispatcher("/colors.jsp").forward(req, resp);
	}
}
