package components;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class MyCanvas extends Canvas {
	@Override
	public void paint(Graphics g) {
		Color customColor = new Color(10,250,250);
		g.setColor(customColor);
		//Draw Here!
		//int[][] AdjMat = makeLevel();
		//draw_Grid d = new draw_Grid(AdjMat, g, bs) ;
		g.drawLine(200,200,250,200);
		//d.drawLevel();
		g.fillRect(0, 0, 200, 200);
	}
}
