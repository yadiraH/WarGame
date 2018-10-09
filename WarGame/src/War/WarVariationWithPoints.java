package War;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WarVariationWithPoints extends WarGameVariation {
	private static Logger logger = LogManager.getLogger(WarVariationWithPoints.class);

	protected boolean inWar;

	public WarVariationWithPoints() {
	}
	@Override
	protected void dealCards() {
		int deckSize = deck.getDeckSize();
		for(int i = 0; i< deckSize/players.size(); i++) {
			for(Player player: players) {
				player.addCardToHand(deck.removeFromDeck());
			}
		}
		if(deck.getDeckSize() > 0) {
			winPile.addToDeck(deck);
		}		
	}

	@Override
	protected void addToWinPile(Card card) {
		winPile.addToDeck(card);

	}

	@Override
	protected void goToWar() {
		warLogger.logWarStarted();
			for(Player player : players){
				Card card = player.playCardFromHand();
				winPile.addToDeck(card);
			}
			inWar = false;
	}
	
	public void determineGameWinner() {
		String winner = "";
		int firstScore = 0;
		int secondScore = 0;
		for(Player player : players){
			ArrayList<Player> subPlayerList = 
					new ArrayList(players.subList(players.indexOf(player)+1, players.size()));
			firstScore = player.getScore();
			for(Player subPlayer : subPlayerList) {
				secondScore = subPlayer.getScore();
				if(firstScore< secondScore) {
					winner = subPlayer.getName() +" Wins Game!";
				}else if(firstScore > secondScore){
					winner = player.getName() +" Wins Game!";
				}else {
					winner = "Tie Game";
				}
			}	
		}
		warLogger.logGameWinner(winner);
	}

}
