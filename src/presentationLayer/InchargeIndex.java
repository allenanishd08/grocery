package presentationLayer;

import database.SelectQueriesClass;

public class InchargeIndex {
	public static void inchargeDisplayControl(ScanIt input, String userName) {
		boolean iterator = true;
		while (iterator) {
			System.out.println("\n************************************************************");
			System.out.println("                                           WELCOME "
					+ SelectQueriesClass.getInchargeName(userName));
			System.out.println("--------------------------------------------------------------");
			DisplayClass.inchargeIndexDisplay();
			String choiceString = input.next();
			String choice = choiceString;
			switch (choice) {
			case "1": {
				UpdationIndex.updatePassword(input, userName);
				break;
			}
			case "2": {
				AdditionIndex.addCustomerDetails(input);
				break;
			}
			case "3": {
				AdditionIndex.addOrderDetails(input, userName);
				break;
			}
			case "4": {
				SelectionIndex.viewOrderDetails(input, userName);
				break;
			}
			case "5": {
				iterator = false;
				break;
			}

			}
		}
	}
}
