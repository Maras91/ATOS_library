package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

	public static void main(String[] args) {
		
		Library myLibrary= new Library();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		Boolean applicationRunning=true;
		int yourChoose;
		do {
		System.out.println("Welcome to library! Choose your action:");
		System.out.println("1. Add a book");
		System.out.println("2. Remove a book");
		System.out.println("3. See all books");
		System.out.println("4. Search for a book");
		System.out.println("5. Close application");
		try {
			yourChoose = Integer.parseInt(bufferedReader.readLine());
			switch (yourChoose) {
			 case 1: 
				 break;
			 case 2: 
				 break;
			 case 3: 
				 break;
			 case 4: 
				 break;
			 case 5:
				 applicationRunning=false;
				 break;
			 }
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed read attempt");
			System.out.println("You must write only a number");
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed read attempt");
			System.out.println("You must write only a number");
			//e.printStackTrace();
		}
		
		}while(applicationRunning);
		System.out.println("End");
	}

}
