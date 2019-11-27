// github.com/RodneyShag

package _3_6_Animal_Shelter;

import java.util.ArrayDeque;

public class AnimalShelter {
    int barcode = 0;
    ArrayDeque<Cat> cats = new ArrayDeque();
    ArrayDeque<Dog> dogs = new ArrayDeque();

    public void enqueue(Animal animal) {
        animal.barcode = barcode++;
        if (animal instanceof Cat) {
            cats.add((Cat) animal);
        } else if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return cats.remove();
        }
        if (cats.isEmpty()) {
            return dogs.remove();
        }
        if (dogs.peek().isOlderThan(cats.peek())) {
            return dogs.remove();
        } else {
            return cats.remove();
        }
    }

    public Cat dequeueCat() {
        return cats.remove();
    }

    public Dog dequeueDog() {
        return dogs.remove();
    }

    public int numAnimals() {
        return dogs.size() + cats.size();
    }

    /* Prints all animals in shelter */
    public void printShelter() {
        System.out.print("\nShelter: ");
        for (Cat cat : cats) {
            System.out.print(cat + " ");
        }
        for (Dog dog : dogs) {
            System.out.print(dog + " ");
        }
        System.out.println();
    }
}
