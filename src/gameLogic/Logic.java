package gameLogic;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import gameGUI.GameBoard;
import gameGUI.GameWindow;

public class Logic {

	// public ArrayList<JButton> horizontalList = new ArrayList<JButton>();
	// public ArrayList<JButton> verticalList = new ArrayList<JButton>();

	private int currX;
	private int currY;
	private int score;

	public Logic() {
		currX = -1;
		currY = -1;
	}

	public void play(int x, int y) {
		if (currX == -1 && currY == -1) {
			currX = x;
			currY = y;
		} else {
			if (isMoveLegal(currX, currY, x, y)) {
				swapElements(currX, currY, x, y);
				if (modifyBoard(x, y)) {
					refill();
				}
			}
			currX = -1;
			currY = -1;
		}

	}

	private boolean modifyBoard(int x, int y) {
		for (int row = GameBoard.getBoard_height(); row >= 0; row--) {
			for (int col = GameBoard.getBoard_width(); col >= 0; col--) {
				if (checkIfMatch(x, y)) {
					return true;
				}
			}
		}
		// ??
		return false;

	}

	private boolean checkIfMatch(int x, int y) {
		if (checkIfRightMatch(x, y) || checkIfLeftMatch(x, y) ||
		// System.out.println(horizontalList.size());
		// if (horizontalList.size() >= 3) {
		// removeButtons(horizontalList);
		// }
				checkIfUpMatch(x, y) || checkIfDownMatch(x, y)) {
			return true;
		}
		return false;
		// if (verticalList.size() >= 3) {
		// removeButtons(verticalList);
		// }

	}

	/*
	 * private void removeButtons(ArrayList list) { for (int i = 0; i <
	 * horizontalList.size(); i++) { for (int row = GameBoard.getBoard_height();
	 * row < 0; row++) { for (int col = GameBoard.getBoard_width(); col < 0;
	 * col++) { if
	 * (horizontalList.get(i).getIcon().equals(GameBoard.board[row][col].getIcon
	 * ())) { GameBoard.board[row][col] = null; break; } } } }
	 * 
	 * }
	 */

	private boolean checkIfDownMatch(int x, int y) {
		System.out.println("Heelloo1");
		int counter = 0;
		// can't run the while loop
		while (x < 5 && GameBoard.board[x][y].getIcon().equals(GameBoard.board[x + 1][y].getIcon())) {
			counter++;
			x++;
			System.out.println("hello");
		}
		if (checkCounter(counter)) {
			getScore();
			for (int row = x; row < x + counter; row++) {
				// ??
				GameBoard.board[row][y].setIcon(GameWindow.getTempButton().getIcon());
			}
			return true;
		} else {
			return false;
		}

	}

	private boolean checkIfUpMatch(int x, int y) {
		int counter = 0;
		System.out.println("Heelloo2");
		while (x > 0 && GameBoard.board[x][y].getIcon().equals(GameBoard.board[x - 1][y].getIcon())) {
			// verticalList.add(GameBoard.board[row][col]);
			x--;
		}
		if (checkCounter(counter)) {
			getScore(counter);
			for (int row = x - counter; row < x; row++) {
				GameBoard.board[row][y].setIcon(GameWindow.getTempButton().getIcon());
			}
			return true;
		}
		return false;
	}

	private boolean checkIfLeftMatch(int x, int y) {
		int counter = 0;
		while (y > 0 && GameBoard.board[x][y].getIcon().equals(GameBoard.board[x][y - 1].getIcon())) {
			// horizontalList.add(GameBoard.board[row][col]);
			y--;
		}
		if (checkCounter(counter)) {
			getScore(counter);
			for (int col = y - counter; col < y; col++) {
				GameBoard.board[x][col].setIcon(GameWindow.getTempButton().getIcon());
			}
			return true;
		}
		return false;
	}

	private boolean checkIfRightMatch(int x, int y) {
		int counter = 0;
		while (y < 5 && GameBoard.board[x][y].getIcon().equals(GameBoard.board[x][y + 1].getIcon())) {
			// horizontalList.add(GameBoard.board[row][col]);
			y++;
		}
		if (checkCounter(counter)) {
			getScore(counter);
			for (int col = y - counter; col < y; col++) {
				GameBoard.board[x][col].setIcon(GameWindow.getTempButton().getIcon());
			}
			return true;
		}
		return false;
	}

	private void refill() {
		for (int x = GameBoard.getBoard_height(); x >= 0; x--) {
			for (int y = GameBoard.getBoard_width(); y >= 0; y--) {
				if (GameBoard.board[x][y].getIcon() == GameWindow.getTempButton().getIcon()) {
					do {
						GameBoard.board[x][y] = GameBoard.board[x - 1][y];
						// ?
						GameBoard.board[x - 1][y] = (JButton) GameWindow.getTempButton().getIcon();
						x--;
					} while (x != 0);
					// GameWindow.createButton(GameFigures.getRandomImage(), 0,
					// j);
				}
			}
		}
	}

	private boolean checkCounter(int counter) {
		if (counter >= 3) {
			return true;
		} else {
			return false;
		}

	}

	private void getScore(int counter) {
		switch (counter) {
		case 3: // getScore()+=(counter*100)
			break;
		case 4: // problems
			break;
		case 5: // problems
			break;

		default:
			break;
		}

	}

	public int getScore() {
		return score;
	}
	
	private void swapElements(int currx, int curry, int x, int y) {
		ImageIcon icon = (ImageIcon) GameBoard.board[currx][curry].getIcon();
		GameBoard.board[currx][curry].setIcon(GameBoard.board[x][y].getIcon());
		GameBoard.board[x][y].setIcon(icon);
	}

	private static boolean isMoveLegal(int currx, int curry, int x, int y) {
		if (Math.abs(currx - x) == 1) {
			if (curry == y) {
				return true;
			}
		} else if (Math.abs(curry - y) == 1) {
			if (currx == x) {
				return true;
			}
		}
		return false;

	}
}
