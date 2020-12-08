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
	  int row = AdjMat.length,x_curr,y_curr,x_neigh,y_neigh;
	  ArrayList<Integer> neigh = new ArrayList<Integer>();
	  int squareside = 600/9;
	  for(int i = 1;i<=row;i++) {
		  x_curr = Level.convert1Dto2D(i, 3)[0];
		  y_curr = Level.convert1Dto2D(i, 3)[1];
		  neigh = Level.returnneighbors(i, 3);
		  for( int j = 0; j<neigh.size(); j++) {
	            if(neigh.get(j) == 0)
	                neigh.remove(j);
	        }
		  for(int neighbour:neigh) {
			  x_neigh = Level.convert1Dto2D(neighbour, 3)[0];
			  y_neigh = Level.convert1Dto2D(neighbour, 3)[1];
			  if(Math.abs(neighbour-i)==1) {
				 g.drawLine(squareside*(x_curr + 1) , squareside*(y_curr+1+(y_curr - y_neigh)), 
						  squareside*(x_curr + 1), squareside*(y_curr +1));
			  }
			  else{
				  g.drawLine(squareside*(x_curr + 1+(x_curr - x_neigh)) , squareside*(y_curr+1), 
						  squareside*(x_curr + 1), squareside*(y_curr +1));
			  }
		  }
	  }
	  
  }
}
