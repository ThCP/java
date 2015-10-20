package example;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Lines extends JFrame {
	
	JTextField line;
	JTextArea text;
	JButton enter;
	
	public Lines(){
		
		setTitle("Lines of text..");
		
		line = new JTextField();
		text = new JTextArea();
		//text.setLineWrap(true);
		enter = new JButton("Enter");
		
		JScrollPane sp = new JScrollPane(text);
		
		//setLayout(new BorderLayout());
		
		
		add(line,BorderLayout.NORTH);
//		add(text,BorderLayout.CENTER);
		add(sp,BorderLayout.CENTER);
		add(enter,BorderLayout.SOUTH);
		
		
		//enter.addActionListener(  e -> text.append(line.getText()) );
		enter.addActionListener(  e -> enter() );
		line.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
				// Here was a mistake done during class:
				//   VK_xxxx codes work for keyPressed and keyReleased
				//   for keyTyped no KeyCode is available.
				//if( e.getKeyCode() == KeyEvent.VK_ENTER ){
				//   Therefore we need to use the keyChar:
				if( e.getKeyChar() == '\n' ){
					enter();
				}
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});
		
		setSize(400,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		// EXTENSIONS
		
		// clean the line and add a newline every time
		
		// perform the same operation when you hit the enter key in you keyboard
	}
	
	private void enter(){
		text.append(line.getText());
		text.append("\n");
		line.setText("");
	}
	
	

	public static void main(String[] args) {
		
		new Lines();

	}

}
