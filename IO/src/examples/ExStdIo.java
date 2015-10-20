package examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExStdIo {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
		
		String line = in.readLine(); // read a single line from input
		
		System.out.println("readLine " + line );
		
		// if I want to read multiple lines I must use a scanner
		
		Scanner s = new Scanner (System.in);
		
		line = s.nextLine(); // all the next*() methods are based on regular expression
		
		System.out.println("nextLine " + line );
		
		int i = s.nextInt();
		System.out.println("nextInt" + i);

	}

}
