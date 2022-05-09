package entities;

public class ProductEntity {
	public String productID;
	public String productName;
	public int productQuantity;
	public double productCost;
	public String categoryID;
	public ProductEntity(String productID,String productName, int productQuantity, double productCost, String productTypeID)
	{
		this.productID = productID;
		this.productName = productName;
		this.productCost = productCost;
		this.productQuantity = productQuantity;
		this.categoryID = productTypeID;
	}

}
