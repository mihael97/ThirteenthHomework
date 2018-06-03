package hr.fer.zemris.java.strcutures;

public class BandStructure {
	private String id;
	private String name;
	private String link;
	private Integer vote;

	public BandStructure(String id, String name, String link) {
		this(id, name, link, 0);
	}

	public BandStructure(String id, String name, String link, Integer vote) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.vote = vote;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}

	public Integer getVote() {
		return vote;
	}
}
