package components;

/**
 * Represent the horizontal enemy within the graph with move method 
 * and a certain position between 2 squares
 * This class extends {@link enemy}
 *
 */
public class horizontalEnemies extends enemy{
	
	/**
	 * Constructor
	 * this create a new horizontal enemy object within a graph of size graphSize
	 * @param graphSize an int representing the size of the graph where the enemy is in
	 */
	public horizontalEnemies(int graphSize) {
		super(graphSize);
	}

	/**
	 * this move the H enemy to the goal position
	 * it can only move within one certain row and can only move 1 square a time
	 * @param a an int of 1D position of the goal enemy position
	 */
	@Override
	public void move(int a) {
		//ensure horizontal,same row and consecutive col
		//the square should have same col and consecutive row value
		//check if consecutive with origin
		
	    if((Math.abs(a-this.oneDPosition) == 1))
				super.move(a);
		System.out.println("not valid move");
	}
}
