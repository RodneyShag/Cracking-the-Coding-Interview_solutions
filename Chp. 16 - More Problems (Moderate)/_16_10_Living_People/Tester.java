package _16_10_Living_People;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 16.10: Living People\n");
		Person[] people = new Person[4];
		people[0] = new Person(1943, 1988);
		people[1] = new Person(1923, 1999);
		people[2] = new Person(1903, 1958);
		people[3] = new Person(1920, 1979);
		test(people, 1900, 2017);
	}
	
	private static void test(Person[] people, int startDate, int endDate) {
		int max = LivingPeople.maxAlive(people, startDate, endDate);
		System.out.println("Max alive year: " + max);
	}
}
