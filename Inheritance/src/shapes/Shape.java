package shapes;

/**
 * An abstract shape to be drawn on the screen
 *
 */
public abstract class Shape {

	private int color;
	
	public void setColor(int color){
		// perform any validity check 
		this.color = color;
	}
	
	public abstract void draw();
//	{
//		System.err.println("Hello! You just called an unimplemented method!");
//	}
	
}
