package components;

/**
 * Represent the vertical enemy within the graph with move method 
 * and a certain position between 2 squares
 * This class extends {@link enemy}
 *
 */
public class verticalEnemies extends enemy{
	
	/**
	 * Constructor
	 * this create a new vertical enemy object within a graph of size graphSize
	 * @param graphSize an int representing the size of the graph where the enemy is in
	 */
	public verticalEnemies(int graphSize) {
		super(graphSize);
	}

	/**
	 * this move the V enemy to the goal position
	 * it can only move within one certain column and can only move 1 square a time
	 * goal position (a,b)
	 * @param a an int of 1D position of one square next to the enemy
	 * 		  b another int 1D position of the other square next to the enemy
	 */
	@Override
	public void move(int a,int b) {
		//ensure vertical,same col and consecutive row number
		//now check if consecutive with origin
		if((Math.abs(a-b) == 1)&&
		   (a==this.twoPositions[0]+this.graphSize||b==this.twoPositions[0]+this.graphSize))
			super.move(a, b);
		System.out.println("not valid move");
	}
}
