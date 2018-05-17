package library;

import java.util.ArrayList;
import java.util.List;

public class BooksList {
	private List<Book> allBooks;

	public List<Book> getAllBooks() {
		return allBooks;
	}

	public BooksList() {
		allBooks = new ArrayList<Book>();
	}

	public Book findBookById(int id) {
		for (Book book : allBooks) {
			if (book.getId() == id) {
				return book;

			}
		}
		throw new IllegalArgumentException("The book with id: " + id + " not exist");
	}

	public void addBook(String title, int year, String autor) {
		allBooks.add(new Book(title, year, autor));
		return;
	}

	public void removeBook(int id) {
		Book removeBook = findBookById(id);
		allBooks.remove(removeBook);
	}

	public void showAllBooks() {
		showBooksList(allBooks);
	}

	public void showBooksList(List<Book> listBooks) {
		int iterator = 0;
		int lendbooks = 0;
		for (Book book : listBooks) {
			iterator++;
			if (book.getIsLend()) {
				lendbooks++;
			}
			System.out.println(iterator + ". " + book.toString());
		}
		System.out.println("All books: " + listBooks.size());
		System.out.println("Books lended: " + lendbooks);
		System.out.println("Books in library: " + (listBooks.size() - lendbooks));
	}

	public List<Book> findBooks(String title, Integer year, String author) {
		List<Book> foundBooks = new ArrayList<Book>();
		if (title == null && year == null && author != null) {
			for (Book book : allBooks) {
				if (book.getAuthor().equals(author)) {
					foundBooks.add(book);
				}
			}
		}
		if (title != null && year == null && author == null) {
			for (Book book : allBooks) {
				if (book.getTitle().equals(title)) {
					foundBooks.add(book);
				}
			}
		}
		if (title == null && year != null && author == null) {
			for (Book book : allBooks) {
				if (book.getYear() == year) {
					foundBooks.add(book);
				}
			}
		}

		if (author == null && title != null && year != null) {
			for (Book book : allBooks) {
				if (book.getYear() == year && book.getTitle().equals(title)) {
					foundBooks.add(book);
				}
			}
		}
		if (author != null && title == null && year != null) {
			for (Book book : allBooks) {
				if (book.getYear() == year && book.getAuthor().equals(author)) {
					foundBooks.add(book);
				}
			}
		}
		if (author != null && title != null && year == null) {
			for (Book book : allBooks) {
				if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
					foundBooks.add(book);
				}
			}
		}
		if (author != null && title != null && year != null) {
			for (Book book : allBooks) {
				if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getYear() == year) {
					foundBooks.add(book);
				}
			}
		}
		if (author == null && title == null && year == null) {
			throw new IllegalArgumentException("no argument in function");
		}
		return foundBooks;
	}

}
