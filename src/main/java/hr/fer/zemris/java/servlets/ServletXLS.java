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

public class ServletXLS extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text; charsets=utf-8");
		resp.setStatus(HttpServletResponse.SC_ACCEPTED);

		HSSFWorkbook file = generateDocument((List<BandStructure>) req.getSession().getAttribute("stored"),
				(List<BandStructure>) req.getSession().getAttribute("bends"));

		file.write(resp.getOutputStream());
		resp.getOutputStream().flush();
		resp.getOutputStream().close();
	}

	private HSSFWorkbook generateDocument(List<BandStructure> stored, List<BandStructure> bends) {
		HSSFWorkbook file = new HSSFWorkbook();
		HSSFSheet sheet = file.createSheet();
		for (int i = 0, length = stored.size(); i < length; i++) {
			BandStructure storedValue = stored.get(i);
			BandStructure bandInfo = bends.get(Integer.parseInt(storedValue.getId()) - 1);

			HSSFRow row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(bandInfo.getName());
			row.createCell(1).setCellValue(storedValue.getVote());
		}

		return file;
	}
}
