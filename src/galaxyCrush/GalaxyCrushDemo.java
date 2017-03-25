package galaxyCrush;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GalaxyCrushDemo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GalaxyCrushDemo window = new GalaxyCrushDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//fdsfsds
	/**
	 * Create the application.
	 */
	public GalaxyCrushDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(57, 11, 400, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 6, 0, 0));

		ImageIcon earth = new ImageIcon("earth.png");
		ImageIcon saturn = new ImageIcon("saturn.png");
		ImageIcon mars = new ImageIcon("mars.png");
		ImageIcon neptune = new ImageIcon("neptune.png");

		ArrayList<ImageIcon> imageList = new ArrayList<ImageIcon>();

		imageList.add(earth);
		imageList.add(saturn);
		imageList.add(mars);
		imageList.add(neptune);

		// ImageIcon[] images = new ImageIcon[4];
		// for (int i = 0; i < images.length; i++) {
		// Ima
		// }
		//
		//
		// ImageIcon image = new ImageIcon("earth.png");

		// Color[] colors = new Color[] { Color.BLACK, Color.GREEN,
		// Color.YELLOW, Color.CYAN };

		for (int i = 0; i < 36; i++) {

			JButton btn = new JButton();
			btn.setIcon(imageList.get(new Random().nextInt(imageList.size())));
			panel.add(btn);
		}

	}
}
