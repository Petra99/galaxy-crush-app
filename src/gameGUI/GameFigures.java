package gameGUI;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class GameFigures {

	private static ArrayList<ImageIcon> imageList = new ArrayList<ImageIcon>();

	public static ImageIcon getRandomImage() {

		ImageIcon earth = new ImageIcon("earth.png");
		ImageIcon saturn = new ImageIcon("saturn.png");
		ImageIcon mars = new ImageIcon("mars.png");
		ImageIcon neptune = new ImageIcon("neptune.png");

		imageList.add(earth);
		imageList.add(saturn);
		imageList.add(mars);
		imageList.add(neptune);

		Random randomImage = new Random();
		int index = randomImage.nextInt(imageList.size());
		return imageList.get(index);
	}
}
