package wcs.dojobibliotheque.model;

public class Book {
	// value in centimeter
	private int height;
	private int width;
	
	public Book(int width) {
		this.width = width;
		// hauteur par defaut d'un livre
		this.height = 30;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
