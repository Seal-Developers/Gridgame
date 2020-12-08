package components;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class draw_Grid{
	static int[][] AdjMat;
	static Graphics g;
	static BufferStrategy bs;
	public draw_Grid(int[][] AdjMat, Graphics g, BufferStrategy bs) {
		this.AdjMat = new int[AdjMat.length][AdjMat.length];
		this.AdjMat = AdjMat;
		this.g = g;
		this.bs = bs;
	}
  public static void drawLevel() {
	  int row = AdjMat.length,cod;
	  g.drawLine(200,200,250,200);
	  ArrayList<Integer> neigh;
	  for(int i = 1;i <= row*row;i++) {
			  neigh = Level.returnneighbors(i, row);
			  for(int k = 0;k<neigh.size();k++) {
				  g.drawLine(200,200,250,200);
			  }
		  
	  }
	  
  }
}
