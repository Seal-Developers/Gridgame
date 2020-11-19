package components;

import java.util.ArrayList;
import java.util.Arrays;
public class Level {
//the level goes here
	/*
	 *Returns the 2D Coordinate of a point in a integer array of length 2 
	 *
	 *@param x x position of the node
	 *@param y y position of the node
	 *@param size is the size of the grid
	 *@return Single coordinate of the node
	 */
	public static int convert2Dtonode(int x, int y, int size)
	{
		return (size * x) + y + 1;
	}
	/*
	 *Returns the 2D Coordinate of a point in a integer array of length 2 
	 *@param singleCord coordinate of node
	 *@param size is the size of the grid
	 *@return Array of length 2 of points x y coordinates
	 */
	public static int[] convert1Dto2D(int singleCord, int size)
	{
		int[] ret = new int[2];
		ret[0] = (int)Math.floor((singleCord - 1)/size);
		ret[1] = singleCord - (size * ret[0]) -1;
		return ret;
	}
	/*
	 *Returns the neighbors of a node in an arrayList of Integers
	 *
	 *@param singleCord coordinate of node
	 *@param size is the size of the grid
	 *@return ArrayList of neighbors
	 */
	public static ArrayList<Integer> returnneighbors(int singleCord, int size)
	{
		ArrayList<Integer> neigh = new ArrayList<Integer>();
		int flooredpoint = (int)Math.floor((singleCord - 1)/size); 
		System.out.println("ebuyegu" + flooredpoint);
		System.out.println("hahah" + (singleCord - (size * flooredpoint + 1)));
		int[] currcod = Level.convert1Dto2D(singleCord, size);
		if(singleCord - size  > 0)
		{
			neigh.add(singleCord - size);
		}
		if(singleCord - (size * flooredpoint + 1) > 0)
		{
			neigh.add(size * flooredpoint + 1);
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
	/*
	 * This method just sets and returns a 2D int adjacency
	 * matrix of size (size^2)*(size^2). Where Aij = 0 if ij is not a edge
	 * 								               = 1 if ij is a edge
	 * Notice that in a size by size grid there are actually size^2 nodes
	 * hence adjacency matrix is (size^2)*(size^2)
	 * Here it is base so (0,0) is connected to (0,1) and 
	 * (1,0)
	 *  @param size size of the grid 
	 *  @return the base Adjacency matrix
	 */
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
		for(int i = 1; i <= size * size; i++)
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
	 * matrix of size (size^2)*(size^2). Where Aij = 0 if ij is not a edge
	 * 								               = 1 if ij is a edge
	 * Notice that in a size by size grid there are actually size^2 nodes
	 * hence adjacency matrix is (size^2)*(size^2)
	 * Here it is base so (0,0) is connected to (0,1) and 
	 * (1,0)
	 *  @param size size of the grid 
	 *  @return the level  Adjacency matrix
	 */
	public static int[][] getLevel(int[][] BaseMap)
	{
		double[][] copymap = new double[BaseMap.length][BaseMap[0].length];
		for(int i = 0; i < BaseMap.length; i++)
		{
			for(int j = 0; j < BaseMap[0].length; j++)
			{
				copymap[i][j] = BaseMap[i][j];
				if(BaseMap[i][j] != 0)
					copymap[i][j] += (int)(Math.random() * (10 - 1 + 1) + 1);
			}
		}
		return PrimmsAlgorithm(copymap);
	}
	/*
	 * This method returns true iff (edge)u - v is not in Minimum Spanning Tree and 
	 * exactly 1 of the edge is in Minimum Spanning Tree
	 * 
	 *  @param u is the first node
	 *  @param v is the second node 
	 *  @param inMST a boolean Array telling if nodes are in MST or not
	 *  @return true iff (edge)u - v is not in Minimum Spanning Tree and 
	 *   exactly 1 of the edge is in Minimum Spanning Tree
	 */
	static boolean isValidEdge(int u, int v, boolean[] inMST) 
		{ 
			if (u == v) 
				return false; 
			if (inMST[u] == false && inMST[v] == false) 
				return false; 
			else if (inMST[u] == true && inMST[v] == true) 
				return false; 
			return true; 
		} 

	/*
	 * This method returns minimum spanning tree for a graph using Primms 
	 * Algorithm
	 *  @param Weightedmap is the a undirectional weighted map 
	 *  @return the Minimum SPanning Tree of Weightedmap
	 */
	public static int[][] PrimmsAlgorithm(double[][] Wieghtedmap){
		//
		int INF = 9999999;
		
		int V = Wieghtedmap.length;
	    int no_edge; // number of edge

	    // create a array to track selected vertex
	    // selected will become true otherwise false
	    boolean[] selected = new boolean[V];
	    int[][] level = new int[Wieghtedmap.length][Wieghtedmap[0].length]; 
	    // set selected false initially
	    Arrays.fill(selected, false);
	    for(int[] row: level)
	    	 Arrays.fill(row, 0);
	    // set number of edge to 0
	    no_edge = 0;

	    // the number of egde in minimum spanning tree will be
	    // always less than (V -1), where V is number of vertices in
	    // graph

	    // choose 0th vertex and make it true
	    selected[0] = true;

	    // print for edge and weight
	    System.out.println("Edge : Weight");

	    while (no_edge < V - 1) {
	      // For every vertex in the set S, find the all adjacent vertices
	      // , calculate the distance from the vertex selected at step 1.
	      // if the vertex is already in the set S, discard it otherwise
	      // choose another vertex nearest to selected vertex at step 1.

	      double min = INF;
	      int x = 0; // row number
	      int y = 0; // col number

	      for (int i = 0; i < V; i++) {
	        if (selected[i] == true) {
	          for (int j = 0; j < V; j++) {
	            // not in selected and there is an edge
	            if (!selected[j] && Wieghtedmap[i][j] != 0) {
	              if (min > Wieghtedmap[i][j]) {
	                min = Wieghtedmap[i][j];
	                x = i;
	                y = j;
	              }
	            }
	          }
	        }
	      }
	      level[x][y] = 1;
	      level[y][x] = 1;
	      selected[y] = true;
	      no_edge++;
	    }
	    return level;
	}
	public static void main(String[] args)
	{
		int singleCord = Level.convert2Dtonode(3, 3, 4);
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
		int[][] level = new int[9][9];
		level = Level.getLevel(basemap);
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9;j++){
				System.out.print(level[i][j]);
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
