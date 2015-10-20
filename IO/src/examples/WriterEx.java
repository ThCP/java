package examples;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterEx {

	public static void main(String[] args) throws IOException {
		
		try(Writer w = new FileWriter("output.txt")){ // eventually w will be closed 
		
//			Writer w = new FileWriter("output.txt");
			w.write("Hello world!");
			w.flush();
		
		}
	}

}
