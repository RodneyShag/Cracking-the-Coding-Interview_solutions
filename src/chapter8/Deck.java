package chapter8;
import java.util.ArrayList;

/* Important: With Generics, don't use arrays. Use ArrayList, since we can't create arrays of generics. */
public class Deck <T extends Card> {
	private ArrayList<T> deck;	//can't use a fixed size array, like [], since we are using generics.
	public Deck(){
		deck = new ArrayList<T>();
		initializeCards();
	}
	
	public void addCard(T card){
		deck.add(card);
	}
	
	public T dealCard(){
		return deck.remove(0);
	}
	
	public ArrayList<T> dealHand(int numCards){
		ArrayList<T> cards = new ArrayList<T>();
		//add cards to this ArrayList.
		return cards;
	}
	
	public void shuffle(){
		; //shuffle !
	}
	
	public int cardsLeft(){
		return deck.size(); //unimplemented
	}
	
	private void initializeCards(){
		; //would create 52 instances of cards here.
	}
}
