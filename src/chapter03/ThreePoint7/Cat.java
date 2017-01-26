package chapter03.ThreePoint7;

public class Cat extends Animal {
	/* Constructor */
	public Cat(String name){
		super(name);
	}
	
	/* Constructor */
	public Cat(String name, int barcode){
		super(name, barcode);
	}
	
	/* Implements subclass's abstract class */
	public void makeSound(){
		System.out.println("meow");
	}
}
