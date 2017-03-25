package galaxyCrush;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.Color;

public class GalaxyCrush extends JFrame {

	private JFrame frame;

	public JToggleButton matrixButtons[];
	public JToggleButton tBtn;
	public JPanel numbersMatrixPanel;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GalaxyCrush window = new GalaxyCrush();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GalaxyCrush() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 25, 414, 225);
		frame.getContentPane().add(panel);
		
		numbersMatrixPanel = new JPanel();
		numbersMatrixPanel.setForeground(new Color(255, 255, 255));
		numbersMatrixPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(51, 0, 51)));
		numbersMatrixPanel.setBounds(150, 150, 300, 300);
		numbersMatrixPanel.setLayout(new GridLayout(0, 7));
		contentPane.add(numbersMatrixPanel);

		matrixButtons = new JToggleButton[49];
		for (int j = 0; j < matrixButtons.length; j++) {
			matrixButtons[j] = new JToggleButton(String.valueOf(j + 1));
			matrixButtons[j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tBtn = (JToggleButton) e.getSource();

				}
			});
		}

	}
}
