package __Intro_StringBuffer;

public class Tester {
	public static void main(String[] args) {
		test(new String[]{"Hi ", "there ", "Rob. ", "How ", "are ", "you?"});
	}
	
	private static void test(String[] strings) {
		System.out.println(IntroStringBuffer.joinWords(strings));
	}
}
