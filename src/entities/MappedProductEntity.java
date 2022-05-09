package entities;

public class MappedProductEntity {
	public String productID;
	public String productName;
	public int productQuantity;
	public double productCost;
	public double totalCost;
	public MappedProductEntity(String productID, String productName,int productQuantity,double productCost, double totalCost ){
		this.productID = productID;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productCost = productCost;
		this.totalCost = totalCost;
		
	}
}
