package War;

public class Card implements Comparable<Card>{

	public enum Suit{
	       Hearts, Diamonds, Clubs, Spades;
	   }
	
	public int value;
	private Suit suit;
	private Rank rank;
	
	public Card() {}
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public boolean isFaceCard() {
		return false;
	}
	public int getValue() {
		return rank.getValue();
	}
	
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	@Override
	public String toString() {
		return "[" + rank + " of "+ suit +"]" ;
	}

	@Override
	public int compareTo(Card otherCard) {
		int firstCardValue = this.getValue();
		int secondCardValue = otherCard.getValue();
		if( firstCardValue < secondCardValue) {
			return -1;
		}
		else if( firstCardValue > secondCardValue) {
			return 1;
		}
		else
			return 0;
	}

}
