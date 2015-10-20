package examples;

import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PriceList {

	public static void main(String[] args) {
		
		try {
			readPrices("prices.txt");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} catch(NumberFormatException e){
			System.out.println("Wronr price number: " + e.getMessage());
		}

	}
	
	static List<Item> readPrices(String fileName) throws IOException{
		// String fileName = "prices.txt";
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		LinkedList<Item> res = new LinkedList<Item>();
//		try{
			String line;
			while ( (line=br.readLine())!=null ){
				
				try{
					String[] elements = line.split(";");
					
//					String name = elements[0];
//					
//					double price = Double.parseDouble(elements[1]);
//					
//			//		System.out.println(name + ": " + price);
//					
//					Item i = new Item(name,price);
//					res.add(i);
					
					res.add(Item.newItem(elements));
					
				}catch(NumberFormatException e){
					System.out.println("Price format error " + e.getMessage());
				}

			}
//		}catch(NumberFormatException e){
//			System.out.println("Price format error" + e.getMessage());
//		}
		br.close();
		return res;
	}

	static List<Item> readPricesStream() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("prices.txt"));
		
		return
		br.lines()   // Stream<String>
			.map( line -> {
					Scanner s = new Scanner (line);
					s.useDelimiter(";"); // this is a regular expression
				
//					Pattern p = Pattern.compile("(?<=^|;)[\t]*([^;]*)[\t]*(?=;|$)");
//					Matcher m = p.matcher(line);
//					m.find();
//					String name = m.group(1);
//					double price = Double.parseDouble(m.group(1));
//					return new Item(name,price);

					String name = s.next();
					double price = s.nextDouble(); // this does not recognize a double if there are white spaces before or after the characterz
					return new Item(name,price);

					
			//line -> line.split(";")) // Stream<String[]>
//			.forEach( elements -> {
//				// String[] elements = line.split(";"); // equivalent to map( ... )
//				String name = elements[0];
//				double price = Double.parseDouble(elements[1]);
//				System.out.println(name + ": " + price);
//			}
//			)
			}
			)
			.collect(Collectors.toList())
			;
			
		
	}
}


