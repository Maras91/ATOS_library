package core;

public class Main {

	public static void main(String[] args) {
		Library library = new Library();
		library.addBook("zabijaka", 1200, "A.Bober");
		library.addBook("drkula", 1950, "W.Koper");
		library.addBook("szachy", 2014, "A.Bcer");
		library.showAllBooks();
		library.removeBook(2);
		library.showAllBooks();
	}

}
