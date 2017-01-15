package ThreePoint7;
/* Skills Utillized:
 * 1) Inheritance using "extends"
 * 2) Typecasting (Dog) (Cat), Polymorphism (instanceof)
 * 3) LinkedList data structure.
 * 4) As a timestamp, use an integer "order" (in Shelter class) that is also (stamped as) a member variable for Animal.
 */
public class ThreePoint7 {
	public static void main(String [] args){
		Shelter shelter = new Shelter();
		shelter.enqueue(new Dog("Donovan"));
		shelter.enqueue(new Cat("Cambridge"));
		shelter.enqueue(new Dog("Dixxy"));
		shelter.enqueue(new Dog("Deelio"));
		shelter.enqueue(new Cat("Cecilia"));
		System.out.println("1st Cat = " + shelter.dequeueCat().name);
		System.out.println("1st Dog = " + shelter.dequeueDog().name);
		while(shelter.numAnimals() > 0){
			System.out.println(shelter.dequeueAny().name);
		}
	}
}
