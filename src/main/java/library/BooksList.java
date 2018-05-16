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

	public void foundBooks(String keyword, int year, String keyword2) {
		List<Book> foundBooks = new ArrayList<Book>();
		for (Book book : allBooks) {
			if (book.getYear() == year) {
				if (book.getTitle().equals(keyword) && book.getAuthor().equals(keyword2)
						|| book.getAuthor().equals(keyword) && book.getTitle().equals(keyword2)) {
					foundBooks.add(book);
				}
			}
		}
		System.out.println("Books found:");
		showBooksList(foundBooks);
	}

	public void foundBooks(String keyword, int year) {
		List<Book> foundBooks = new ArrayList<Book>();
		for (Book book : allBooks) {
			if ((book.getTitle().equals(keyword) || book.getAuthor().equals(keyword)) && book.getYear() == year) {
				foundBooks.add(book);
			}
		}
		System.out.println("Books found:");
		showBooksList(foundBooks);
	}

	public void foundBooks(String keyword, String keyword2) {
		List<Book> foundBooks = new ArrayList<Book>();
		for (Book book : allBooks) {
			if (book.getTitle().equals(keyword) && book.getAuthor().equals(keyword2)
					|| book.getAuthor().equals(keyword) && book.getTitle().equals(keyword2)) {
				foundBooks.add(book);
			}
		}
		System.out.println("Books found:");
		showBooksList(foundBooks);
	}

	public void foundBooks(String keyword) {
		List<Book> foundBooks = new ArrayList<Book>();
		for (Book book : allBooks) {
			if (book.getTitle().equals(keyword) || book.getAuthor().equals(keyword)) {
				foundBooks.add(book);
			}
		}
		System.out.println("Books found:");
		showBooksList(foundBooks);
	}

	public void foundBooks(int year) {
		List<Book> foundBooks = new ArrayList<Book>();
		for (Book book : allBooks) {
			if (book.getYear() == year) {
				foundBooks.add(book);
			}
		}
		System.out.println("Books found:");
		showBooksList(foundBooks);
	}

}
