package useCases;

import database.UpdateQueriesClass;
import entities.ProductEntity;
import services.ProductUpdaterInterface;

public class ProductUpdaterClass implements ProductUpdaterInterface{
	public void changeProductDetails(String productID, String productName, int productQuantity, double productCost, String categoryID)
	{
		ProductEntity updateProduct = new ProductEntity(productID, productName, productQuantity, productCost,categoryID);
		boolean status = UpdateQueriesClass.updateProductDetails(updateProduct);
		if(status) System.out.println("\nProduct Details Updated Successfully...");
		else System.out.println("\nUpdation Failed..");
	}
}
