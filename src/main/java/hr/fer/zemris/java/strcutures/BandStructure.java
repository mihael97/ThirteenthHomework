package hr.fer.zemris.java.strcutures;

/**
 * Class represents bands structure with informations:<br>
 * 
 * <ul>
 * <li>id</li>
 * <li>name</li>
 * <li>link</li>
 * <li>vote</li>
 * </ul>
 * 
 * @author Mihael
 *
 */
public class BandStructure {
	/**
	 * Band identification number
	 */
	private String id;
	/**
	 * Band name
	 */
	private String name;
	/**
	 * Band link
	 */
	private String link;
	/**
	 * Number of votes band get
	 */
	private Integer vote;

	/**
	 * COnstructor for new {@link BandStructure}
	 * 
	 * @param id
	 *            - id
	 * @param name
	 *            - name
	 * @param link
	 *            - link
	 */
	public BandStructure(String id, String name, String link) {
		this.id = id;
		this.name = name;
		this.link = link;
	}

	/**
	 * Method returns band id
	 * 
	 * @return band id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Method returns band name
	 * 
	 * @return band name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method returns link to band song
	 * 
	 * @return link to band song
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Method returns number of votes band has
	 * 
	 * @return number of votes
	 */
	public Integer getVote() {
		return vote;
	}

	/**
	 * Method sets band's number of votes
	 * 
	 * @param vote
	 *            - new number of votes
	 */
	public void setVote(Integer vote) {
		this.vote = vote;
	}

}
