package hr.fer.zemris.java.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import hr.fer.zemris.java.strcutures.BandStructure;
import hr.fer.zemris.java.util.Util;

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
		resp.setHeader("Content-Disposition", "attachment; filename=\"tablica.xls\"");
		resp.setStatus(HttpServletResponse.SC_OK);

		HSSFWorkbook file = generateDocument(Util.getResults(req), Util.loadBends(req));

		file.write(resp.getOutputStream());
		resp.getOutputStream().flush();
		resp.getOutputStream().close();
	}

	/**
	 * Method generates document with voting informations
	 * 
	 * @param map
	 *            - list of stored bands with votes
	 * @param list
	 * @return {@link HSSFWorkbook}
	 */
	private HSSFWorkbook generateDocument(Map<Integer, Integer> map, List<BandStructure> list) {
		HSSFWorkbook file = new HSSFWorkbook();
		HSSFSheet sheet = file.createSheet("Voting results");
		int i = 0;
		for (Map.Entry<Integer, Integer> pomMap : map.entrySet()) {
			HSSFRow row = sheet.createRow(i);
			row.createCell(0).setCellValue(list.get(pomMap.getKey() - 1).getName());
			row.createCell(1).setCellValue(pomMap.getValue());
			i++;
		}

		return file;
	}
}
