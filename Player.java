package War;

import java.util.ArrayList;

/**
 * 
 * @author Yadira Hernandez
 *
 */

public class Player {
	
	private Deck hand;
	private Deck cardsWon;
	private int score;
	private String name;
	
	public Player(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		hand = new Deck();
		cardsWon = new Deck();
	}
	public Deck getHand() {
		return hand;
	}
	public void setHand(Deck hand) {
		this.hand = hand;
	}
	public Deck getWonCards() {
		return cardsWon;
	}
	public void addCardsToCardsWon(Deck cardsWon) {
		this.cardsWon.addToDeck(cardsWon);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addCardToHand(Card card) {
		hand.addToDeck(card);
	}
	public void addCardsToHand(Deck winPile) {
		hand.addToDeck(winPile);
	}
	public Card playCardFromHand() {
		return hand.removeFromDeck();
	}
	public int getHandSize() {
		return hand.getDeckSize();
	}
	@Override
	public String toString() {
		return "Player [hand=" + hand + ", wonCards=" + cardsWon + ", score=" + score + ", name=" + name + "]";
	}
	
	
	
}
