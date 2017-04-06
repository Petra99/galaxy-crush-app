package gameGUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class proba {
	public static void main(String[] args) {

		JButton btn1 = new JButton();
		JButton btn2 = new JButton();
		
		ImageIcon earth = new ImageIcon("pl1.png");
		ImageIcon saturn = new ImageIcon("pl2.png");
		
		btn1.setIcon(earth);
		btn2.setIcon(earth);
		
		if(btn1.getIcon().equals(btn2.getIcon())){
			System.out.println("zdrrr");
		}
	}
}
