package wcs.dojobibliotheque;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import wcs.dojobibliotheque.model.*;

public class DojoBibliotheque {

	public static void main(String[] args) {
		// Liste de livres + génération des livres.
		ArrayList<Book> books = new ArrayList<>();
		generateBooks(books);
		
		// Liste d'armoires
		ArrayList<Wardrobe> wardrobes = new ArrayList<>();
		
		// On créé forcement au moins une armoire et une étagère pour y poser mon premier livre
		Shelf shelf = new Shelf();
		Wardrobe wardrobe = new Wardrobe();
		for(Book book : books) {
			// Si le livre ne rentre pas dans l'étagère.
			if(shelf.getWidthLeft() < book.getWidth()) {
				// Si l'étagère ne rentre pas dans l'armoire
				if(wardrobe.getHeightLeft() < shelf.getHeight()) {
					// on ajoute l'armoire remplie dans la bibliothèque et on en créé une nouvelle
					wardrobes.add(wardrobe);
					wardrobe = new Wardrobe();
				}
				// On ajoute l'étagère remplie dans l'armoire et on en créé une nouvelle
				wardrobe.addShelf(shelf);
				shelf = new Shelf();
			}
			// action basique : on ajoute notre livre dans l'étagère
			shelf.addBook(book);
		}
		
		// Ici on a forcement une étagère avec au moins un livre.
		// Si l'étagère ne rentre pas dans l'armoire
		if(wardrobe.getHeightLeft() < shelf.getHeight()) {
			// on ajoute l'armoire remplie dans la bibliothèque et on en créé une nouvelle
			wardrobes.add(wardrobe);
			wardrobe = new Wardrobe();
		}
		// On ajoute la dernière étagère dans l'armoire
		wardrobe.addShelf(shelf);
		// on ajoute l'armoire dans la bibliothèque
		wardrobes.add(wardrobe);
		
		// affichage de notre bibliothèque
		for(Wardrobe element : wardrobes) {
			System.out.println(element.toString());
		}
	}
	
	public static void generateBooks(ArrayList<Book> books) {
		for (int i = 0; i < 40; i++) {
			books.add(new Book(i+1));
		}
		Collections.shuffle(books);
	}

}
