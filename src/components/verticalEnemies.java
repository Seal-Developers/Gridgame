package components;

public class verticalEnemies extends enemy{
	
	public verticalEnemies(int graphSize) {
		super(graphSize);
	}

	@Override
	public void move(int a,int b) {
		//ensure vertical,same col and consecutive
		//now check if consecutive with origin
		if((Math.abs(a-b) == 1)&&
		   (a==this.twoPositions[0]||b==this.twoPositions[0]))
			super.move(a, b);
		System.out.println("not valid move");
	}
}
