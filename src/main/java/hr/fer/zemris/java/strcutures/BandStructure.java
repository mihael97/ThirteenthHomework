package hr.fer.zemris.java.strcutures;

public class BandStructure {
	private String id;
	private String name;
	private String link;
	private Integer vote;

	public BandStructure(String id, String name, String link) {
		this.id = id;
		this.name = name;
		this.link = link;
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

	public void setVote(Integer vote) {
		this.vote = vote;
	}

}
