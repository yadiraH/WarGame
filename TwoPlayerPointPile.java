package War;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import War.Card.Suit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TwoPlayerPointPile extends WarVariationWithPoints {
	private static Logger logger = LogManager.getLogger(TwoPlayerPointPile.class);

	protected boolean inWar;

	public TwoPlayerPointPile(Deck deck, ArrayList<Player> players) {
		this.deck = deck;
		this.players = new ArrayList<Player>(players);
		
		warLogger = new GameLogger("TwoPlayerPoints.txt");
		winPile = new Deck();
		inWar = false;
	}

	protected void startGame() {
		dealCards();
		while(playersHaveEnoughCards() == true) {
			playRound();	
		}
	}

	protected boolean playersHaveEnoughCards() {
		int playersCardTotal;
		int enoughCards = 1;
		int playersWithEnoughCards = 0;
		if (inWar == true) {
			enoughCards = 2;
		} 		
		for(Player player : players){
			playersCardTotal = player.getHandSize();

			if(playersCardTotal >= enoughCards){
				playersWithEnoughCards++;
			}
		}
		if(playersWithEnoughCards >1)
			return true;
		
		return false;
	}
	
	public void playRound() {
		if(playersHaveEnoughCards() == true) {
			HashMap<Card,Player> cardsPlayed = new HashMap<Card,Player>();
			for(Player player: players){
				Card card = player.playCardFromHand();
				cardsPlayed.put(card, player);
				warLogger.logCardPlayed(player.getName(), card);
				
				addToWinPile(card);			
			}	

		determineRoundWinner(cardsPlayed);
		cardsPlayed.clear();
		}
	}

	public void determineRoundWinner(HashMap<Card,Player> cardsPlayed) {
		logger.info("win pile" + winPile);
		Player winner= getRoundWinner(cardsPlayed);
		
		if(winner != null) {
			collectWinPile(winner);
			warLogger.logRoundWinner(winner.getName());
		}

		calculatePoints();
		warLogger.logCurrentScore(players);
		
	}
	private Player getRoundWinner(HashMap<Card,Player> cardsPlayed) {
		Player winner;
		Card maxCard = winPile.getCard(0);
		Card currCard;

		Iterator<HashMap.Entry<Card,Player>> it = cardsPlayed.entrySet().iterator();
		HashMap.Entry<Card,Player> pair = it.next();
		maxCard = pair.getKey();
		winner = pair.getValue();
		while (it.hasNext()) {
			pair = it.next();
			it.remove();
			currCard = pair.getKey();
		    logger.info(String.format("Comparing %s with %s", maxCard, currCard));
			if (currCard.compareTo(maxCard) == 1) {
				maxCard = currCard;
				winner = pair.getValue();
			} else if (maxCard.compareTo(currCard) == 0) {
				inWar = true;
				goToWar();	
			}
		}
		return winner;
	}

	private void collectWinPile(Player winner) {
		for(Player player: players) {
			if(player.getName() == winner.getName()) {
				player = winner;
				player.addCardsToCardsWon(winPile);
			}
		}
		winPile.removeAllCards();
	}

	protected void calculatePoints() {
		for(Player player : players){
			player.setScore(player.getWonCards().getDeckSize());
		}
	}
}
