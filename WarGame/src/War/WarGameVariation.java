package War;

import java.util.ArrayList;
import java.util.List;

public abstract class WarGameVariation {
	public GameLogger warLogger;
	protected List<Player> players;
	protected int numOfPlayers;
	protected Deck deck;
	protected Deck winPile;


//	protected abstract void startGame(Deck deck, ArrayList<Player> players);
	//protected abstract void startGame();
	protected abstract void dealCards();
	//protected abstract void calculatePoints();
	protected abstract void addToWinPile(Card card);
	protected abstract void determineGameWinner();
	protected abstract void goToWar();

}
