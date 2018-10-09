package War;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Deck implements Iterable<Card>{
	private static final int TOP_CARD = 0;
	
	public List<Card> deck;
	public final int NUMERIC_CARDS_IN_SUIT = 10;
	public final int LOWEST_NUMERIC_VALUE = 2;
	private Card card;
	
	public Deck() {
		deck = new ArrayList<Card>();
	}
	
	public void shuffleCards() {
	Collections.shuffle(deck);
	}
//	public void createStandardDeck() {
//		for (Card.Suit suit : Card.Suit.values()) {
//			addNumericCards(suit);
//			addFaceCards(suit);
//		}	  
//			}
//	private void addNumericCards(Card.Suit suit) {
//		
//		for(int i = LOWEST_NUMERIC_VALUE ; i <= NUMERIC_CARDS_IN_SUIT; i++) {
//		  card = new Card();
//		  card.setValue(i);
//		  card.setSuit(suit);
//		  this.deck.add(card);
//		}
//	}
//	private void addFaceCards(Card.Suit suit) {
//		for (Rank face : Rank.values()) {
//			card = new Card();
//			card.setValue(face.getValue());
//			//card.setRank(face);
//			card.setSuit(suit);
//			//card.setFace(face);
//			this.deck.add(card);
//		}
//		
//	}
	public void createStandardDeck() {
		for (Card.Suit suit : Card.Suit.values()) {
			for (Rank rank : Rank.values()) {
				  card = new Card();
				  card.setSuit(suit);
				  card.setRank(rank);
				  this.deck.add(card);
			}	
		}
		
	}	
	public void showDeck() {
		System.out.println("These are the cards in the deck: ");
		for(Card card: deck) {
			System.out.println(card);
		}
		System.out.println("Total: "
				+ deck.size());
	}
	public void showDeck(Deck deck) {
		System.out.println("These are the cards in the deck: ");
		for(Card card: deck) {
			System.out.println(card);
		}
		System.out.println("Total: "
				+ deck.getDeckSize());
	}
	public Card removeFromDeck() {
		return this.deck.remove(TOP_CARD);
	}
	
	public void addToDeck(Card card) {
		this.deck.add(card);
	}
	public void addToDeck(Deck cards) {
		this.deck.addAll(cards.getCards());
		
	}
	protected List<Card> getCards() {
		// TODO Auto-generated method stub
		return deck;
	}

	public Card getCard(int index) {
		return this.deck.get(index);
	}

	public int getDeckSize() {
		return this.deck.size();
	}
	public void removeAllCards() {
		this.deck.clear();
	}
	

	@Override
    public Iterator<Card> iterator() {
        return new DeckIterator(this);
    }

	@Override
	public String toString() {
		return "Deck [deck=" + deck + ", card=" + card + "]";
	}	
	
	

}
