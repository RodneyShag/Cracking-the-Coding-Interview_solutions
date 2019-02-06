package _7_01_Deck_of_Cards;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class Deck<T extends Card> {

    private ArrayDeque<T> deck; // can't use a fixed size array[] since we are using generics.

    public Deck() {
        deck = new ArrayDeque<T>();
        initializeCards();
    }

    public void addCard(T card) {
        deck.add(card);
    }

    public T dealCard() {
        return deck.remove();
    }

    public LinkedList<T> dealHand(int numCards) {
        LinkedList<T> cards = new LinkedList<>();
        for (int i = 0; i < numCards; i++) {
            cards.add(deck.remove());
        }
        return cards;
    }

    public void shuffle() {
        // unimplemented
    }

    public int cardsLeft() {
        return deck.size();
    }

    private void initializeCards() {
        // Unimplemented. Would create 52 instances of cards here and add them to "deck"
    }
}
