package War;

public class WarVariationClassic extends WarGameVariation {
	protected Player player1;
	protected Player player2;
	public int numOfRounds;

	public WarVariationClassic() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void dealCards() {
		int deckSize = deck.getDeckSize();
		for(int i = 0; i< deckSize/2; i++) {
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
	protected void determineGameWinner() {
			String winner = "";
		//calculatePoints();
		if(player1.getScore() > player2.getScore()) {
			winner = player1.getName() + " is Winner!";			
		}else if(player2.getScore() > player1.getScore()) {
			winner = player2.getName() + " is Winner!";
		}else {
			winner = "Tie Game";
		}
		warLogger.logGameWinner(winner);

	}

	@Override
	protected void goToWar() {
		warLogger.logWarStarted();
		if(player1.getHandSize() > 0 && player2.getHandSize() >0) {
			Card first = player1.playCardFromHand();
			Card second = player2.playCardFromHand();
			addToWinPile(first);
			addToWinPile(second);	
		}
	}

}
