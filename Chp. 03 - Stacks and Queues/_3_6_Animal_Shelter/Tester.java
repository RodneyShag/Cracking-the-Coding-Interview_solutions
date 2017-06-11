package _3_6_Animal_Shelter;

// Skills Used:
// 1) Inheritance: using "extends". Abstract class "Animal" with abstract method.
// 2) Polymorphism: Typecasting (Dog) (Cat), instanceof

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 3.6: Animal Shelter ");
		/* Create shelter */
		AnimalShelter animalShelter = new AnimalShelter();
		animalShelter.enqueue(new Cat("Suzy"));
		animalShelter.enqueue(new Dog("Mikey"));
		animalShelter.enqueue(new Cat("Lizzie"));
		animalShelter.enqueue(new Dog("Kevin"));

		animalShelter.printShelter();

		/* Remove 2 oldest animals. Print Shelter */
		System.out.print("\n-- removed 2 oldest animals. Now shelter contains: ");
		animalShelter.dequeueAny();
		animalShelter.dequeueAny();

		animalShelter.printShelter();

		/* Remove cat. Remove dog */
		System.out.println("\nDequeued cat is: " + animalShelter.dequeueCat());
		System.out.println("Dequeued dog is: " + animalShelter.dequeueDog());
	}
}
