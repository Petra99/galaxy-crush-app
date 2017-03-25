package galaxyCrush;

import javax.swing.ImageIcon;

public class Earth extends Figure{

	@Override
	public ImageIcon getImage() {
		ImageIcon image = new ImageIcon("earth.png");
		return image;
	}
}
