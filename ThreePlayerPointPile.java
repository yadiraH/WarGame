/**
* 
*/
package War;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* This Class is used to create
* 
* @author Yadira Hernandez
*
*/
public class ThreePlayerPointPile extends WarVariationWithPoints {
	private static Logger logger = LogManager.getLogger(ThreePlayerPointPile.class);

	protected boolean inWar;

	public ThreePlayerPointPile(Deck deck, ArrayList<Player> players) {
		this.deck = deck;
		this.players = new ArrayList<Player>(players);
		
		warLogger = new GameLogger("ThreePlayerPoints.txt");
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
		Card highestCard = winPile.getCard(0);
		Card secondCard;
		Card thirdCard;

		Iterator<HashMap.Entry<Card,Player>> it = cardsPlayed.entrySet().iterator();
		HashMap.Entry<Card,Player> pair = it.next();
		highestCard = pair.getKey();
		winner = pair.getValue();
		while (it.hasNext()) {
			pair = it.next();
			it.remove();
			secondCard = pair.getKey();
			pair = it.next();
			thirdCard = pair.getKey();
			logger.info("Third card"+ thirdCard);
		    logger.info(String.format("Comparing %s with %s", highestCard, secondCard));
			if (secondCard.compareTo(highestCard) == 1 && secondCard.compareTo(thirdCard) == 1) {
				highestCard = secondCard;
				winner = pair.getValue();
			}else if(thirdCard.compareTo(highestCard)==1 && thirdCard.compareTo(secondCard) == 1){
				highestCard = thirdCard;
				winner = pair.getValue();
			} 
			else if (highestCard.compareTo(secondCard) == 0 ||highestCard.compareTo(thirdCard) == 0) {
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
