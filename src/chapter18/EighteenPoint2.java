package chapter18;

/* A must-know algorithm. Can ignore the recursive version. BTW, I had coded it incorrectly in "million" */
public class EighteenPoint2 {
	public void shuffle(int [] cards){
		for (int i = 0; i < cards.length; i++){
			int rand = (int) (Math.random() * (i+1));	//random number between 0 and i inclusive
			swap(cards, i, rand);
		}
	}
	
	private void swap(int [] cards, int i, int j){
		int temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}
}
