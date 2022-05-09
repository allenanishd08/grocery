package services;


public interface ProductUpdaterInterface {
	public void changeProductDetails(String productID, String productName, int productQuantity, double productCost, String categoryID);
}
