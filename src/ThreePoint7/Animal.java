package ThreePoint7;

public abstract class Animal {
	int order;
	String name;
	
	public Animal(String name){
		this.name = name;
	}
	
	/* This is here to make our code more readible */
	public boolean isOlderThan(Animal other){
		return order < other.order;
	}
}
