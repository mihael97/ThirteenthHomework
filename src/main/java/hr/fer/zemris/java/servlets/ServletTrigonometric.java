package hr.fer.zemris.java.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.fer.zemris.java.strcutures.TrigonometricResult;

/**
 * Class represents servlet for trigonometric operations(sine and cosine)
 * 
 * @author Mihael
 *
 */
public class ServletTrigonometric extends HttpServlet {
	/**
	 * serialUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Method performs trigonometric operation processing
	 * 
	 * @param req
	 *            - request
	 * @param resp
	 *            - response
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer a = Integer.valueOf(0), b = Integer.valueOf(360);

		// value a
		String param = (String) req.getParameter("a");

		try {
			a = Integer.parseInt(param);
		} catch (Exception ignore) {

		}

		// value b
		param = req.getParameter("b");
		try {
			b = Integer.parseInt(param);
		} catch (Exception ignore) {

		}

		if (a > b) {
			swap(a, b);
		} else if (b > (a + 270)) {
			b = Integer.valueOf(a.intValue() + 270);
		}

		// we need to create structure which will contain sine and cosine of number
		List<TrigonometricResult> list = new ArrayList<>();

		for (int i = a; i <= b; i++) {
			list.add(new TrigonometricResult(i));
		}

		req.setAttribute("trigonometricResult", list);

		req.getRequestDispatcher("/WEB-INF/pages/trigonometric.jsp").forward(req, resp);
	}

	/**
	 * Method swaps values from two objects
	 * 
	 * @param a
	 *            - first value
	 * @param b
	 *            - second value
	 */
	private void swap(Integer a, Integer b) {
		int pom = a.intValue();
		a = Integer.valueOf(b.intValue());
		b = Integer.valueOf(pom);
	}
}
