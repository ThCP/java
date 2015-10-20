package it.polito;

import it.polito.db.DB;
import it.polito.windows.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		// Initialize the class that manage all operations
		// involving the database
		DB db;
		try {
			db = new DB();

			db.OpenConnection();
			
			new MainWindow(db);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
