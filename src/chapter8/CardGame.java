package chapter8;
/* Used for a class that only has one instance */
/* I kinda changed my mind. I don't like singleton classes */
public class CardGame{
	private static CardGame _instance = null;
	public static CardGame getInstance(){
		if (_instance == null)
			_instance = new CardGame();
		return _instance;
	}
}