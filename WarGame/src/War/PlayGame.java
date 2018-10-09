package War;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayGame {
	//ClassicTwoPlayer game1;
	
	public static void main(String[] args) {

	
		Deck deck = new Deck();
		deck.createStandardDeck();
////		deck.addToDeck(new Card(Card.Suit.Clubs, Rank.Two));
////		deck.addToDeck(new Card(Card.Suit.Hearts, Rank.Two));
//
//	
		deck.shuffleCards();
//
		Player player1 = new Player("player1");
		Player player2 = new Player("player2");
		
		ClassicTwoPlayer game1 = new ClassicTwoPlayer(deck, player1, player2);
		game1.startGame();
		
		//game1.setNumOfRounds(5);
		
		game1.determineGameWinner();
			


		
//		player1.playCardFromHand();
//		player2.playCardFromHand();
		//determine winner
		// Deck deck2 = new Deck();
		// deck2.createStandardDeck();
		// deck2.shuffleCards();
		
//		deck2.addToDeck(new Card(Card.Suit.Clubs, Rank.Two));
//		deck2.addToDeck(new Card(Card.Suit.Hearts, Rank.Two));
//		deck2.addToDeck(new Card(Card.Suit.Spades, Rank.Two));
//		deck2.addToDeck(new Card(Card.Suit.Diamonds, Rank.Two));
//		deck2.addToDeck(new Card(Card.Suit.Diamonds, Rank.Three));
//		deck2.addToDeck(new Card (Card.Suit.Spades, Rank.Three));
//		deck2.addToDeck(new Card (Card.Suit.Spades, Rank.Four));
//		deck2.addToDeck(new Card (Card.Suit.Spades, Rank.King));
//		deck2.addToDeck(new Card (Card.Suit.Clubs, Rank.Four));
		//Player player3 = new Player("thirdwheel");
		//ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(player1, player2, player3));
//		ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(player1, player2));
//		TwoPlayerPointPile game2 = new TwoPlayerPointPile(deck2, players);

	
		// game2.startGame();
		// game2.determineGameWinner();
		
//		Deck deck3 = new Deck();
//		deck3.createStandardDeck();
//		deck3.shuffleCards();
//		Player player3 = new Player("thirdwheel");
//		ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(player1, player2, player3));
//		ThreePlayerPointPile game3 = new ThreePlayerPointPile(deck3, players);
//		game3.startGame();
//		game3.determineGameWinner();
	
		
		

	}

}
