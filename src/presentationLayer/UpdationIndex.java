package presentationLayer;

import services.*;
import useCases.*;


public class UpdationIndex {
	public static void updationDisplayControl(ScanIt input) {
		boolean iterator = true;
		while (iterator) {
			System.out.println("\n************************************************************");
			DisplayClass.updationIndexDisplay();
			String choice = input.next();
			switch (choice) {
			case "1": {
				UpdationIndex.updateProductDetails(input);
				break;
			}
			case "2": {
				UpdationIndex.updateInchargeDetails(input);;
				break;
			}
			case "3": {
				UpdationIndex.updateCategoryDetails(input);;
				break;
			}
			case "4": {
				iterator = false;
			}
			}
		}
	}
	
	public static void updatePassword(ScanIt input, String userName) {
		System.out.println("\n************************************************************");
		System.out.println("\t\tCHANGE PASSWORD..\n");
		System.out.println("Enter New Password:");
		String newPassword = input.next();
		System.out.println("Confirm New Password:");
		String confirmPassword = input.next();
		if(newPassword.equals(confirmPassword))
		{
			PasswordChangerClass.changePasswordMethod(userName, newPassword);
		}
		else System.out.println("\n Passwords Doesn't Match..");
			
		
	}
	
	public static void updateProductDetails(ScanIt input)
	{
		System.out.println("\n************************************************************");
		System.out.println("\t\tUPDATE AN EXISTING PRODUCT..\n");
		System.out.print("Enter Product ID to Update\t:");
		String productID = input.next();
		System.out.print("Enter New Product Name\t\t:");
		input.nextLine();
		String newProductName = input.nextLine();
		System.out.print("Enter New Product Quantity\t:");
		int newProductQuantity = input.nextInt();
		System.out.print("Enter New Product Cost\t\t:");
		double newProductCost = input.nextDouble();
		CategoryGetterInterface getCategoryDetails = new CategoryGetterClass();
		ViewClass.showCategoryDetails(getCategoryDetails.getCategoryDetails());
		System.out.print("Enter New Category ID\t\t:");
		String categoryID = input.next();
		ProductUpdaterInterface newProductUpdator = new ProductUpdaterClass();
		newProductUpdator.changeProductDetails(productID, newProductName, newProductQuantity, newProductCost, categoryID);
		
	}
	
	public static void updateInchargeDetails(ScanIt input)
	{
		System.out.println("\n************************************************************");
		System.out.println("\t\tUPDATE AN EXISTING INCHARGE..\n");
		System.out.print("Enter Incharge ID to Update\t:");
		String inchargeID = input.next();
		System.out.print("Enter New Incharge Name\t\t:");
		input.nextLine();
		String newInchargeName = input.nextLine();
		System.out.print("Enter New Counter ID to Assign\t:");
		String newCounterID = input.next();
		InchargeUpdaterInterface newInchargeUpdator = new InchargeUpdaterClass();
		newInchargeUpdator.changeInchargeDetails(inchargeID, newInchargeName, newCounterID);
	}
	
	public static void updateCategoryDetails(ScanIt input)
	{
		System.out.println("\n************************************************************");
		System.out.println("\t\tUPDATE AN EXISTING CATEGORY..\n");
		System.out.print("Enter Category ID to Update\t:");
		String categoryID = input.next();
		System.out.print("Enter New Category Name\t\t:");
		input.nextLine();
		String newCategoryName = input.nextLine();
		CategoryUpdaterInterface newCategoryUpdator = new CategoryUpdaterClass();
		newCategoryUpdator.changeCategoryDetails(categoryID, newCategoryName);
	}
}
