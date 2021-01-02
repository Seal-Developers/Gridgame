package components;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.awt.*;

public class drawComponents{
	static int[][] AdjMat;
	static Graphics g;
	static BufferStrategy bs;
	
	//constructor
	public drawComponents(int[][] AdjMat, Graphics g, BufferStrategy bs) {
		this.AdjMat = new int[AdjMat.length][AdjMat.length];
		this.AdjMat = AdjMat;
		this.g = g;
		this.bs = bs;
		//do something to set the font size
		int fontSize = 30;
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
	}
	
	public void drawCharacter(character ch) {
		if (ch==null)
			return;
		String character = new String("C");
		//convert the current position of this character into the 2d on screen
		int x = 25, y=25;
		g.drawString(character, x, y);
	}
	public void drawHE(horizontalEnemies h) {
		if (h==null)
			return;
		String character = new String("H");
		//convert the current position of this character into the 2d on screen
		int x = 10, y=10;
		g.drawString(character, x, y);
	}
	public void drawVE(verticalEnemies v) {
		if (v==null)
			return;
		String character = new String("V");
		//convert the current position of this character into the 2d on screen
		int x = 10, y=10;
		g.drawString(character, x, y);
	}
}
