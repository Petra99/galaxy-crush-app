package gameLogic;

import gameGUI.GameBoard;

public class Logic {

	private int currx;
	private int curry;

	public Logic() {
		currx = -1;
		curry = -1;
	}

	public void play(int x, int y) {
		if (currx == -1 && curry == -1) {
			currx = x;
			curry = y;
		} else {
			if (isMoveLegal(currx, curry, x, y)) {
				System.out.println(x + " " + y);
				swapElements(currx, curry, x, y);
			}
			checkInRow(x, y);
			// pri vseki hod
			currx = -1;
			curry = -1;
		}
	}

	private void checkInRow(int x, int y) {

	}

	private void swapElements(int currx, int curry, int x, int y) {
		GameBoard.board[x][y] = GameBoard.board[currx][curry];
		GameBoard.board[currx][curry] = GameBoard.board[x][y];
	}

	private static boolean isMoveLegal(int currx, int curry, int x, int y) {
		if ((Math.abs(currx - x) == 1 && curry == y) || (Math.abs(curry - y) == 1 && currx == x)) {
			return true;
		}
		return false;

	}
}
