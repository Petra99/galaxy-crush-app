package gameGUI;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameWindow {

	private static JButton tempButton;
	private ImageIcon tempIcon;
	private JButton[][] buttons;
	private JLabel proba;
	private JFrame frame;
	private JPanel panelBoard;
	private OnUserAction listener;
	
	public GameWindow(int width, int heigth) {
		buttons = new JButton[width][heigth];
		getComponentsOfTheWindow();
	}

	public void runWindow() {
		try {
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JButton[][] getButtons() {
		return buttons;
	}
	
	public static JButton getTempButton() {
		return tempButton;
	}
	
	private void getComponentsOfTheWindow() {
		prepareFrame();

		preparePanelBoard();

		prepareTitleLabel();

		prepareStartButton();

		prepareScoreLabel();

		prepareTimeLabel();

		proba = new JLabel("");
		proba.setBounds(475, 294, 46, 14);
		frame.getContentPane().add(proba);
		
		JLabel lblBackgroundHolder = new JLabel("New label");
		lblBackgroundHolder.setBounds(0, 0, 650, 650);
		frame.getContentPane().add(lblBackgroundHolder);
		
		//ImageIcon icon = new ImageIcon("temp.png");
		
		//tempButton.setIcon(icon);

		generateBoardFigures();

	}

	private void prepareTimeLabel() {
		JLabel lblTime = new JLabel("Time :");
		lblTime.setFont(new Font("Trajan Pro", Font.PLAIN, 20));
		lblTime.setBounds(475, 217, 79, 21);
		frame.getContentPane().add(lblTime);
	}

	private void prepareScoreLabel() {
		JLabel lblScore = new JLabel("Score :");
		lblScore.setFont(new Font("Trajan Pro", Font.PLAIN, 20));
		lblScore.setBounds(475, 401, 79, 21);
		frame.getContentPane().add(lblScore);
	}

	private void prepareStartButton() {
		JButton startBtn = new JButton("start");
		startBtn.setFont(new Font("Trajan Pro", Font.PLAIN, 20));
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelBoard.setVisible(true);
			}
		});
		startBtn.setBounds(159, 555, 101, 29);
		frame.getContentPane().add(startBtn);
	}

	private void prepareTitleLabel() {
		JLabel lblGalaxyCrush = new JLabel("Galaxy Crush");
		lblGalaxyCrush.setHorizontalAlignment(SwingConstants.CENTER);
		lblGalaxyCrush.setFont(new Font("Trajan Pro", Font.BOLD, 40));
		lblGalaxyCrush.setBounds(159, 61, 316, 41);
		frame.getContentPane().add(lblGalaxyCrush);
	}

	private void preparePanelBoard() {
		panelBoard = new JPanel();
		panelBoard.setBounds(27, 140, 400, 400);
		frame.getContentPane().add(panelBoard);
		panelBoard.setLayout(new GridLayout(0, 6, 0, 0));
		panelBoard.setVisible(false);
	}

	private void prepareFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	private void generateBoardFigures() {
		for (int i = 0; i < buttons[0].length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				setButtonImage(GameFigures.getRandomImage(), i, j);
			}
		}
	}


	public void setButtonImage(ImageIcon image, int x, int y) {
		JButton btn = new JButton();
		btn.setIcon(image);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.onButtonClicked(x, y);
				
			}
		});
		buttons[x][y] = btn;
		panelBoard.add(btn);
	}

	public void changeButton(int x, int y) {
		proba.setText("Uspeshno");
		buttons[x][y].setVisible(false);
		// probno
	}

	//connection between GameWindow & 
	public void setListener(OnUserAction listener) {
		this.listener = listener;
	}

	public interface OnUserAction {
		void onButtonClicked(int x, int y);

	}
}