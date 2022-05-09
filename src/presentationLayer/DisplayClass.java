package presentationLayer;

public class DisplayClass {
	public static void pageIndexDisplay() {
		System.out.println("\tPAGE INDEX");
		System.out.println("\t1----> Login..");
		System.out.println("\t2----> Exit..");
		System.out.print("\nEnter Your Choice:");
}
	public static void adminIndexDisplay() {
		System.out.println("\t\tADMIN INDEX");
		System.out.println("\t1----> Add a New Entity..");
		System.out.println("\t2----> Update an existing Entity..");
		System.out.println("\t3----> View Entities..");
		System.out.println("\t4----> Logout..");
		System.out.print("\nEnter Your Choice:");
}
	public static void inchargeIndexDisplay() {
		System.out.println("\t\tINCHARGE INDEX");
		System.out.println("\t1----> Change Password");
		System.out.println("\t2----> Add a New Customer");
		System.out.println("\t3----> Add a New Order");
		System.out.println("\t4----> View Order History");	
		System.out.println("\t5----> Logout..");
		System.out.print("\nEnter Your Choice:");
}
	public static void additionIndexDisplay() {
		System.out.println("\t\tADDITION INDEX");
		System.out.println("\t1----> Add a New Product..");
		System.out.println("\t2----> Add a New Incharge..");
		System.out.println("\t3----> Add a New Customer..");
		System.out.println("\t4----> Add a New Product Category..");
		System.out.println("\t5----> Back to Home..");
		System.out.print("\nEnter Your Choice:");
	}
	
	public static void updationIndexDisplay() {
		System.out.println("\t\tUPDATION INDEX");
		System.out.println("\t1----> Update an existing Product..");
		System.out.println("\t2----> Update an existing Incharge..");
		System.out.println("\t3----> Update an existing Product Category..");
		System.out.println("\t4----> Back to Home..");
		System.out.print("\nEnter Your Choice:");
	}
	
	public static void selectionIndexDisplay() {
		System.out.println("\t\tSELECTION INDEX");
		System.out.println("\t1----> View All Products..");
		System.out.println("\t2----> View Demand..");
		System.out.println("\t3----> View All Customers..");
		System.out.println("\t4----> View All Incharges..");
		System.out.println("\t5----> View All Product Types..");
		System.out.println("\t6----> View All Orders..");
		System.out.println("\t7----> View Specific Order..");
		System.out.println("\t8----> Back to Home..");
		System.out.print("\nEnter Your Choice:");
	}
	public static void sortByDisplay(String tableName) {
		System.out.println("\t\t\tSORT BY");
		System.out.println("\t\t1----> "+ tableName+" ID..");
		System.out.println("\t\t2----> "+ tableName+" Name..");	
		System.out.print("\n\tEnter Your Choice:");
	}
	
	public static void orderSortByDisplay() {
		System.out.println("\t\t\tSORT BY");
		System.out.println("\t\t1----> Customer ID..");
		System.out.println("\t\t2----> Incharge ID..");	
		System.out.println("\t\t3----> Order Cost..");
		System.out.print("\n\tEnter Your Choice:");
	}
	
	public static String formatString(String string, int padding)
	{
		return String.format("%-"+ padding + "s", string);
	}
	
	
}
