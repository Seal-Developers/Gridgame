package components;

public class enemy{
	/**
	 * the int representing the enemy's position and a related graphSize of one side
	 */
	//(0,0)=1, (0,1)=2
	protected int oneDPosition;
	protected int graphSize;
	public String enemyString;
	/**
	 * Getter Method for oneDPosition
	 * @return oneDPosition of Character
	 */
	public int getoneDPosition() {
		return oneDPosition;
	}
	/**
	 * Getter Method for Size
	 * @return Size of the graph
	 */
	public int getSize() {
		return graphSize;
	}
	/**
	 * Setter Method for oneDPosition
	 */
	public void setoneDPosition(int position) {
		this.oneDPosition = position;
	}
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
	 * @param a an int of 1D position of the goal enermy position
	 */
	public void move(int a) {
		this.oneDPosition = a;
	}
	
}
