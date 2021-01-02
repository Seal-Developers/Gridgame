package components;

import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.awt.*;

public class draw_Grid{
	static int[][] AdjMat;
	static Graphics g;
	static BufferStrategy bs;
	static int squareside = 50;
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
	  Color cr3 = Color.pink; 
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
	  int gridSize = (int) Math.sqrt(row);
	  g.setColor(cr1);
	  g.drawLine(0, 0, squareside * (gridSize + 1), 0);
	  g.drawLine(0, 0, 0, squareside * (gridSize + 1));
	  g.drawLine(squareside * (gridSize + 1), 0, 
			  squareside * (gridSize + 1), squareside * (gridSize + 1));
	  g.drawLine(0,squareside * (gridSize + 1) , 
			  squareside * (gridSize + 1), squareside * (gridSize + 1));
	  Color customColor = new Color(10,250,250);
	  g.setColor(customColor);
	  	for(int i = 1; i<=row; i++) {
	  	 if(i % gridSize == 0) {
	  		 x_curr = gridSize*squareside;
	  		 y_curr = (int) ((Math.ceil(i / gridSize) + 1)* squareside);
	  	 }
	  	 else {
		     x_curr = (i % gridSize) * squareside;
		     y_curr = (int) ((Math.ceil((i - 1)/ gridSize) + 1)* squareside);
	  	 }
		  neigh = Level.returnneighbors(i, (int)Math.sqrt(row));
		  System.out.println(i +","+ neigh);
		  System.out.println();
		  for(int j = 0; j<neigh.size(); j++) {
	            if(AdjMat[i - 1][neigh.get(j)-1] == 1)
	                neigh.remove(j--);
	        }
		  System.out.println(i +","+ neigh);
		  System.out.println();
		  for(int j:neigh) {
			  if(j - i ==1) {
				 x_neigh = x_curr;
				 y_neigh = y_curr - squareside;
				 
			  }
			 else if(j - i == -1) {
				  if(j % gridSize == 0) {
				  		 x_curr = gridSize * squareside;
				  		 y_curr = (int) ((Math.ceil(j / gridSize) + 1)* squareside);
				  	 }
				  	 else {
					     x_curr = (j % gridSize) * squareside;
					     y_curr = (int) ((Math.ceil((j - 1)/ gridSize) + 1)* squareside);
				  	 }
				  x_neigh = x_curr;
				  y_neigh = y_curr - squareside;
			   }
			  else if(j - i == gridSize){
				  x_neigh = x_curr - squareside;
				  y_neigh = y_curr;
			  }
			  else {
				  if(j % gridSize == 0) {
				  		 x_curr = gridSize * squareside;
				  		 y_curr = (int) ((Math.ceil(j / gridSize) + 1)* squareside);
				  	 }
				  else {
					   x_curr = (j % gridSize) * squareside;
					   y_curr = (int) ((Math.ceil((j - 1)/ gridSize) + 1)* squareside);
				  }
				  x_neigh = x_curr - squareside;
				  y_neigh = y_curr;
			  }
			  System.out.println("I : " + i + " J: " + j + " x1: " + x_curr + " y1: " + y_curr + " x2: " + x_neigh + " y2 : " +y_neigh);
		      g.drawLine(x_curr , y_curr, x_neigh,  y_neigh);
		      if(i % gridSize == 0) {
			  		 x_curr = gridSize*squareside;
			  		 y_curr = (int) ((Math.ceil(i / gridSize) + 1)* squareside);
			  	 }
			  	 else {
				     x_curr = (i % gridSize) * squareside;
				     y_curr = (int) ((Math.ceil((i - 1)/ gridSize) + 1)* squareside);
			  	 }
		 }
	  }
  }
  //it will be called in main game loop
  //it need Graphics object
  //We can draw character easily by doing g.write("C", 1Dposition)
  //How do we draw the enemies?
  //draw Level
  //Draw character
  //Accept user input
}
