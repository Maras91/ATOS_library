package library;

public class Book {
	private static int highestId = 1;
	private String title;
	private int id;
	private int year;
	private String author;
	private Boolean isLend;
	private int CustomerId;

	Book(String title, int year, String autor) {
		this.title = title;
		this.year = year;
		this.author = autor;
		setIsLend(false);
		createUniqueId();
	}

	private void createUniqueId() {
		id = highestId;
		highestId++;
		return;
	}

	public int getId() {
		return id;
	}

	public int getYear() {
		return year;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Boolean getIsLend() {
		return isLend;
	}

	public void setIsLend(Boolean isLend) {
		this.isLend = isLend;
	}

	public String toString() {
		return "ID: " + id + " tltle: " + title + " author: " + author + " year: " + year;

	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
}
