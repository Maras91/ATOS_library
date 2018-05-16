package library;

public class Library {
	private BooksList allBooks;
	private CustomersList allCustomers;

	public BooksList getAllBooks() {
		return allBooks;
	}

	public CustomersList getAllCustomers() {
		return allCustomers;
	}

	public Library() {
		allBooks = new BooksList();
		allCustomers = new CustomersList();
		allBooks.addBook("Zabijaka", 2000, "A.Bober");
		allBooks.addBook("Drakula", 1950, "W.Koper");
		allBooks.addBook("Szachy", 2014, "A.Bcer");
		allBooks.addBook("Kolo", 2015, "A.Boccaa");
		allBooks.addBook("Tanie ¿ycie", 1978, "W.Koper");
		allBooks.addBook("Strach na lachy", 2002, "A.Bcer");
		allBooks.addBook("Ale jaja", 2003, "A.Boccaa");
	}

	public void lendBook(int customerid, int bookId) {
		Book chosenBook = allBooks.findBookById(bookId);
		Customer customer = allCustomers.findCustomerkById(customerid);

		if (chosenBook.getIsLend()) {
			throw new IllegalArgumentException("The book with id: " + bookId + " is already lended by customer "
					+ allCustomers.findCustomerkById(chosenBook.getCustomerId()));
		}
		chosenBook.setIsLend(true);
		chosenBook.setCustomerId(customer.getId());
		customer.addBook(chosenBook);

	}

	public void bookDetails(int id) {
		Book chosenBook = allBooks.findBookById(id);
		System.out.print(chosenBook.toString());
		if (chosenBook.getIsLend()) {
			Customer customer = allCustomers.findCustomerkById(chosenBook.getCustomerId());
			System.out.println(" book lended by " + customer.toString());
		} else {
			System.out.println(" book is not lend");
		}
	}
}
