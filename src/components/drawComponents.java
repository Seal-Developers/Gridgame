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
		int fontSize = 10;
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
	}
	
	public void drawCharacter(character ch) {
		String character = new String("C");
		//convert the current position of this character into the 2d on screen
		int x = 10, y=10;
		g.drawString(character, x, y);
	}
	public void drawHE(horizontalEnemies h) {
		String character = new String("H");
		//convert the current position of this character into the 2d on screen
		int x = 10, y=10;
		g.drawString(character, x, y);
	}
	public void drawVE(verticalEnemies v) {
		String character = new String("V");
		//convert the current position of this character into the 2d on screen
		int x = 10, y=10;
		g.drawString(character, x, y);
	}
}
