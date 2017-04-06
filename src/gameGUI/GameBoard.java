package gameGUI;

import javax.swing.JButton;

import gameGUI.GameWindow;
import gameGUI.GameWindow.OnUserAction;

import gameLogic.Logic;

public class GameBoard {

	private GameWindow gameWindow;
	private static final int BOARD_WIDTH = 6;
	private static final int BOARD_HEIGHT = 6;
	private static Logic logic;
	
	public static JButton[][] board;
	
	public GameBoard(GameWindow window) {
		gameWindow = window;
		board = gameWindow.getButtons();
		logic = new Logic();
		gameWindow.setListener(new OnUserAction() {

			@Override
			public void onButtonClicked(int x, int y) {
				logic.play(x, y);
			}
		});
	}

	public static int getBoard_width() {
		return BOARD_WIDTH;
	}

	public static int getBoard_height() {
		return BOARD_HEIGHT;
	}

	
	public void runBoard() {

		gameWindow.runWindow();
	}

}
