package entities;

public class CustomerEntity {
	public String customerID;
	public String customerName;
	public double customerRP;
	public int ordersByCash;
	public int ordersByCard;
	public CustomerEntity(String customerID,String customerName){
		this.customerID = customerID;
		this.customerName = customerName;
	}
	public CustomerEntity(String customerID,String customerName, double customerRP) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerRP = customerRP;
	}
	public CustomerEntity(String customerID,String customerName, double customerRP, int ordersByCash, int ordersByCard) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerRP = customerRP;
		this.ordersByCash = ordersByCash;
		this.ordersByCard = ordersByCard;
	}
}
