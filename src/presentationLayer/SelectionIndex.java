package presentationLayer;


import services.*;
import useCases.*;

public class SelectionIndex {
	public static void selectionDisplayControl(ScanIt input) {
		boolean iterator = true;
		while (iterator) {
			System.out.println("\n************************************************************");
			DisplayClass.selectionIndexDisplay();
			String choiceString = input.next();
			String choice = choiceString;
			switch (choice) {
			case "1": {
				SelectionIndex.viewProductDetails(input);
				break;
			}
			case "2": {
				SelectionIndex.viewDemand(input);
				break;
			}
			case "3": {
				SelectionIndex.viewCustomerDetails(input);
				break;
			}
			case "4": {
				SelectionIndex.viewInchargeDetails(input);
				break;
			}
			case "5": {
				SelectionIndex.viewCategoryDetails(input);
				break;
			}
			case "6": {
				SelectionIndex.viewOrderDetails(input,null);
				break;
			}
			case "7": {
				SelectionIndex.viewSpecificOrderDetails(input);
				break;
			}
			case "8": {
				iterator = false;
				break;
			}
			}
		}
	}

	private static void viewCategoryDetails(ScanIt input) {
		CategoryGetterInterface getCategoryDetails = new CategoryGetterClass();
		ViewClass.showCategoryDetails(getCategoryDetails.getCategoryDetails());

	}

	private static void viewProductDetails(ScanIt input) {
		DisplayClass.sortByDisplay("Product");
		String condition = "";
		String sortBy = "ORDER BY product";
		String sortChoice = input.next();
		switch (sortChoice) {
		case "1": {
			sortBy += "ID ";
			break;
		}
		case "2": {
			sortBy += "Name ";
			break;
		}
		}
		System.out.println("\n\tDisplay Products of Specific Category:");
		System.out.println("\t1---> Yes");
		System.out.println("\t2---> No");
		System.out.print("\n\tEnter Your Choice:");
		String categoryChoice = input.next();
		switch (categoryChoice) {
		case "1": {
			System.out.print("\n\tEnter Category ID:");
			String categoryID = input.next();
			condition += "WHERE categoryID = '" + categoryID + "' ";
			break;
		}
		case "2": {
			break;
		}
		}
		ProductGetterInterface getProductDetails = new ProductGetterClass();
		ViewClass.showProductDetails(getProductDetails.getProductDetails(condition, sortBy));

	}

	private static void viewDemand(ScanIt input) {
		String sortBy = "ORDER BY productQuantityAvailable";
		String condition = "WHERE productQuantityAvailable < 10 ";
		ProductGetterInterface getProductDetails = new ProductGetterClass();
		ViewClass.showProductDetails(getProductDetails.getProductDetails(condition, sortBy));

	}

	private static void viewCustomerDetails(ScanIt input) {
		DisplayClass.sortByDisplay("Customer");
		String sortBy = "ORDER BY customer";
		String sortChoice = input.next();
		switch (sortChoice) {
		case "1": {
			sortBy += "ID ";
			break;
		}
		case "2": {
			sortBy += "Name ";
			break;
		}
		}
		CustomerGetterInterface getCustomerDetails = new CustomerGetterClass();
		ViewClass.showCustomerDetails(getCustomerDetails.getCustomerDetails(sortBy));

	}

	private static void viewInchargeDetails(ScanIt input) {
		DisplayClass.sortByDisplay("Incharge");
		String condition = "";
		String sortBy = "ORDER BY incharge";
		String sortChoice = input.next();
		switch (sortChoice) {
		case "1": {
			sortBy += "ID ";
			break;
		}
		case "2": {
			sortBy += "Name ";
			break;
		}
		}
		System.out.println("\n\tDisplay Incharges of Specific Counter:");
		System.out.println("\t1---> Yes");
		System.out.println("\t2---> No");
		System.out.print("\n\tEnter Your Choice:");
		String categoryChoice = input.next();
		switch (categoryChoice) {
		case "1": {
			System.out.print("\n\tEnter Counter ID:");
			String counterID = input.next();
			condition += "WHERE counterID = '" + counterID + "' ";
			break;
		}
		case "2": {

			break;
		}
		}
		InchargeGetterInterface getInchargeDetails = new InchargeGetterClass();
		ViewClass.showInchargeDetails(getInchargeDetails.getInchargeDetails(condition, sortBy));

	}

	public static void viewOrderDetails(ScanIt input, String userName) {
		DisplayClass.orderSortByDisplay();
		String condition = "";
		String sortBy = "ORDER BY ";
		String sortChoice = input.next();
		switch (sortChoice) {
		case "1": {
			sortBy += "customerID ";
			break;
		}
		case "2": {
			sortBy += "inchargeID ";
			break;
		}
		case "3": {
			sortBy += "orderCost ";
			break;
		}
		}
		System.out.println("\n\tDisplay Orders of Specific Customer:");
		System.out.println("\t1---> Yes");
		System.out.println("\t2---> No");
		System.out.print("\n\tEnter Your Choice:");
		String categoryChoice = input.next();
		String customerID = null;
		String inchargeID = null;
		switch (categoryChoice) {
		case "1": {
			System.out.print("\n\tEnter Customer ID:");
			customerID = input.next();
			condition += "WHERE customerID = '" + customerID + "' ";
			break;
		}
		case "2": {

			break;
		}
		}
		if (userName == null) {
			System.out.println("\n\tDisplay Orders of Specific Incharge:");
			System.out.println("\t1---> Yes");
			System.out.println("\t2---> No");
			System.out.print("\n\tEnter Your Choice:");
			categoryChoice = input.next();
			switch (categoryChoice) {
			case "1": {
				System.out.print("\n\tEnter Incharge ID:");
				inchargeID = input.next();
				if (customerID == null)
					condition += "WHERE inchargeID = '" + inchargeID + "' ";
				else
					condition += "AND inchargeID = '" + inchargeID + "' ";
				break;
			}
			case "2": {
				break;
			}
			}
		}
		else
		{
			inchargeID = userName;
		}
		if (inchargeID == null) condition+="";
		else {
			if (customerID == null)
				condition += "WHERE inchargeID = '" + inchargeID + "' ";
			else
				condition += "AND inchargeID = '" + inchargeID + "' ";
		}
		OrderGetterInterface getOrderDetails = new OrderGetterClass();
		ViewClass.showOrderDetails(getOrderDetails.getOrderDetails(condition, sortBy));

	}

	public static void viewSpecificOrderDetails(ScanIt input) {
		String condition = "";
		System.out.print("\n\tEnter Order ID:");
		String orderID = input.next();
		condition += "WHERE ordersID = '" + orderID + "' ";
		OrderGetterInterface getOrderDetails = new OrderGetterClass();
		ViewClass.showOrderDetails(getOrderDetails.getOrderDetails(condition, ""));
		MappedProductGetterInterface getMappedProductDetails = new MappedProductGetterClass();
		ViewClass.showMappedProductDetails(getMappedProductDetails.getMappedProductDetails(orderID));
	}

}
