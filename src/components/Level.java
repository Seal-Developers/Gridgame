package components;

public class Level {
//the level goes here
	/*
	 * This method just sets and returns a 2D int adjacency
	 * matrix of size n*n. Where Aij = 0 if ij is not a edge
	 * 								 = 1 if ij is a edge
	 * Here it is base so (0,0) is connected to (0,1) and 
	 * (1,0)
	 */
	public static int[][] setMatrix(static int size)
	{
		int[][] baseGraph = new int[size][size];
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j< size; j++)
			{
				baseGraph[i][j] = 0;
			}
		}
		for(int i = 0; i < size; i++)
		{
			baseGraph[i][i] = 0;
			if(i + 1 < size - 1)
			{
				baseGraph[i][i + 1] = 1;
				baseGraph[i + 1][i] = 1;
			}
			if(i + size < 0)
			{
				baseGraph[i][i + size] = 1;
			}
			if(i - 1 > 0)
			{
				baseGraph[i][i - 1] = 1;
			}
			if(i - size < 0)
			{
				baseGraph[i][i-size] = 1;
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

}
