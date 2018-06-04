package hr.fer.zemris.java.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import hr.fer.zemris.java.strcutures.BandStructure;

/**
 * Class represents XLS document generator
 * 
 * @author Mihael
 *
 */
public class ServletXLS extends HttpServlet {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Method catches all bands with informations from memory and generates document
	 * with it
	 * 
	 * @param req
	 *            - request
	 * @param resp
	 *            - response
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/vnd.ms-excel; charsets=utf-8");
		resp.setStatus(HttpServletResponse.SC_OK);

		HSSFWorkbook file = generateDocument((List<BandStructure>) req.getSession().getAttribute("allItems"));

		file.write(resp.getOutputStream());
		resp.getOutputStream().flush();
		resp.getOutputStream().close();
	}

	/**
	 * Method generates document with voting informations
	 * 
	 * @param stored
	 *            - list of stored bands with votes
	 * @return {@link HSSFWorkbook}
	 */
	private HSSFWorkbook generateDocument(List<BandStructure> stored) {
		HSSFWorkbook file = new HSSFWorkbook();
		HSSFSheet sheet = file.createSheet("Voting results");
		for (int i = 0, length = stored.size(); i < length; i++) {
			HSSFRow row = sheet.createRow(i);
			row.createCell(0).setCellValue(stored.get(i).getName());
			row.createCell(1).setCellValue(stored.get(i).getVote());
		}

		return file;
	}
}
