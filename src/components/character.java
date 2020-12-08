package components;

import java.util.ArrayList;
/**
 * Represent the player character with move, checkCollision and checkIfWon methods
 * This class extends {@link component}
 *
 */

public class character extends component{
	/**
	 * every character has a 1D position
	 */
	private int oneDPosition;
	
	@Override
	/**
	 * move the character to another 1D position and check if it collapse or win
	 * @param p an int representing the position goal
	 * 		  default just an unused number
	 * @return null
	 * 		   a successful move will update the character's current position
	 * 		   and when there is a collision or the player wins, we exit the game
	 */
	public void move(int p,int defalt) {
		//first check if the position is valid
		if(p<1||p>this.graphSize*this.graphSize) {//this should be the max size
			System.out.println("Position out of range QAQ");
		}
		if(this.checkIfCollision(p)) {
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
		ArrayList<Integer> enermyList = Level.returnneighbors(this.oneDPosition, this.graphSize);
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
		if(this.oneDPosition==this.graphSize*this.graphSize)//last node position
			return true;
		return false;	
	}
}
