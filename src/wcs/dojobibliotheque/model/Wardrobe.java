package wcs.dojobibliotheque.model;

import java.util.ArrayList;

public class Wardrobe {
	public static final int HEIGHT = 200;
	public static final int WIDTH = 100;
	private int heightLeft;
	private ArrayList<Shelf> shelfs;
	
	public Wardrobe() {
		this.heightLeft = HEIGHT;
		this.shelfs = new ArrayList<>();
	}
	
	public void addShelf(Shelf shelf) {
		// on ajoute l'étagère
		this.shelfs.add(shelf);
		// On réduit la hauteur dispo dans l'armoire
		this.setHeightLeft(this.getHeightLeft() - shelf.getHeight());
	}

	public int getHeightLeft() {
		return heightLeft;
	}

	public void setHeightLeft(int heightLeft) {
		this.heightLeft = heightLeft;
	}

	public ArrayList<Shelf> getShelfs() {
		return shelfs;
	}

	public void setShelfs(ArrayList<Shelf> shelfs) {
		this.shelfs = shelfs;
	}
	@Override
	public String toString() {
		String s = "Armoire : \n";
		for(Shelf shelf : this.getShelfs()) {
			s = s + shelf.toString() + "\n";
		}
		return s;
	}
}
