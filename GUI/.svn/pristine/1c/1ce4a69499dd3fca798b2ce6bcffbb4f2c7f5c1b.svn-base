package counter;

import junit.framework.TestCase;

public class TEstCounter extends TestCase {
	private Counter counter;
	private CounterView view;
	private CounterController ctrl;
	
	public void setUp(){
		 counter = new Counter();
		 view = new CounterView(counter);
		 ctrl = new CounterController(counter,view);
	}
	
	public void tearDown(){
		view.dispose();
	}

	public void testInitial(){		
//		Counter counter = new Counter();
//		CounterView view = new CounterView(counter);
//		try{
//			CounterController ctrl = new CounterController(counter,view);

			int value = Integer.parseInt(view.value.getText());
		
			assertEquals(0,value);
//		}finally{
//			view.dispose();
//		}
	}
	
	public void testIncrement(){		
		view.increment.doClick();
		int value = Integer.parseInt(view.value.getText());
		
		assertEquals(1,value);
	}

	
	public void testIncrementAndDecrement(){
		
		for(int i=0; i<10; ++i)
			view.increment.doClick();
		for(int i=0; i<10; ++i)
			view.decrement.doClick();
		
		int value = Integer.parseInt(view.value.getText());
		
		assertEquals(0,value);
	}

}
