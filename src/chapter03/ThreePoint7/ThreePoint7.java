package chapter03.ThreePoint7;

/* Skills Utilized:
 * 1) Inheritance: using "extends". Abstract class "Animal" with abstract method.
 * 2) Polymorphism: Typecasting (Dog) (Cat), instanceof
 */
public class ThreePoint7 {
	public static void main(String [] args) {
		/* Create shelter */
		Shelter shelter = new Shelter();
		shelter.enqueue(new Cat("Suzy"));
		shelter.enqueue(new Dog("Mikey"));
		shelter.enqueue(new Cat("Lizzie"));
		shelter.enqueue(new Dog("Kevin"));
		
		shelter.printShelter();
		
		/* Remove 2 oldest animals */
		shelter.dequeueAny();
		shelter.dequeueAny();
		
		shelter.printShelter();
		
		/* Remove cat */
		System.out.println("\nDequeue cat: " + shelter.dequeueCat());
		System.out.println("Dequeue dog: " + shelter.dequeueDog());
	}
}
