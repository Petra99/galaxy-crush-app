package gameGUI;

import gameGUI.GameFigures;
import gameGUI.GameWindow;
import gameGUI.GameWindow.OnUserAction;

public class GameBoard {

	private int board_width = 6;
	private int board_height = 6;
	private GameWindow gameWindow;

	public GameFigures[][] board = new GameFigures[board_width][board_height];

	public int getBoard_width() {
		return board_width;
	}

	public int getBoard_height() {
		return board_height;
	}

	public GameBoard(GameWindow window) {
		gameWindow = window;
		gameWindow.setListener(new OnUserAction() {

			@Override
			public void onButtonClicked(int x, int y) {
				gameWindow.changeButton(x, y);

				// logic
				// metodi v gameboard

			}
		});
	}

	public void generate() {

		for (int i = 0; i < board_height; i++) {
			for (int j = 0; j < board_width; j++) {
				board[i][j] = new GameFigures();
				// gameWindow.createButtons(GameFigures.getRandomImage());
			}

		}
	}

	public void run() {

		gameWindow.runWindow();
		generate();
	}
}
