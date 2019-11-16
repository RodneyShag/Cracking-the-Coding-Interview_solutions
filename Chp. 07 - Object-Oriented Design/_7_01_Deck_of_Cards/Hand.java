// github.com/RodneyShag

package _7_01_Deck_of_Cards;

import java.util.ArrayList;

public class Hand<T extends Card> {
    ArrayList<T> hand;

    public Hand() {
        hand = new ArrayList<T>();
    }
    // and more methods here.
}
