package components;

public class character extends component{
	
	private int position;
	
	@Override
	public void move(int p) {
		//first check if the position is valid
		if(p<1||p>64) {//this should be the max size
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
		this.position = p;
		
	}
	public boolean checkIfCollision(int p) {
		ArrayList[] enermyList = getEnermies(this.position);
		//check if there is an enermy b/t current position and "future" position
		for(int i = 0; i<enermyList.size(); i++) {
			if (enermyList[i]==p)
				return true;
		}
		return false;
	}
	
	public boolean checkIfWon() {
		if(this.position==64)//last node position
			return true;
		return false;	
	}
}
