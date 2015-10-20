package examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderExamples {

	private static final int EOF = -1;

	public static void main(String[] args) throws IOException {
		
		Reader r = new FileReader("input.txt");
		
		int element = r.read();
		// element : 0x00 0x00 0x00 0x40
		//                     ^--------^
		
		char ch = (char) element;
		// ch: 0x00 0x40
		
		// ... at the end of the file:
		// element = 0xFF 0xFF 0xFF 0xFF

		
		while( element != EOF ){
			System.out.print(ch);
			element = r.read();
			ch = (char) element;
		}
		
		r.close();
		
		r = new FileReader("input.txt");
		
		char[] buffer = new char[2048];
		
		int nChar=0;
		
		while( true ){
			nChar = r.read(buffer);
			if(nChar==EOF) break;
			String s = new String(buffer,0,nChar);
			System.out.println(s);
		}
		r.close();
		
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		String line;
		while( (line=br.readLine()) != null ){
			System.out.println(line);
		}
		
		
		
	}

}
