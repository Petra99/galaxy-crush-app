package gameLogic;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import gameGUI.GameBoard;
import gameGUI.GameFigures;
import gameGUI.GameWindow;

public class Logic {

	public ArrayList<JButton> horizontalList = new ArrayList<JButton>();
	public ArrayList<JButton> verticalList = new ArrayList<JButton>();

	private int currX;
	private int currY;
	private int score;

	public int getScore() {
		return score;
	}

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

				for (int row = GameBoard.getBoard_height(); row < 0; row++) {
					for (int col = GameBoard.getBoard_width(); col < 0; col++) {

						checkIfMatch(x, y);
					}
				}
			}
			refill();
			// pri vseki hod
			currX = -1;
			currY = -1;
		}

	}

	private void checkIfMatch(int row, int col) {
		checkIfRightMatch(row, col);
		checkIfLeftMatch(row, col);
		System.out.println(horizontalList.size());
		if (horizontalList.size() >= 3) {
			removeButtons(horizontalList);
		}
		checkIfUpMatch(row, col);
		checkIfDownMatch(row, col);
		if (verticalList.size() >= 3) {
			removeButtons(verticalList);
		}

	}

	private void removeButtons(ArrayList list) {
		for (int i = 0; i < horizontalList.size(); i++) {
			for (int row = GameBoard.getBoard_height(); row < 0; row++) {
				for (int col = GameBoard.getBoard_width(); col < 0; col++) {
					if (horizontalList.get(i).getIcon().equals(GameBoard.board[row][col].getIcon())) {
						GameBoard.board[row][col] = null;
						break;
					}
				}
			}
		}

	}

	private void checkIfDownMatch(int row, int col) {
		System.out.println("Heelloo1");
		while (row < 5 && GameBoard.board[row][col].getIcon().equals(GameBoard.board[row + 1][col].getIcon())) {
			verticalList.add(GameBoard.board[row][col]);
			row++;
			System.out.println("hello");
		}

	}

	private void checkIfUpMatch(int row, int col) {
		System.out.println("Heelloo2");
		while (row > 0 && GameBoard.board[row][col].getIcon().equals(GameBoard.board[row - 1][col].getIcon())) {
			verticalList.add(GameBoard.board[row][col]);
			row--;
		}
	}

	private void checkIfLeftMatch(int row, int col) {
		while (col > 0 && GameBoard.board[row][col].getIcon().equals(GameBoard.board[row][col - 1].getIcon())) {
			horizontalList.add(GameBoard.board[row][col]);
			col--;
		}
	}

	private void checkIfRightMatch(int row, int col) {
		while (col < 5 && GameBoard.board[row][col].getIcon().equals(GameBoard.board[row][col + 1].getIcon())) {
			horizontalList.add(GameBoard.board[row][col]);
			col++;
		}
	}

	private void refill() {
		for (int row = GameBoard.getBoard_height(); row < 0; row++) {
			for (int col = GameBoard.getBoard_width(); col < 0; col++) {
				if (GameBoard.board[row][col].getIcon() == null) {
					do {
						GameBoard.board[row][col] = GameBoard.board[row - 1][col];
						GameBoard.board[row - 1][col] = null;
						row--;
					} while (row != 0);
					// GameWindow.createButton(GameFigures.getRandomImage(), 0,
					// j);
				}
			}
		}

	}

	private void makeScore(int counter) {
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
