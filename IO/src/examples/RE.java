package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE {

	public static void main(String[] args) {
		
		Pattern intPattern = Pattern.compile("[+-]?[1-9][0-9]*|0");
		Pattern floatPattern = Pattern.compile("([+-]?)([1-9][0-9]*|0)\\.([0-9]+)");

		System.out.println("Float RE = " + floatPattern.toString());
		
		Matcher m = intPattern.matcher("0");
		
		if (m.matches()) {
			System.out.println("Matched!");
		} else {
			System.out.println("No match");
		}
		
		m = floatPattern.matcher("3.141");
		if (m.matches()) {
			System.out.println("Matched!");
			String sign = m.group(1);
			String intPart = m.group(2);
			String decPart = m.group(3);
			
			System.out.println(sign + intPart + "." + decPart);
		} else {
			System.out.println("No match");
		}
		
		m = floatPattern.matcher("abc 1.234 ejeifj.");
		
		if (m.find()) {
			System.out.println("Found a floating point number");
			System.out.println("found: " + m.group ());
		} else {
			System.out.println("No match");
		}
		
		// CSV analysis
		String line = "\"John,Albert\",Smith,1234"; // Example of a CSV line
					// "John,""Albert""",Smith,1234
		// If I invoke find() several times it will start from the last match
		
		// \"John,Albert\" is a single entry in a CSV file
		//								 V---1--V	V---2---V
		Pattern csv = Pattern.compile("\"([^\"]*)\"|([^,\"]+)");
		Matcher csvMatcher = csv.matcher(line);
		while (csvMatcher.find()){
			System.out.println("Element: " + csvMatcher.group());
			String content = csvMatcher.group(1);
			if (content==null){
				content = m.group(2);
			}
			System.out.println("Element = " + content);
		}
		
		
		
		
	}

}
