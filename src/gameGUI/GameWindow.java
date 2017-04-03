package gameGUI;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameWindow {

	private JButton[][] buttons;

	private JLabel proba;

	private JFrame frame;
	private JPanel panel;

	private OnUserAction listener;

	public GameWindow(int width, int heigth) {
		buttons = new JButton[width][heigth];
		getComponentsOfTheWindow();
	}

	public void runWindow() {
		try {
			// GameWindow window = new GameWindow();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getComponentsOfTheWindow() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(27, 140, 400, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 6, 0, 0));

		JLabel lblGalaxyCrush = new JLabel("Galaxy Crush");
		lblGalaxyCrush.setHorizontalAlignment(SwingConstants.CENTER);
		lblGalaxyCrush.setFont(new Font("Trajan Pro", Font.BOLD, 40));
		lblGalaxyCrush.setBounds(159, 61, 316, 41);
		frame.getContentPane().add(lblGalaxyCrush);

		JButton startBtn = new JButton("start");
		startBtn.setFont(new Font("Trajan Pro", Font.PLAIN, 20));
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		startBtn.setBounds(159, 555, 101, 29);
		frame.getContentPane().add(startBtn);

		JLabel lblScore = new JLabel("Score :");
		lblScore.setFont(new Font("Trajan Pro", Font.PLAIN, 20));
		lblScore.setBounds(475, 401, 79, 21);
		frame.getContentPane().add(lblScore);

		JLabel lblTime = new JLabel("Time :");
		lblTime.setFont(new Font("Trajan Pro", Font.PLAIN, 20));
		lblTime.setBounds(475, 217, 79, 21);
		frame.getContentPane().add(lblTime);

		proba = new JLabel("");
		proba.setBounds(475, 294, 46, 14);
		frame.getContentPane().add(proba);

		for (int i = 0; i < buttons[0].length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				createButtons(GameFigures.getRandomImage(), i, j);
			}
		}

	}

	public void createButtons(ImageIcon image, int x, int y) {
		JButton btn = new JButton();
		btn.setIcon(image);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// to do
				listener.onButtonClicked(x, y);
			}
		});
		buttons[x][y] = btn;
		panel.add(btn);
		SwingUtilities.updateComponentTreeUI(panel);
	}

	public void changeButton(int x, int y) {
		proba.setText("Uspeshno");
		buttons[x][y].setVisible(false); // probno
	}

	// vruzka windows i vs ostanalo
	public void setListener(OnUserAction listener) {
		this.listener = listener;
	}

	public interface OnUserAction {
		void onButtonClicked(int x, int y);

	}
}
