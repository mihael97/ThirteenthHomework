package hr.fer.zemris.java.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import static java.lang.Math.pow;

/**
 * Class represents servelt for Excel document generator<br>
 * For document generating,process must have <code>3</code> parameters where
 * <code>a</code> and <code>b</code> our number interval limits and
 * <code>n</code> is number of pages we want to generate<br>
 * Every page in first column contains all number from <code>a</code> to
 * <code>b</code> and in second column power of every number on <code>i</code>
 * where <code>i</code> is number of current page
 * 
 * @author Mihael
 *
 */
public class ServletPowers extends HttpServlet {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Method parses number and if they are valid,calls method for document
	 * generating
	 * 
	 * @param req
	 *            - request
	 * @param resp
	 *            - response
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int a = 0;
		HSSFWorkbook workbook = null;
		try {
			a = Integer.parseInt("a");

			if (a < -100 || a > 100) {
				sendError(req, resp);
				return;
			}
		} catch (NumberFormatException e) {
			sendError(req, resp);
			return;
		}

		int b = 0;

		try {
			b = Integer.parseInt("b");

			if (b < -100 || b > 100) {
				sendError(req, resp);
				return;
			}
		} catch (NumberFormatException e) {
			sendError(req, resp);
			return;
		}

		int n = 0;

		try {
			n = Integer.parseInt("n");

			if (!(n >= 1 && n <= 5)) {
				sendError(req, resp);
				return;
			}
		} catch (NumberFormatException e) {
			sendError(req, resp);
			return;
		}

		workbook = makeDocument(a, b, n);

		if (workbook == null) {
			sendError(req, resp);
			return;
		}

		workbook.write(resp.getOutputStream());
		resp.getOutputStream().flush();
		resp.getOutputStream().close();
	}

	/**
	 * Method generates document with <code>n</code> pages
	 * 
	 * @param a
	 *            - lower bound
	 * @param b
	 *            - upper bound
	 * @param n
	 *            - number of pages
	 * @return generated document
	 */
	private HSSFWorkbook makeDocument(int a, int b, int n) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet[] sheetArray = new HSSFSheet[n];

		for (int page = 0; page < n; page++) {
			sheetArray[page] = workbook.createSheet(String.valueOf(page));

			int index = 0;
			for (int i = a; i <= b; i++) {
				HSSFRow row = sheetArray[page].createRow(index++);

				row.createCell(0).setCellValue(i);
				row.createCell(1).setCellValue(pow(i, page + 1));
			}
		}

		return workbook;
	}

	/**
	 * Method calls page for errors
	 * 
	 * @param req
	 *            - request
	 * @param resp
	 *            - response
	 */
	private void sendError(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/WEB-INF/pages/powersError.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
