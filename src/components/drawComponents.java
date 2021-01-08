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
	/**
	 * For given character draws it on the screen at its position
	 * 
	 * @param ch the character to be drawn
	 */
	public void drawCharacter(character ch) {
		String character = new String("C");
		//convert the current position of this character into the 2d on screen
		int x, y;
		int position = ch.getoneDPosition();
		int squareside = draw_Grid.squareside;
		int gridSize = ch.getSize();
		if(position % gridSize == 0) {
	  		 x = (gridSize - 1)*squareside;
	  		 y = (int) ((position/gridSize -1)* squareside);
	  	 }
	  	 else {
		     x = ((position % gridSize) - 1) * squareside;
		     y = (int) ((Math.ceil((position - 1)/ gridSize))* squareside);
	  	 }
		x = x + 15;
		y = y + 35;
		g.drawString(character, x, y);
	}
	/**
	 * For given enemy draws it on the screen
	 * 
	 * @param Enemy the enemy to be drawn
	 */
	public void drawEnemy(enemy Enemy) {
		String character = Enemy.enemyString;
		//convert the current position of this character into the 2d on screen
		int x, y;
		int position = Enemy.getoneDPosition();
		int squareside = draw_Grid.squareside;
		int gridSize = Enemy.getSize();
		if(position % gridSize == 0) {
	  		 x = (gridSize - 1)*squareside;
	  		 y = (int) ((position/gridSize - 1)* squareside);
	  	 }
	  	 else {
		     x = ((position % gridSize) - 1) * squareside;
		     y = (int) ((Math.ceil((position - 1)/ gridSize))* squareside);
	  	 }
		x = x + 15;
		y = y + 35;
		g.drawString(character, x, y);
	}
}
