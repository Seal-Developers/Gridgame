package components;

public class horizontalEnemies extends enemy{

	public horizontalEnemies(int graphSize) {
		super(graphSize);
	}

	@Override
	public void move(int a,int b) {
		//ensure horizontal,same col and consecutive
		//check if consecutive with origin
		
	    if((Math.abs(a-b) == this.graphSize)&&
	       (a==this.twoPositions[0]||b==this.twoPositions[0]))
				super.move(a, b);
		System.out.println("not valid move");
			
	}
}
