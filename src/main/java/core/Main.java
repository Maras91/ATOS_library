package core;

public class Main {

	public static void main(String[] args) {
		Library library = new Library();
		library.addBook("zabijaka", 1200, "A.Bober");
		library.addBook("drkula", 1950, "W.Koper");
		library.addBook("szachy", 2014, "A.Bcer");
		library.addBook("buka", 1200, "A.Boccaa");
		
		library.foundBooks("W.Koper","drkula");
		library.foundBooks("szachy","A.Bcer");
		
		library.foundBooks("W.Kopr","drkula");
		library.foundBooks("szacy","A.Bcer");
		
		library.foundBooks("szachy",2014);
		library.foundBooks("szachya",2014);
		library.foundBooks("szachy",12014);
		
		library.foundBooks("zabijaka", 1200, "A.Bober");
		library.foundBooks("zabijak", 1200, "A.Bober");
		library.foundBooks("zabijaka", 120, "A.Bober");
		library.foundBooks("zabijaka", 1200, "A.Bobe");
		
//		library.showAllBooks();
//		library.removeBook(2);
//		library.showAllBooks();
	}

}
