package components;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.awt.*;

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
	  for(int i = 0; i < 12; i++)
		{
			for(int j = 0; j < 12;j++)
			{
				System.out.print(AdjMat[i][j]);
			}
			System.out.println();
		}
	  System.out.println();
	  ArrayList<Integer> neigh = new ArrayList<Integer>();
	  int squareside = 50, off= 50;
	  //g.drawLine(off, off, off + (squareside * (int)Math.sqrt(row)), off);
	  //g.drawLine(off, off, off, off+ (squareside * (int)Math.sqrt(row)));
	  //g.drawLine(off+ (squareside * (int)Math.sqrt(row)), off, off + (squareside * (int)Math.sqrt(row)), off+ (squareside * (int)Math.sqrt(row)));
	  for(int i = 1;i<=row;i++) {
		  x_curr = Level.convert1Dto2D(i, (int)Math.sqrt(row))[0];
		  y_curr = Level.convert1Dto2D(i, (int)Math.sqrt(row))[1];
		  neigh = Level.returnneighbors(i, (int)Math.sqrt(row));
		  System.out.println(neigh);
		  System.out.println();
		  for( int j = 0; j<neigh.size(); j++) {
	            if(AdjMat[i - 1][neigh.get(j)-1] == 1)
	                neigh.remove(j--);
	        }
		  System.out.println(neigh);
		  System.out.println();
		  if(x_curr % (int)Math.sqrt(row) != 0) {
		  for(int neighbour:neigh) {
			  x_neigh = Level.convert1Dto2D(neighbour, (int)Math.sqrt(row))[0];
			  y_neigh = Level.convert1Dto2D(neighbour, (int)Math.sqrt(row))[1];
			  if(Math.abs(neighbour-i)==1) {
				 //g.drawLine(squareside*(x_curr) , squareside*(y_curr+1+(y_curr - y_neigh)), 
					//	   squareside*(x_curr ), squareside*(y_curr +1));
				 g.drawLine(off +squareside*(x_curr) , off + squareside*(y_curr+1+(y_curr - y_neigh)), 
				  off + squareside*(x_curr ), off+ squareside*(y_curr +1));
			  }
			  else{
				  //g.drawLine(squareside*(x_curr+(x_curr - x_neigh)) ,squareside*(y_curr+1), 
						// squareside*(x_curr),squareside*(y_curr +1));
				  g.drawLine(off + squareside*(x_curr+(x_curr - x_neigh)) , off +squareside*(y_curr+1), 
						  off + squareside*(x_curr),off+  squareside*(y_curr +1));
			  }
		  }
		 }
	  }
  }
  public static void drawComponents(component components) {
	  int squareside = 600;
  }
}
