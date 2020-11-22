package components;

public class enemy extends component{
	//every enemy has a location between 2 positions
	//(0,0)=1, (0,1)=2
	protected int[] twoPositions;

	//constructor
	public enemy(int graphSize) {
		this.graphSize = graphSize;
	}
	

	public void move(int a,int b) {
		
		this.twoPositions[0] = a;
		this.twoPositions[1] = b;
	}
	
}
