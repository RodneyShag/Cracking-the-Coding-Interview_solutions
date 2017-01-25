package chapter10;

import java.io.FileNotFoundException;

public class Chapter10 {
	public static void main (String [] args){
		// 10.1: no code written
		// 10.2: no code written
		test_TenPoint3();
		test_TenPoint4();
		// 10.5: No code written
		// 10.6: No code written
		// 10.7: No code written
	}
	
	public static void test_TenPoint3(){
		System.out.println("*** Test 9.3 - Find Missing Number");
		try{
			TenPoint3.findOpenNumber();
			TenPoint3.findOpenNumber2();
		}
		catch(FileNotFoundException e){
			System.out.println("File Not Found Exception");
		}
	}
	
	public static void test_TenPoint4(){
		System.out.println("\n*** Test 9.4 - Print Duplicates");
		TenPoint4.checkDuplicates(new int[]{3,4,4,4,1,6,1});
	}
}
