package thread;

public class ExThreads {
	
	static class MyThread extends Thread {
		@Override
		public void run(){
//			for(int i=0; i<10; ++i){
//				System.out.print( i + " ");
//			}
			ExThreads.enumerate('a');
		}
	}

	public static void main(String[] args) {
		
		MyThread t = new MyThread();
		t.start();
		
//		for(int i=0; i<10; ++i){
//			System.out.print((char)('A'+i)+" ");
//		}
		enumerate('A');

	}
	
	public static void enumerate(char base){
		for(int i=0; i<10; ++i){
			System.out.print((char)(base+i)+" ");
		}
	}

}
