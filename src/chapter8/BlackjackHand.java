package chapter8;

public class BlackjackHand extends Hand <BlackjackCard>{	//the syntax in this line is important, but weird.
	public boolean isBusted(){
		return true; //unimplemented
	}
	public boolean isBlackjack(){
		return true; //unimplemented
	}
	//see book for more methods.
}
