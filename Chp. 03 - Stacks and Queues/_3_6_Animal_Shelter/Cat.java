// github.com/RodneyShag

package _3_6_Animal_Shelter;

public class Cat extends Animal {
    /* Constructor */
    public Cat(String name) {
        super(name);
    }

    /* Constructor */
    public Cat(String name, int barcode) {
        super(name, barcode);
    }

    /* Implements subclass's abstract class */
    @Override
    public void makeSound() {
        System.out.println("meow");
    }
}
