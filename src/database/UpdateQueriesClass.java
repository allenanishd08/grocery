package database;

import java.sql.PreparedStatement;

import entities.*;

public class UpdateQueriesClass extends DatabaseConnectivity{
	public static void updateCost(String orderID,double totalCost) {
	try {
		PreparedStatement updateStatement = databaseConnector.prepareStatement(updateCostQuery);			
		updateStatement.setDouble(1, totalCost);
		updateStatement.setString(2, orderID);	
		updateStatement.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void updateQuantity(String productID,int productQuantity) {
		try {
			PreparedStatement updateStatement = databaseConnector.prepareStatement(updateQuantityQuery);			
			updateStatement.setInt(1, productQuantity);
			updateStatement.setString(2, productID);
			updateStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public static void updateRP(String customerID,double orderCost) {
		try {
			PreparedStatement updateStatement = databaseConnector.prepareStatement(updateRPQuery);			
			updateStatement.setDouble(1, orderCost);
			updateStatement.setString(2, customerID);
			updateStatement.setString(3, customerID);
			updateStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

	public static boolean updateProductDetails(ProductEntity updateProduct) {
		try {
			PreparedStatement updateStatement = databaseConnector.prepareStatement(updateProductQuery);			
			updateStatement.setString(1, updateProduct.productName);
			updateStatement.setInt(2, updateProduct.productQuantity);
			updateStatement.setDouble(3, updateProduct.productCost);
			updateStatement.setString(4, updateProduct.categoryID);
			updateStatement.setString(5, updateProduct.productID);
			int status = updateStatement.executeUpdate();
			if(status == 1) return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		}
	
	public static boolean updateInchargeDetails(InchargeEntity updateIncharge) {
		try {
			PreparedStatement updateStatement = databaseConnector.prepareStatement(updateInchargeQuery);			
			updateStatement.setString(1, updateIncharge.inchargeName);
			updateStatement.setString(2, updateIncharge.counterID);
			updateStatement.setString(3, updateIncharge.inchargeID);
			int status = updateStatement.executeUpdate();
			if(status == 1) return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		}
	
	public static boolean updateCategoryDetails(CategoryEntity updateCategory) {
		try {
			PreparedStatement updateStatement = databaseConnector.prepareStatement(updateCategoryQuery);			
			updateStatement.setString(1, updateCategory.categoryName);
			updateStatement.setString(2, updateCategory.categoryID);
			int status = updateStatement.executeUpdate();
			if(status == 1) return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		}

	public static void updateRP(String customerID) {
		try {
			PreparedStatement updateStatement = databaseConnector.prepareStatement(updateRPZeroQuery);			
			updateStatement.setString(1, customerID);
			updateStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
