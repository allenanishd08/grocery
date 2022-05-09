package entities;

public class OrderEntity {
	public String orderID;
	public String customerID;
	public String inchargeID;
	public String paymentType;
	public double orderCost;
	public OrderEntity(String orderID, String customerID,String inchargeID,String paymentType, double orderCost ){
		this.orderID = orderID;
		this.customerID = customerID;
		this.inchargeID = inchargeID;
		this.paymentType = paymentType;
		this.orderCost = orderCost;
		
	}
}
