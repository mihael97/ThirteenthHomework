package hr.fer.zemris.java.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import hr.fer.zemris.java.strcutures.BandStructure;

/**
 * Class contains methods for loading files from disc and preparing informations
 * for writing on disc
 * 
 * @author Mihael
 *
 */
public abstract class Util {

	/**
	 * Method loads bends with informations from file
	 * 
	 * @param req
	 *            - request
	 * @return list of {@link BandStructure}
	 */
	public static List<BandStructure> loadBends(HttpServletRequest req) {
		Path path = Paths.get(req.getServletContext().getRealPath("/WEB-INF/glasanje-definicija.txt"));
		List<BandStructure> forReturn = new ArrayList<>();

		if (Files.exists(path)) {
			try {
				List<String> list = Files.readAllLines(path);

				for (String line : list) {
					String[] array = line.split("\t");

					forReturn.add(new BandStructure(array[0].trim(), array[1].trim(), array[2].trim()));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("Document with bands doesn't exist!");
		}

		return forReturn;
	}

	/**
	 * Method loads results from disc and prepares map where <code>key</code> is id
	 * of bend and <code>value</code> is number of votes
	 * 
	 * @param req
	 *            - request
	 * @return map with results
	 */
	public static Map<Integer, Integer> getResults(HttpServletRequest req) {
		Map<Integer, Integer> forReturn = new LinkedHashMap<>();

		try {
			for (String string : Files
					.readAllLines(Paths.get(req.getServletContext().getRealPath("/WEB-INF/glasanje-rezultati.txt")))) {
				String[] array = string.split("\t");

				forReturn.put(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return forReturn;
	}

	/**
	 * Method converts voting results into output format
	 * 
	 * @param list
	 *            - list with results
	 * @return string for write into file
	 */
	public static String resultToString(ArrayList<BandStructure> list) {
		StringBuilder builder = new StringBuilder();
		list.forEach(e -> builder.append(e.getId()).append("\t").append(e.getVote()).append("\n"));

		return builder.toString().substring(0, builder.length() - 1);
	}

}
