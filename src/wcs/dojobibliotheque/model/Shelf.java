package wcs.dojobibliotheque.model;

import java.util.ArrayList;

public class Shelf {
	
	private int widthLeft;
	private int height;
	private ArrayList<Book> books;
	
	public Shelf() {
		this.books = new ArrayList<>();
		this.widthLeft = Wardrobe.WIDTH;
		this.height = 0;
	}
	
	public void addBook(Book book) {
		this.books.add(book);
		this.setWidthLeft(this.widthLeft - book.getWidth());
		// si la hauteur de l'étagère est inférieur à la taille du livre
		// on met à jour la hauteur de l'étagère avec la hauteur du livre
		if(book.getHeight() > this.height)
			this.setHeight(book.getHeight());
	}

	public int getWidthLeft() {
		return widthLeft;
	}

	private void setWidthLeft(int widthLeft) {
		this.widthLeft = widthLeft;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		String s = "Etagère : ";
		for(Book book : this.getBooks()) {
			s = s+ Integer.toString(book.getWidth())+ " ";
		}
		
		return s;
	}

	private ArrayList<Book> getBooks() {
		return this.books;
	}
}
