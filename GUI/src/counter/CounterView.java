package counter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CounterView extends JFrame {
	JButton increment;
	JButton decrement;
	JLabel value;
	Counter model;
	
	public CounterView(Counter model){
		this.model = model;
		setTitle("Counter");
		
		setSize(300,300);
		
		
		increment = new JButton("Increment");
		decrement = new JButton("Decrement");
		value = new JLabel("?");
		value.setHorizontalAlignment(JLabel.CENTER);
		
		//setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		
		add(increment,BorderLayout.NORTH);
		add(decrement,BorderLayout.SOUTH);
		add(value,BorderLayout.CENTER);
		
		//value.setText(String.valueOf(model.getValue()));
		update();
		
		//model.addObserver( c -> update() );
		
		model.addObserver( (c,a) -> update());
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	void update(){
		value.setText(String.valueOf(model.getValue()));
	}

}
