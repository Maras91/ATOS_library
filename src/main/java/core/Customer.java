package core;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private static  int highestId = 1;
	private int id;
	private String name;
	private String surname;
	private List<Book> borrowBooks;
	
	Customer(String name,String surname){
		this.name=name;
		this.surname=surname;
		borrowBooks= new ArrayList<Book>();
		createUniqueId();
	}
	public void addBook(Book book) {
		borrowBooks.add(book);
		return;
	}
	public int getId() {
		return id;
	}
	private void createUniqueId() {
		id = highestId;
		highestId++;
		return;
	}
	public String toString() {
		return name+" "+surname;
		
	}
}
