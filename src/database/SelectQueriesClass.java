package database;

import java.sql.*;
import java.util.ArrayList;

import entities.*;

public class SelectQueriesClass extends DatabaseConnectivity{
	public static ArrayList<CategoryEntity> getCategoryDetails() {
		ArrayList<CategoryEntity> categoryArrayList = new ArrayList<>();
		try {
			Statement selectStatement = databaseConnector.createStatement();
			ResultSet resultSet = selectStatement.executeQuery(selectAllQuery+ "category;" );
			while(resultSet.next()) {
				CategoryEntity getCategoryEntity = new CategoryEntity(resultSet.getString(1),resultSet.getString(2));
				categoryArrayList.add(getCategoryEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryArrayList;
	}
	
	public static ArrayList<ProductEntity> getProductDetails(String condition, String sortBY) {
		ArrayList<ProductEntity> productArrayList = new ArrayList<>();
		try {
			Statement selectStatement = databaseConnector.createStatement();
			ResultSet resultSet = selectStatement.executeQuery(selectAllQuery+ "product " + condition + sortBY + ";" );
			while(resultSet.next()) {
				ProductEntity getProductEntity = new ProductEntity(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getDouble(4),resultSet.getString(5));
				productArrayList.add(getProductEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productArrayList;
	}
	
	public static ArrayList<ProductEntity> getProductDetails(String [] tokens) {
		ArrayList<ProductEntity> productArrayList = new ArrayList<>();
		String condition = "WHERE productName LIKE '%";
		try {
			Statement selectStatement = databaseConnector.createStatement();
			for(String word:tokens)
			{
				condition += word + "%";
			}
			ResultSet resultSet = selectStatement.executeQuery(selectAllQuery+ "product " + condition + "';" );
			while(resultSet.next()) {
				ProductEntity getProductEntity = new ProductEntity(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getDouble(4),resultSet.getString(5));
				productArrayList.add(getProductEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productArrayList;
	}
	
	
	public static ArrayList<CustomerEntity> getCustomerDetails(String sortBY) {
		ArrayList<CustomerEntity> customerArrayList = new ArrayList<>();
		try {
			Statement selectStatement = databaseConnector.createStatement();
			System.out.println(selectCustomerQuery + sortBY + ";");
			ResultSet resultSet = selectStatement.executeQuery(selectCustomerQuery + sortBY + ";");
			while(resultSet.next()) {
				CustomerEntity getCustomerEntity = new CustomerEntity(resultSet.getString(1),resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getInt(5));
				customerArrayList.add(getCustomerEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerArrayList;
	}
	

	public static ArrayList<InchargeEntity> getInchargeDetails(String condition,String sortBY) {
		ArrayList<InchargeEntity> inchargeArrayList = new ArrayList<>();
		try {
			Statement selectStatement = databaseConnector.createStatement();
			ResultSet resultSet = selectStatement.executeQuery(selectAllQuery +"incharge "  + condition + sortBY+ ";");
			while(resultSet.next()) {
				InchargeEntity getInchargeEntity = new InchargeEntity(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3));
				inchargeArrayList.add(getInchargeEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inchargeArrayList;
	}
	
	
	public static ArrayList<OrderEntity> getOrderDetails(String condition,String sortBY) {
		ArrayList<OrderEntity> orderArrayList = new ArrayList<>();
		try {
			Statement selectStatement = databaseConnector.createStatement();
			ResultSet resultSet = selectStatement.executeQuery(selectAllQuery +"orders "  + condition + sortBY+ ";");
			while(resultSet.next()) {
				OrderEntity getOrderEntity = new OrderEntity(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDouble(5));
				orderArrayList.add(getOrderEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderArrayList;
	}
		
	public static ArrayList<MappedProductEntity> getMappedProductDetails(String orderID) {
		ArrayList<MappedProductEntity> mappedProductArrayList = new ArrayList<>();
		try {
			Statement selectStatement = databaseConnector.createStatement();
			ResultSet resultSet = selectStatement.executeQuery(selectMapperQuery + orderID +"';");
			while(resultSet.next()) {
				MappedProductEntity getMappedProductEntity = new MappedProductEntity(resultSet.getString(1),resultSet.getString(3), resultSet.getInt(2), resultSet.getDouble(4), resultSet.getDouble(5));
				mappedProductArrayList.add(getMappedProductEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mappedProductArrayList;
	}
	
		public static double getProductCost(String productID) {
			try {
			Statement selectStatement = databaseConnector.createStatement();
			ResultSet resultSet = selectStatement.executeQuery(selectAllQuery+ "product WHERE productID = '" + productID + "';"  );
			resultSet.next();
			return resultSet.getDouble(4);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
		public static double getRP(String customerID) {
			try {
			Statement selectStatement = databaseConnector.createStatement();
			ResultSet resultSet = selectStatement.executeQuery(selectAllQuery+ "customer WHERE customerID = '" + customerID + "';"  );
			resultSet.next();
			return resultSet.getDouble(3);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
		public static String getLastInsertedValue(String tableName) {
			try {
				Statement passwordStatement = databaseConnector.createStatement();
				ResultSet resultSet = passwordStatement.executeQuery("SELECT " + tableName + "id FROM " + tableName + " ORDER BY " + tableName + "id DESC limit 0,1;");
				String productID = null;
				while(resultSet.next())
				{
					String tempIntID = Integer.toString(Integer.parseInt(resultSet.getString(1).substring(1)) + 1);
					productID = resultSet.getString(1).substring(0, 4 - tempIntID.length()) + tempIntID;
				}
				return productID;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}
		
		public static boolean checkProductAvailabilty(String productID, int productQuantity) {
			try {
				Statement passwordStatement = databaseConnector.createStatement();
				ResultSet resultSet = passwordStatement.executeQuery(selectAvailabilityQuery + "'" + productID + "';");
				resultSet.next();
				if(resultSet.getInt(1)>=productQuantity) 
				{
					UpdateQueriesClass.updateQuantity(productID, productQuantity);
					return true;
				}
				else return false;
				
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		public static String getInchargeName(String userName) {
			try {
				Statement passwordStatement = databaseConnector.createStatement();
				ResultSet resultSet = passwordStatement.executeQuery(selectAllQuery+ "incharge WHERE inchargeID = '" + userName + "';"  );
				resultSet.next();
				return resultSet.getString(2);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			return null;
		}

		public static String getProductName(String productID) {
			try {
				Statement selectStatement = databaseConnector.createStatement();
				ResultSet resultSet = selectStatement.executeQuery(selectAllQuery+ "product WHERE productID = '" + productID + "';"  );
				resultSet.next();
				return resultSet.getString(2);
			} catch (Exception e) {
				e.printStackTrace();
				return "-";
			}
		}
	
	
}
