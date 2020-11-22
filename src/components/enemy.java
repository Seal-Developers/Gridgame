package components;

/**
 * Represent the enemy within the graph with move method and a certain position between 2 squares
 * This class extends {@link component}
 *
 */
public class enemy extends component{
	/**
	 * the int array representing the enemy's position
	 */
	//every enemy has a location between 2 positions
	//(0,0)=1, (0,1)=2
	protected int[] twoPositions;

	//constructor
	/**
	 * this create a new enemy object within a graph of size graphSize
	 * @param graphSize an int representing the size of the graph where the enemy is in
	 */
	public enemy(int graphSize) {
		this.graphSize = graphSize;
	}
	
	/**
	 * move the enemy to the given goal position
	 * @param a an int of 1D position of one square next to the enemy
	 * 		  b another int 1D position of the other square next to the enemy
	 * a,b is the goal position
	 */
	@Override
	public void move(int a,int b) {
		
		this.twoPositions[0] = a;
		this.twoPositions[1] = b;
	}
	
}
