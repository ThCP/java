package counter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class CounterController implements ActionListener {
	
	private CounterView view;
	private Counter model;
	
	public CounterController(Counter m, CounterView v){
		view = v;
		model = m;
		
//		view.increment.addActionListener(this);
//		view.decrement.addActionListener(this);
		
		view.increment.addActionListener( a -> doIncrement() );
		view.decrement.addActionListener( a -> doDecrement() );
	}
	
	public void doIncrement(){
		model.increment();
		//view.update();
		model.notifyObservers();
	}
	
	public void doDecrement() {
		try {
			model.decrement();
			//view.update();
			model.notifyObservers();
		} catch (Exception e) {
			//System.err.println("Error: " + e.getMessage());
			JOptionPane.showMessageDialog(view, e.getMessage(),
											"Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Event: " + e);
		String cmd = e.getActionCommand();
		
		if(cmd.equals("Increment")){
			doIncrement();
		}
		if(cmd.equals("Decrement")){
			doDecrement();
		}
		
	}

}
