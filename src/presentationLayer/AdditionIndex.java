package presentationLayer;


import services.*;
import useCases.*;

public class AdditionIndex {

	public static void additionDisplayControl(ScanIt input) {
		boolean iterator = true;
		while (iterator) {
			System.out.println("\n************************************************************");
			DisplayClass.additionIndexDisplay();
			String choiceString = input.next();
			String choice = choiceString;
			switch (choice) {
			case "1": {
				AdditionIndex.addProductDetails(input);
				break;
			}
			case "2": {
				AdditionIndex.addInchargeDetails(input);
				break;
			}
			case "3": {
				AdditionIndex.addCustomerDetails(input);
				break;
			}
			case "4": {
				AdditionIndex.addCategoryDetails(input);
				break;
			}
			case "5": {
				iterator = false;
			}
			}
		}
	}

	public static void addProductDetails(ScanIt input) {
		System.out.println("\n************************************************************");
		System.out.println("\t\tADD A NEW PRODUCT..\n");
		System.out.print("Enter the Product Name\t\t:");
		input.nextLine();
		String productName = input.nextLine();
		System.out.print("Enter the Product Quantity\t:");
		int productQuantity = input.nextInt();
		if(productQuantity < 0 )
		{
			System.out.println("\nInvalid Entry..Try Entering some Numbers..\n");
			return;
		}
		System.out.print("Enter the Product Cost\t\t:");
		double productCost = input.nextDouble();
		if(productCost < 0 )
		{
			System.out.println("\nInvalid Entry..Try Entering some Numbers..\n");
			return;
		}
		CategoryGetterInterface getCategoryDetails = new CategoryGetterClass();
		ViewClass.showCategoryDetails(getCategoryDetails.getCategoryDetails());
		System.out.print("Enter the Category ID\t\t:");
		String categoryID = input.next();
		ProductSetterInterface newProductSetter = new ProductSetterClass();
		String productID = newProductSetter.setProductDetails(productName, productQuantity, productCost, categoryID);
		System.out.println("\nProduct Added Successfully..Product ID is: " + productID);

	}

	public static void addCustomerDetails(ScanIt input) {
		System.out.println("\n************************************************************");
		System.out.println("\t\tADD A NEW CUSTOMER..\n");
		System.out.print("Enter the Customer Name\t:");
		input.nextLine();
		String customerName = input.nextLine();
		CustomerSetterInterface newCustomerSetter = new CustomerSetterClass();
		String customerID = newCustomerSetter.setCustomerDetails(customerName);
		System.out.println("\nCustomer Added Successfully..Customer ID is: " + customerID);
	}

	public static void addInchargeDetails(ScanIt input) {
		System.out.println("\n************************************************************");
		System.out.println("\t\tADD A NEW INCHARGE..\n");
		System.out.print("Enter the Incharge Name\t\t:");
		input.nextLine();
		String inchargeName = input.nextLine();
		System.out.print("Enter the Counter ID Assigned\t:");
		String counterID = input.next();
		InchargeSetterInterface newInchargeSetter = new InchargeSetterClass();
		String inchargeID = newInchargeSetter.setInchargeDetails(inchargeName, counterID);
		System.out.println(
				"\nIncharge Added Successfully..Incharge ID is: " + inchargeID + " and Password is:" + inchargeID);
	}

	public static void addCategoryDetails(ScanIt input) {
		System.out.println("\n************************************************************");
		System.out.println("\t\tADD A NEW CATEGORY..\n");
		System.out.print("Enter the Category Name:");
		input.nextLine();
		String categoryName = input.nextLine();
		CategorySetterInterface newCategorySetter = new CategorySetterClass();
		String categoryID = newCategorySetter.setCategoryDetails(categoryName);
		System.out.println("\nCategory Added Successfully..Category ID is: " + categoryID);
	}

	public static void addOrderDetails(ScanIt input, String userName) {
		System.out.println("\n************************************************************");
		System.out.println("\t\tADD A NEW ORDER..\n");
		System.out.print("Enter the Customer ID:");
		String customerID = input.next();
		System.out.println("Enter the Mode of Payment:\n\t1---> Cash \n\t2---> Card");
		System.out.print("Enter Your Choice:");
		String paymentType = input.next();
		switch (paymentType) {
		case "1": {			
			paymentType = "Cash";
			break;
		}
		case "2": {			
			paymentType = "Card";
			break;
		}
		default:
			System.out.println("n\\tInvalid Choice..");
			return;
		}
		OrderAdditionClass newOrder = new OrderAdditionClass();
		newOrder.setOrder(input, customerID, userName, paymentType);
	}
}
