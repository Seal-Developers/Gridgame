package components;

public class enemy extends component{
	//every enemy has a location between 2 positions
	private int[] location;

	public int[] getLocation() {
		return location;
	}

	public void setLocation(int a,int b) {
		this.location[0] = a;
		this.location[1] = b;
	}

	@Override
	//do we have any restrictions on the moving enemies
	public void move(int p) {
		this.location[0] = p;
	}
	
	public void move(int a, int b) {
		this.location[0] = a;
		this.location[1] = b;
	}
}
