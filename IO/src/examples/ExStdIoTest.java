package examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

public class ExStdIoTest extends TestCase {
	
	public void testReadPricesFileNotFound() throws IOException { // if I get an unexpected exception I propagate it 
																  // JUnit catches it and fails the test (returns error)
																  // In this case exceptions should be treated as errors
		String fileName = "NONEXistingFileName.txt";
		File nonExisting = new File (fileName);
		
		if ( nonExisting.exists() ){
			nonExisting.delete();
		}
		try{
			
			PriceList.readPrices(fileName); // I am testing whether this throws an exception
			fail ("The file is not existing.");
		
		} catch (FileNotFoundException e) { //  I could get an exception different from FileNotFoundException
			// OK
			assertTrue(true);
		} 
//			catch (IOException e){ // the order of catch blocks is important, first the more specific then the more generic
//			fail ("Unexpected exception type:" + e); // JUnit returns failure (different from error)
//		}
	}
	
	
	public void testReadPrices() throws IOException {
		
		File tmp=null;
		
		try {
		
		tmp = File.createTempFile("data", ".txt"); // I create a temporary file for this test
		String content = "Bread;1_2\nOil;3.5\nRice;2.1\nTea;6.7";
		
		FileWriter w = new FileWriter(tmp);
		w.write(content);
		w.close();
		
		List<Item> items = PriceList.readPrices(tmp.getAbsolutePath());

		assertEquals(4,items.size()); // I check whether I read the correct number of items. If the test file is modified
									  // the test fails, so I should create files as resources or I should generate them
									  // right before the test.
		} finally {
			if (tmp!=null) tmp.delete();
		}
	}
}	
