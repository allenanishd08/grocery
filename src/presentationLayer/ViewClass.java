package presentationLayer;

import java.util.ArrayList;

import entities.*;

public class ViewClass {
	public static void showCategoryDetails(ArrayList<CategoryEntity> categoryList)
	{
		System.out.println("\n----------------------------------------------------------------");
		System.out.println("|   Category ID    |              Category Name                |");
		System.out.println("----------------------------------------------------------------");
		for (CategoryEntity categoryEntity : categoryList) {
			System.out.println("|      " + DisplayClass.formatString(categoryEntity.categoryID,7) + "     |  " + DisplayClass.formatString(categoryEntity.categoryName,39) + "  |");
		}
		System.out.println("----------------------------------------------------------------\n");
	}
	
	public static void showProductDetails(ArrayList<ProductEntity> productList)
	{
		System.out.println("\n----------------------------------------------------------------");
		System.out.println("| Product ID |    Product Name    |Quantity| Cost | CategoryID |");
		System.out.println("----------------------------------------------------------------");
		for (ProductEntity productEntity : productList) {
			System.out.println("|    " + productEntity.productID + "    | " + DisplayClass.formatString(productEntity.productName,18) + " |   " + DisplayClass.formatString(Integer.toString(productEntity.productQuantity),3) + "  |" + DisplayClass.formatString(Double.toString(productEntity.productCost),5) + "  |    " + productEntity.categoryID + "    | ");
		}
		System.out.println("----------------------------------------------------------------\n");
	}
	
	public static void showCustomerDetails(ArrayList<CustomerEntity> customerList)
	{
		System.out.println("\n----------------------------------------------------------------");
		System.out.println("| Customer ID |  Customer Name  |   Payments By  | Customer RP |");
		System.out.println("|             |                 |  Cash  | Card  |             |");
		System.out.println("----------------------------------------------------------------");
		for (CustomerEntity customerEntity : customerList) {
			System.out.println("|    " + customerEntity.customerID + "     | " + DisplayClass.formatString(customerEntity.customerName,15) + "  | " + DisplayClass.formatString(Integer.toString(customerEntity.ordersByCash),5) + " | " + DisplayClass.formatString(Integer.toString(customerEntity.ordersByCard),5) + " | " + DisplayClass.formatString(Double.toString(customerEntity.customerRP),9) + "   |");
		}
		System.out.println("----------------------------------------------------------------\n");
	}
	
	public static void showInchargeDetails(ArrayList<InchargeEntity> inchargeList)
	{
		System.out.println("\n----------------------------------------------------------------");
		System.out.println("| Incharge ID |           Incharge Name          | Counter ID  |");
		System.out.println("----------------------------------------------------------------");
		for (InchargeEntity inchargeEntity : inchargeList) {
			System.out.println("|    " + inchargeEntity.inchargeID + "     | " + DisplayClass.formatString(inchargeEntity.inchargeName,31) + "  | " + DisplayClass.formatString(inchargeEntity.counterID,9) + "   |");
		}
		System.out.println("----------------------------------------------------------------\n");
	}
	
	public static void showOrderDetails(ArrayList<OrderEntity> orderList)
	{
		System.out.println("\n----------------------------------------------------------------");
		System.out.println("|Order ID|Customer ID | Incharge ID | Payment via | Order Cost |");
		System.out.println("----------------------------------------------------------------");
		for (OrderEntity orderEntity : orderList) {
			System.out.println("|  " + orderEntity.orderID + "  |    " + orderEntity.customerID + "    |    " + orderEntity.inchargeID + "     |     " + orderEntity.paymentType + "    |  " + DisplayClass.formatString(Double.toString(orderEntity.orderCost),9) + " |");
		}
		System.out.println("----------------------------------------------------------------\n");
	}
	
	public static void showMappedProductDetails(ArrayList<MappedProductEntity> mappedProductList)
	{
		System.out.println("\n----------------------------------------------------------------");
		System.out.println("| Product ID |    Product Name    |Quantity| Cost | Total Cost |");
		System.out.println("----------------------------------------------------------------");
		for (MappedProductEntity mappedProductEntity : mappedProductList) {
			System.out.println("|    " + mappedProductEntity.productID + "    | " + DisplayClass.formatString(mappedProductEntity.productName,18) + " |   " + DisplayClass.formatString(Integer.toString(mappedProductEntity.productQuantity),3) + "  |" + DisplayClass.formatString(Double.toString(mappedProductEntity.productCost),5) + "  | " + DisplayClass.formatString(Double.toString(mappedProductEntity.totalCost),9) + " | ");
		}
		System.out.println("----------------------------------------------------------------\n");
	}
}
