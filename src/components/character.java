package components;

import java.util.ArrayList;


public class character{
	/**
	 * every character has a 1D position and a related size of the graph
	 */
	private int oneDPosition;
	private int Size;
	//constructor
	/**
	* this create a new character object within a graph of size Size
	* oneDPosition is an int representing the initial position of it(usually 1)
	* @param Size an int representing the size of the graph where the character is in
	*/
	public character(int graphSize) {
			this.Size = graphSize;
			this.oneDPosition = 0;
		}
	
	/**
	 * move the character to another 1D position and check if it collapse or win
	 * @param p an int representing the position goal
	 * 		  default just an unused number
	 * @param lvl an int tuple representing the 2Dlevel
	 * @return null
	 * 		   a successful move will update the character's current position
	 * 		   and when there is a collision or the player wins, we exit the game
	 */
	public void move(int p,int[][] lvl) {
		//first check if the position is valid
		if(p<1||p>this.Size*this.Size) {//this should be the max size
			System.out.println("Position out of range QAQ");
		}
		if(this.checkIfCollision(p, lvl)) {
			System.out.println("Collision Occurs!!");
			//maybe we need to do sth to end the game?
		}
		//when we success
		this.oneDPosition = p;
		if(this.checkIfWon()){
			System.out.println("You win LOL!!");
			//maybe we need to do sth to end the game?
		}
	}
	/**
	 * check if the goal position will cause a collision
	 * @param p an int representing 1d goal position
	 * @param lvl an int tuple representing the 2Dlevel
	 * @return true if the collision occurs; false if character is safe
	 */
	public boolean checkIfCollision(int p, int[] [] lvl) {
		ArrayList<Integer> enermyList = Level.returnneighbors(this.oneDPosition, this.Size);
		for( int j = 0; j<enermyList.size(); j++) {
			if(lvl[p-1][enermyList.get(j)-1] == 0)
				enermyList.remove(j);
		}
		//check if there is an enermy b/t current position and "future" position
		for(int i = 0; i<enermyList.size(); i++) {
			if ((int) enermyList.get(i)==p)
				return false;
		}
		return true;
	}
	
	/**
	 * check if the current status of the character is at the winning place
	 * @return true if the player wins; false if not
	 */
	public boolean checkIfWon() {
		if(this.oneDPosition==this.Size*this.Size)//last node position
			return true;
		return false;	
	}
}
