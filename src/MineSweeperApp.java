import java.util.Scanner;

public class MineSweeperApp {
	public static void main(String[] args) {
		MineField game = new MineField();
		Scanner sc = new Scanner(System.in); 
		String[][] field = game.generateMineField(sc);
		boolean stillPlaying = true;
		game.fillMineField(field);
		game.numberMineField(field);
		String[][] board = game.blankBoard(field);
		//game.displayField(field, true);
		while(stillPlaying == true) {
			game.displayField(board, false);
			stillPlaying = game.checkBox(sc, field, board);
		}
		
	}

}
