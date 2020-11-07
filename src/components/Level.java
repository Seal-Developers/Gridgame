package components;
import java.lang.*;
import java.util.ArrayList;
public class Level {
//the level goes here
	/*
	 * This method just sets and returns a 2D int adjacency
	 * matrix of size n*n. Where Aij = 0 if ij is not a edge
	 * 								 = 1 if ij is a edge
	 * Here it is base so (0,0) is connected to (0,1) and 
	 * (1,0)
	 */
	public static int convert2Dtonode(int x, int y, int size)
	{
		return (size * x) + y + 1;
	}
	public static int[] convert1Dto2D(int singleCord, int size)
	{
		int[] ret = new int[2];
		ret[0] = (int)Math.floor((singleCord - 1)/size);
		ret[1] = singleCord - (size * ret[0]) -1;
		return ret;
	}
	public static ArrayList<Integer> returnneighbors(int singleCord, int size)
	{
		ArrayList<Integer> neigh = new ArrayList<Integer>();
		int[] maxcord = Level.convert1Dto2D(size*size, size);
		int[] currcod = Level.convert1Dto2D(singleCord, size);
		if(singleCord - size > 0)
		{
			neigh.add(singleCord - size);
		}
		if(singleCord - 1 > 0)
		{
			neigh.add(singleCord - 1);
		}
		if(currcod[1] + 1 < size)
		{
			neigh.add(Level.convert2Dtonode(currcod[0], currcod[1] + 1, size));
		}
		if(currcod[0] + 1 < size)
		{
			neigh.add(Level.convert2Dtonode(currcod[0] + 1 , currcod[1], size));
		}
		return neigh;
	}
	public static int[][] setMatrix(int size)
	{
		int[][] baseGraph = new int[size * size][size * size];
		for(int i = 0; i < size * size; i++)
		{
			for(int j = 0; j < size * size; j++)
			{
				baseGraph[i][j] = 0;
			}
		}
		for(int i = 1; i <+ size * size; i++)
		{
			ArrayList<Integer> neigh = Level.returnneighbors(i, size);
			System.out.println("The neighbors of " + i);
			for(int j = 0; j < neigh.size(); j++)
			{
				System.out.println(neigh.get(j));
				baseGraph[i - 1][neigh.get(j) - 1] = 1;
			}
		}
		return baseGraph;
	}
	/*
	 * This method just sets and returns a 2D int adjacency
	 * matrix of size n*n. Where Aij = 0 if ij is not a edge
	 * 								 = 1 if ij is a edge
	 * Here it is base so (0,0) is connected to (0,1) and 
	 * (1,0)
	 */
	public static void main(String[] args)
	{
		int singleCord = Level.convert2Dtonode(0, 0, 4);
		int[] cord = new int[2];
		cord = Level.convert1Dto2D(singleCord, 4);
		System.out.println("The value of singleCord is " + singleCord + 
				" The value of x and y is " + cord[0] + " / " + cord[1]);
		ArrayList<Integer> neigh = Level.returnneighbors(singleCord, 4);
		System.out.println("The neighbors of " + singleCord);
		for(int i = 0; i < neigh.size(); i++)
		{
			System.out.println(neigh.get(i));
		}
		int[][] basemap = new int[9][9];
		basemap = Level.setMatrix(3);
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9;j++)
			{
				System.out.print(basemap[i][j]);
			}
			System.out.println();
		}
	}
/*
 * From what I understand, every Character must have a render method which would
 * Show him on that location. SO for example if size is 4, if
 *  and User is on position (7)||(1,1) then render 0,0 is 1 0,1 is 2 0,2 is 3 0,3 is 4 0,4 is 5
 *   1,0 is 6 and 1,1 is 7
 * would write a C at position 7||(1,1). instead if it was horizontal enemy then it would write H
 * and if it was Vertical enemy it would write V.
 */
}
