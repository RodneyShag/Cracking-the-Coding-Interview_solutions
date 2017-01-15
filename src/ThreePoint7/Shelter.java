package ThreePoint7;
import java.util.LinkedList;

public class Shelter {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int order = 0;
	
	public void enqueue(Animal animal){
		animal.order = ++order;
		if (animal instanceof Dog)
			dogs.add((Dog) animal);
		else
			cats.add((Cat) animal);
	}
	
	public Animal dequeueAny(){
		if (dogs.isEmpty())
			return cats.remove();
		if (cats.isEmpty())
			return dogs.remove();
		if (dogs.peek().isOlderThan(cats.peek()))
			return dogs.remove();
		else
			return cats.remove();
	}
	
	public Dog dequeueDog(){
		return dogs.remove();
	}
	
	public Cat dequeueCat(){
		return cats.remove();
	}
	
	public int numAnimals(){
		return dogs.size() + cats.size();
	}
}
