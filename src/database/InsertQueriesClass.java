package database;

import java.sql.*;
import entities.*;

public class InsertQueriesClass extends DatabaseConnectivity{
	public static boolean addNewProductTuple(ProductEntity newProduct) {
		try {
			PreparedStatement insertStatement = databaseConnector.prepareStatement(insertProductQuery);
			insertStatement.setString(1, newProduct.productID);
			insertStatement.setString(2, newProduct.productName);
			insertStatement.setInt(3, newProduct.productQuantity);
			insertStatement.setDouble(4, newProduct.productCost);
			insertStatement.setString(5, newProduct.categoryID);
			int status = insertStatement.executeUpdate();
			if(status == 1)return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean addNewInchargeTuple(InchargeEntity newIncharge) {
		try {
			PreparedStatement insertStatement = databaseConnector.prepareStatement(insertInchargeQuery);
			PreparedStatement insertUserID = databaseConnector.prepareStatement(insertSignupQuery);
			insertStatement.setString(1, newIncharge.inchargeID);
			insertStatement.setString(2, newIncharge.inchargeName);
			insertStatement.setString(3, newIncharge.counterID);
			int status = insertStatement.executeUpdate();
			insertUserID.setString(1, newIncharge.inchargeID);
			insertUserID.setString(2, newIncharge.inchargeID);
			status += insertUserID.executeUpdate();
			if(status == 2)return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean addNewCustomerTuple(CustomerEntity newCustomer) {
		try {
			PreparedStatement insertStatement = databaseConnector.prepareStatement(insertCustomerQuery);
			insertStatement.setString(1, newCustomer.customerID);
			insertStatement.setString(2, newCustomer.customerName);
			insertStatement.setDouble(3, 0);
			int status = insertStatement.executeUpdate();
			if(status == 1)return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean addNewCategoryTuple(CategoryEntity newCategory) {
		try {
			PreparedStatement insertStatement = databaseConnector.prepareStatement(insertCategoryQuery);
			insertStatement.setString(1, newCategory.categoryID);
			insertStatement.setString(2, newCategory.categoryName);
			int status = insertStatement.executeUpdate();
			if(status == 1)return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
		
		
		public static boolean addNewOrderTuple(OrderEntity newOrder) {
			try {
				PreparedStatement insertStatement = databaseConnector.prepareStatement(insertOrderQuery);
				insertStatement.setString(1, newOrder.orderID);
				insertStatement.setString(2, newOrder.customerID);
				insertStatement.setString(3, newOrder.inchargeID);
				insertStatement.setString(4, newOrder.paymentType);
				insertStatement.setDouble(5, newOrder.orderCost);
				int status = insertStatement.executeUpdate();
				if(status == 1) return true;				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
	public static void addNewMapperTuple(String orderID, String productID, int productQuantity ) {
		try {
			PreparedStatement insertStatement = databaseConnector.prepareStatement(insertMapperQuery);
			insertStatement.setString(1, productID);
			insertStatement.setString(2, orderID);
			insertStatement.setInt(3, productQuantity);
			insertStatement.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
