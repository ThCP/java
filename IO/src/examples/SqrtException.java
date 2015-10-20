package examples;

public class SqrtException {

	public static void main(String[] args) throws SqrException {
		
		double x = -5;

		
//		double y = sqr(x);
//		System.out.println("Sqr=" + y);

		try{
			// nominal case
			double y = sqr(x);
			System.out.println("Sqr=" + y);
			
		}catch(SqrException e){
			// error handling code
			//System.err.println("Sqr of negative value!!");
			System.err.println( e.getMessage() );
		}
		finally{
			System.out.println("Finally: releseing any critical resource...");
		}
		System.out.println("Rast of the program..");

	}
	
	/**
	 * Computes the squared root of a number
	 * @param x number to be rooted
	 * @return the squared root of x
	 * @throws SqrException when x is negative
	 */
	public static double sqr(double x) throws SqrException {
		
//		String s = null;
//		s= s.toLowerCase();  // throw new NullPointerException()
		if(x < 0){
			throw new SqrException(x);
		}
		return Math.sqrt(x);
		
	}

}
