package presentationLayer;

import database.InsertQueriesClass;
import database.SelectQueriesClass;
import database.UpdateQueriesClass;
import services.OrderSetterInterface;
import useCases.OrderSetterClass;

public class OrderAdditionClass {
	public void setOrder(ScanIt input, String customerID, String inchargeID, String paymentType) {
		int productCount = 1;
		double orderCost  = 0;
		boolean orderInProcess = true;
		OrderSetterInterface newOrderSetter = new OrderSetterClass();
		String orderID = newOrderSetter.setOrderDetails(customerID, inchargeID, paymentType);
		while(orderInProcess)
		{
			System.out.print("Enter the Keywords :");
			input.nextLine();
			String [] productLikeTokens = input.nextLine().split(" ");
			ViewClass.showProductDetails(SelectQueriesClass.getProductDetails(productLikeTokens));					    
			System.out.print("Enter Product ID - " + productCount + " :");
			String productID = input.next();
			System.out.println("Product Name :" + SelectQueriesClass.getProductName(productID));
			System.out.print("Enter the Quantity : ");
			int productQuantity = input.nextInt();
			if(productQuantity < 0 )
			{
				System.out.println("\nInvalid Entry..Try Entering some Numbers..\n");
				return;
			}
			if(SelectQueriesClass.checkProductAvailabilty(productID, productQuantity))
			{
				
				double productCost = SelectQueriesClass.getProductCost(productID);
				double totalProductCost = productCost * productQuantity;
				orderCost += totalProductCost;
				System.out.println("Product Cost :" + productCost );
				System.out.println("Total Product Cost :" + totalProductCost);
				InsertQueriesClass.addNewMapperTuple(orderID, productID, productQuantity);				
			}
			else {
				System.out.println("No Sufficient Quantity..");
			}
			System.out.println("\nDo You Want to Continue with More Products:\n1. Yes\n2. No");
			System.out.print("Enter Your Choice:");
			String choice  = input.next();
			if(choice.equals("2"))
			{
				System.out.println("Total Order Cost:Rs. "+ orderCost);
				double customerRP = SelectQueriesClass.getRP(customerID);
				System.out.println("Do You Want to Use RP with your Payment:Your RP Balance is Rs. " + Math.round(customerRP*100)/100
						+ "\n1. Yes\n2. No");
				System.out.print("Enter Your Choice:");
				choice = input.next();
				if(choice.equals("1"))
				{
					orderCost -= customerRP;
					UpdateQueriesClass.updateRP(customerID);
					System.out.println("New Order Cost:Rs. "+ orderCost);
					
				}
				UpdateQueriesClass.updateCost(orderID,orderCost);
				UpdateQueriesClass.updateRP(customerID, orderCost);
				System.out.println("Order Placed Successfully..Order ID:" + orderID);
				orderInProcess = false;
			}
			++productCount;
	}
}
}
