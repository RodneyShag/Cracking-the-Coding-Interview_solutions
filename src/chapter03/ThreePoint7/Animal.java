package chapter03.ThreePoint7;

public abstract class Animal {
	String name;
	int barcode = 0;
	
	/* Constructor */
	public Animal(String name) {
		this.name = name;
	}
	
	/* Constructor */
	public Animal(String name, int barcode) {
		this.name = name;
		this.barcode = barcode;
	}
	
	public abstract void makeSound(); // abstract class. Must be implemented by subclass
	
	/* This is here to make our code more readable */
	public boolean isOlderThan(Animal other) {
		return barcode < other.barcode;
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.barcode;
	}
}
