package _7_01_Deck_of_Cards;

public class Card {
    Suit suit;
    Rank rank;
    Color color;

    public Card(Rank rank, Suit suit, Color color) {
        this.suit = suit;
        this.rank = rank;
        this.color = color;
    }
}
