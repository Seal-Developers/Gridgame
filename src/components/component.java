package components;

/**
 * Represents the abstract base of all Commands
 *
 */
public abstract class component {
	
	protected int graphSize; //for one side
	/**
	 * update the current position field of the components
	 * @param a an int represent the goal 1d position 
	 * @param b an int represent another goal 1d position or just an unrelated default value
	 */
	public abstract void move(int a,int b);
	
}
