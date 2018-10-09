package War;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DeckIterator implements Iterator<Card> {
	public Deck deck;
	public int current =0;
	
	public DeckIterator(Deck deck) {
		this.deck = deck;
//		current = 0;
	}

	@Override
	public boolean hasNext() {
        if (current < deck.getDeckSize()) {
            return true;
        } else 
            return false;
       	
	}

	@Override
	public Card next() {
		if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return deck.getCard(current++);
	}

}
