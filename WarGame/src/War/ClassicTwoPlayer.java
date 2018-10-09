/**
* 
*/
package War;

import java.util.ArrayList;

/**
* This Class is used to create
* 
* @author Yadira Hernandez
*
*/
public class ClassicTwoPlayer extends WarVariationClassic {
	
	// protected Player player1;
	// protected Player player2;
	// public int numOfRounds;

	/**
	 * @param deck 
	 * @param player1 
	 * @param player2 
	 * 
	 */
	public ClassicTwoPlayer(Deck deck, Player player1, Player player2) {
		winPile = new Deck();
		players = new ArrayList<Player>();
		warLogger = new GameLogger("ClassicTwoPlayer.txt");
		this.deck = deck;
		this.player1 = player1;
		this.player2 = player2;
		players.add(player1);
		players.add(player2);
		numOfRounds = 13;
	}

	public int getNumOfRounds() {
		return this.numOfRounds;
	}

	public void setNumOfRounds(int numOfRounds) {
		this.numOfRounds = numOfRounds;
	}

	/* (non-Javadoc)
	 * @see War.GameVariation#dealCards()
	 */
	// @Override
	// protected void dealCards() {
	// 	// System.out.println(deck.getDeckSize());
	// 	while(deck.getDeckSize() !=0) {
	// 		for(Player player: players) {
	// 			player.addCardToHand(deck.removeFromDeck());
	// 		}
	// 	}		
	// }

	/**
	 * 
	 */
	
	protected void startGame() {
		// TODO Auto-generated method stub
		//deck.shuffleCards();
		dealCards();

		
		int rounds = getNumOfRounds();
		
		for(int i = rounds; i>0; i--){
			playRound();
			
		}
	}

	/* (non-Javadoc)
	 * @see War.GameVariation#calculatePoints()
	 */

	protected void calculatePoints() {
		// TODO Auto-generated method stub
		player1.setScore(player1.getWonCards().getDeckSize());
		player2.setScore(player2.getWonCards().getDeckSize());
		warLogger.logCurrentScore(players);

	}

	/* (non-Javadoc)
	 * @see War.GameVariation#addToWinPile()
	 */
	@Override
	protected void addToWinPile(Card card) {
		// TODO Auto-generated method stub
		winPile.addToDeck(card);
	}

	/* (non-Javadoc)
	 * @see War.GameVariation#goToWar()
	 */
	@Override
	protected void goToWar() {
		// TODO Auto-generated method stub
		warLogger.logWarStarted();
		if(player1.getHandSize() > 0 && player2.getHandSize() >0) {
			Card first = player1.playCardFromHand();
			Card second = player2.playCardFromHand();
			addToWinPile(first);
			addToWinPile(second);	
			playRound();
		}
	}
	
	public void playRound() {
		if(player1.getHandSize() > 0 && player2.getHandSize() >0) {
			Card first = player1.playCardFromHand();
			Card second = player2.playCardFromHand();
			warLogger.logCardPlayed(player1.getName(), first);
			warLogger.logCardPlayed(player2.getName(), second);
			addToWinPile(first);
			addToWinPile(second);
			
			determineRoundWinner(first, second);
		}//else
			//determineGameWinner();
	}

	private void determineRoundWinner(Card first, Card second) {
		// TODO Auto-generated method stub
		int result = first.compareTo(second);
		if(result == 1) {
			player1.addCardsToCardsWon(winPile);
			player1.addCardsToHand(winPile);
			winPile.removeAllCards();
			warLogger.logRoundWinner(player1.getName());
			//print current score
			
		}else if( result == -1) {
			player2.addCardsToCardsWon(winPile);
			player2.addCardsToHand(winPile);
			winPile.removeAllCards();
			warLogger.logRoundWinner(player2.getName());
		}
		else {
			
			goToWar();
		}
		//clear winpile
		
		calculatePoints();
		
	}
	// public void determineGameWinner() {
	// 	String winner = "";
	// 	//calculatePoints();
	// 	if(player1.getScore() > player2.getScore()) {
	// 		winner = player1.getName() + " is Winner!";			
	// 	}else if(player2.getScore() > player1.getScore()) {
	// 		winner = player2.getName() + " is Winner!";
	// 	}else {
	// 		winner = "Tie Game";
	// 	}
	// 	warLogger.logGameWinner(winner);
	// }
	public void collectWinPile() {
		winPile.removeAllCards();
	}

}
