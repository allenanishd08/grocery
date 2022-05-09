package useCases;

import database.InsertQueriesClass;
import database.SelectQueriesClass;
import entities.ProductEntity;
import services.ProductSetterInterface;

public class ProductSetterClass implements ProductSetterInterface{
	public String setProductDetails(String productName, int productQuantity, double productCost, String categoryID) {
		String productID = SelectQueriesClass.getLastInsertedValue("product");
		ProductEntity newProduct = new ProductEntity(productID,productName, productQuantity, productCost, categoryID);
		if(InsertQueriesClass.addNewProductTuple(newProduct)) return productID;
		return "-";
	}
}
