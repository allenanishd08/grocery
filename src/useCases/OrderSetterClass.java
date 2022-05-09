package useCases;


import database.*;
import entities.OrderEntity;
import services.OrderSetterInterface;

public class OrderSetterClass implements OrderSetterInterface{
	public String setOrderDetails(String customerID, String inchargeID, String paymentType)
	{
		String orderID = SelectQueriesClass.getLastInsertedValue("orders");
		OrderEntity newOrder = new OrderEntity(orderID, customerID, inchargeID,paymentType, 0);
		if(InsertQueriesClass.addNewOrderTuple(newOrder))	return orderID;
		return "-";
	}
}
