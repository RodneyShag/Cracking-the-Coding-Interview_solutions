package chapter08.EightPoint1;

public class BlackjackCard extends Card{
	public BlackjackCard(Rank rank, Suit suit, Color color){
		super(rank, suit, color);
	}
	
	public boolean isFaceCard(){
		return rank == Rank.TEN || rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING;
	}
}
