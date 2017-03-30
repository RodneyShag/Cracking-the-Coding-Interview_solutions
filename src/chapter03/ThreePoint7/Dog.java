package chapter03.ThreePoint7;

public class Dog extends Animal{
	/* Constructor */
	public Dog(String name) {
		super(name);
	}
	
	/* Constructor */
	public Dog(String name, int barcode) {
		super(name, barcode);
	}
	
	/* Implements subclass's abstract class */
	@Override
	public void makeSound() {
		System.out.println("woof");
	}
}
