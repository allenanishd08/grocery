package presentationLayer;

import database.*;

public class PageIndex {
	public static void main(String[] args) {
		ScanIt input = new ScanIt();
		DatabaseConnectivity.databaseConnectingMethod();
		CreationClass.createSchema();
		System.out.println("\t\t------------------------");
		System.out.println("\t\t|GROCERY BILLING SYSTEM|");
		System.out.println("\t\t------------------------");
		
		boolean iterator = true;
		while (iterator) {
			System.out.println("\n************************************************************\n");
			DisplayClass.pageIndexDisplay();
			String choice = input.next();
			switch (choice) {
			case "1": {
				LoginIndex.loginDisplay(input);
				break;
			}
			case "2": {
				iterator = false;
				break;
			}
			}
		}
		DatabaseConnectivity.databaseConnectionCloseMethod();

	}
}
