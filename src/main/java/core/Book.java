package core;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private static  int highestId = 1;
	private String title;
	private int id;
	private int year;
	private String author;
	private Boolean islent;
	Book(String title, int year, String autor)
	{
		this.title=title;
		this.year=year;
		this.author=autor;
		islent=false;
		createUniqueId();
	}
	private void createUniqueId() {
		id = highestId;
		highestId++;
		return;
	}
}
