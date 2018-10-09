package War;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GameLogger {
	public FileWriter gameLogWriter;

	public GameLogger(String fileName) {
		File gameOutput = new File(fileName);		
		
		try {
			gameLogWriter = new FileWriter(gameOutput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logRoundWinner(String player) {
		
		writeToGameOutput(String.format("%s Won Round", player));
		
	}

	private void writeToGameOutput(String warOutput) {
		System.out.println(warOutput);
	
		try {
			gameLogWriter.write(warOutput);
			gameLogWriter.write(System.lineSeparator());
			gameLogWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void logCardPlayed(String player, Card card) {
		writeToGameOutput(String.format("%s plays %s", player, card));
		
	}

	public void logGameWinner(String winner) {
		writeToGameOutput(winner);
		
	}
	public void logCurrentScore() {
		
	}

	public void logCurrentScore(List<Player> players) {
		String msg = "Score is ";
		String temp = "";
		
		for(Player player: players) {
			temp = String.format("%s %d",player.getName(), player.getScore());
			msg = msg + temp;
			if(players.indexOf(player) != players.size()-1) {
				msg = msg +", ";
			}
		}
	
		writeToGameOutput(msg);
		
	}
	public void logWarStarted() {
		String warMessage = "War!";
		writeToGameOutput(warMessage);
	}

}
