package components;

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
	  Color cr1 = Color.orange; 
	  Color cr2 = Color.red; 
	  Color cr3 = Color.white; 
	  System.out.println("row = " + row);
	  for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < row;j++)
			{
				System.out.print(AdjMat[i][j]);
			}
			System.out.println();
		}
	  System.out.println();
	  ArrayList<Integer> neigh = new ArrayList<Integer>();
	  int squareside = 50, off= 50;
	  /*g.setColor(cr1);
	  g.drawLine(off, off, off * 5, off);
	  g.setColor(cr2);
	  g.drawLine(off, off, off, off * 5);
	  g.setColor(cr3);
	  g.drawLine(off * 5, off, off * 5, off* 5);*/
	  g.setColor(cr1);
	  g.drawLine(0, 0, 250, 0);
	  g.setColor(cr2);
	  g.drawLine(0, 0, 0, 250);
	  g.setColor(cr3);
	  g.drawLine(250, 0, 250, 250);
	  Color customColor = new Color(10,250,250);
	  g.setColor(customColor);
	  	for(int i = 1;i<=row;i++) {
		  x_curr = Level.convert1Dto2D(i, (int)Math.sqrt(row))[0];
		  y_curr = Level.convert1Dto2D(i, (int)Math.sqrt(row))[1];
		  neigh = Level.returnneighbors(i, (int)Math.sqrt(row));
		  System.out.println(i +","+ neigh);
		  System.out.println();
		  for( int j = 0; j<neigh.size(); j++) {
	            if(AdjMat[i - 1][neigh.get(j)-1] == 1)
	                neigh.remove(j--);
	        }
		  System.out.println(i +","+ neigh);
		  System.out.println();
		if(i > 5 && i <= 12 ) {
		  for(int neighbour:neigh) {
			  x_neigh = Level.convert1Dto2D(neighbour, (int)Math.sqrt(row))[0];
			  y_neigh = Level.convert1Dto2D(neighbour, (int)Math.sqrt(row))[1];
			  if(Math.abs(neighbour-i)==1) {
				  System.out.println("horizontal line"+"curr:" + "neigh: " + neighbour + " i:" + i + " 1stcord: " + (squareside*(x_curr)) + 
						  " 2ndcord: " +  (squareside*(y_curr+1+(y_curr - y_neigh))) + " 3rdcord: " + (squareside*(x_curr )) +
						  " 4thcord: " +( squareside*(y_curr +1)) );
				  
				  
				 //g.drawLine(off + squareside*(x_curr) ,off + squareside*(y_curr+1+(y_curr - y_neigh)), 
					//	   off + squareside*(x_curr ), off + squareside*(y_curr +1));
				  System.out.println("x_curr = "+ x_curr + " y_curr = "+ y_curr );
				 g.drawLine(squareside*(x_curr) ,squareside*(y_curr+1+(y_curr - y_neigh)), 
					   squareside*(x_curr ),  squareside*(y_curr +1));
				 
				 
			  }
			  else{
				  System.out.println("vertical line"+"curr:" + "neigh: " + neighbour + " i:" + i  + " 1stcord: " + (squareside*(x_curr+1+(x_curr - x_neigh)))
						  + " 2ndcord: " +  (squareside*(y_curr+1)) + " 3rdcord: " + ( squareside*(x_curr)) +
						  " 4thcord: " +(squareside*(y_curr +1)) );
				  
				  //g.drawLine(off + squareside*(x_curr+1+(x_curr - x_neigh)) ,off + squareside*(y_curr+1), 
					// off + squareside*(x_curr),off + squareside*(y_curr +1));
				g.drawLine(squareside*(x_curr+1+(x_curr - x_neigh)) ,squareside*(y_curr+1), 
					squareside*(x_curr),squareside*(y_curr +1));
			  }
		  }
		 }
	  }
  }
}
