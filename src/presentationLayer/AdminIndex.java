package presentationLayer;

public class AdminIndex {
	public static void adminDisplayControl(ScanIt input) {
		boolean iterator = true;
		while (iterator) {
			System.out.println("\n************************************************************");
			System.out.println("                                              WELCOME ADMIN");
			System.out.println("------------------------------------------------------------");
			DisplayClass.adminIndexDisplay();
			String choice = input.next();
			switch (choice) {
			case "1": {
				AdditionIndex.additionDisplayControl(input);
				break;
			}
			case "2": {
				UpdationIndex.updationDisplayControl(input);
				break;
			}
			case "3": {
				SelectionIndex.selectionDisplayControl(input);;
				break;
			}

			case "4": {
				iterator = false;
			}

			}
		}
	}
}
