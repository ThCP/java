package thread;

public class ExRunnables {
	
	

	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread(new Runnable(){
			public void run(){
				enumerate('a');
			}
		});
		// OR
		Thread u = new Thread(()->enumerate('0'));
		
		t.start();
		u.start();
		
		enumerate('A');
		
		t.join();
		System.out.println("\nThread t terminated.");

		u.join();
		System.out.println("\nThread u terminated.");
	}
	
	public static void enumerate(char base){
		for(int i=0; i<10; ++i){
			System.out.print((char)(base+i)+" ");
		}
	}

}
