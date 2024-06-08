package model;

public class DVD implements LibraryItem{

	private String title;
	private String upc;
	private String subject;
	private String actors;
	private String director;
	private String genre;
	
	public DVD(String title, String upc, String subject, String actors, String director, String genre) {
		this.title = title;
		this.upc = upc;
		this.subject = subject;
		this.actors = actors;
		this.director = director;
		this.genre = genre;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getUpc() {
		return upc;
	}

	@Override
	public String getSubject() {
		return subject;
	}

	public String getActors() {
		return actors;
	}

	public String getDirector() {
		return director;
	}

	public String getGenre() {
		return genre;
	}
	
	
	

}
