package gameGUI;

public class VisualizeGame {

	public static void main(String[] args) {
		GameWindow window = new GameWindow(6, 6);
		GameBoard board = new GameBoard(window);

		board.run();

	}

}
