package model;

public class CD implements LibraryItem {
	
	private String title;
	private String upc;
	private String subject;
	private String artist;
	
	public CD(String title, String upc, String subject, String artist) {
		this.title = title;
		this.upc = upc;
		this.subject = subject;
		this.artist = artist;
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

	public String getArtist() {
		return artist;
	}	
}
