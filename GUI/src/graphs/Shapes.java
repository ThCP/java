package graphs;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Shapes extends JFrame {

	private int offset=0;
	public Shapes(){
		setTitle("Shapes");
		
		setSize(500,500);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Thread t = new Thread(() ->{
			while(true){
				offset+=10;
				repaint();
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					break;
				}
			}
		});
		t.start();
	}
	
	
	public void paint(Graphics g){
		
		g.clearRect(0, 0, getSize().width, getSize().height);
		g.fillRoundRect(10+offset, 100+offset, 300, 200, 10, 10);

		// THE FOLLOWING CODE IS COMPLETELY AND ABSOLUTELY WRONG!!!!
//		x=10;
//		while(true){
//				g.fillRoundRect(x, 100, 300, 200, 10, 10);
//				// sleep for 1 second
//				x+=10;
//		}
		
	}
	
	
	public static void main(String[] args) {
		
		new Shapes();

	}

}
