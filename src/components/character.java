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
	 * 
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
		if(this.checkIfWon()){
			System.out.println("You win LOL!!");
			//maybe we need to do sth to end the game?
		}
		//when we success
		this.oneDPosition = p;
		
	}
	public boolean checkIfCollision(int p) {
		ArrayList<Integer> enermyList = Level.returnneighbors(this.oneDPosition, this.graphSize);
		//check if there is an enermy b/t current position and "future" position
		for(int i = 0; i<enermyList.size(); i++) {
			if ((int) enermyList.get(i)==p)
				return false;
		}
		return true;
	}
	
	public boolean checkIfWon() {
		if(this.oneDPosition==this.graphSize*this.graphSize)//last node position
			return true;
		return false;	
	}
}
