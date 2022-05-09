package database;

import java.sql.*;

public class DatabaseConnectivity {
	protected static Connection databaseConnector = null;
	protected static String selectLoginQuery = "SELECT userpassword FROM logincredentials where userID = ";
	protected static String selectAvailabilityQuery = "SELECT productQuantityAvailable FROM product where productID = ";
	protected static String updatePassQuery = "UPDATE logincredentials SET userpassword = ? WHERE userID = ?;";
	protected static String selectAllQuery = "SELECT * FROM ";
	protected static String selectCustomerQuery = "select *,(select count(*) from orders where paymentType = 1 and customerID = c.customerid) AS cash, (select count(*) from orders where paymentType = 2 and customerID = c.customerid) as card from customer c ";
	protected static String selectMapperQuery=
	"select o.productID,o.productQuantity,(select productName from product where productID = o.productid) as productName, (select productCost from product where productID = o.productid) as productCost,"
	+ "(select productCost*o.productQuantity from product where productID = o.productid) AS amount  from productordermapper o where orderID = '";
	protected static String insertSignupQuery = "INSERT INTO logincredentials values (?,?);";
	protected static String insertProductQuery = "INSERT INTO product VALUES (?,?,?,?,?);";
	protected static String insertInchargeQuery = "INSERT INTO incharge VALUES (?,?,?);";
	protected static String insertCustomerQuery = "INSERT INTO customer VALUES (?,?,?);";
	protected static String insertCategoryQuery = "INSERT INTO category VALUES (?,?);";
	protected static String insertMapperQuery = "INSERT INTO productordermapper VALUES (?,?,?);";
	protected static String insertOrderQuery = "INSERT INTO orders VALUES (?,?,?,?,?);";
	protected static String updateCostQuery = "UPDATE orders SET ordercost = ? WHERE ordersID = ?;";
	protected static String updateRPQuery = "UPDATE customer SET customerRP = customerRP + (? * (SELECT 1+ count(*) FROM ORDERS WHERE customerID = ?))/400 WHERE customerID = ?;";
	protected static String updateRPZeroQuery = "UPDATE customer SET customerRP = 0 WHERE customerID = ?;";
	protected static String updateQuantityQuery = "UPDATE product SET productQuantityAvailable = productQuantityAvailable - ? WHERE productID = ?;";
	protected static String updateProductQuery = "UPDATE product SET productName = ?, productQuantityAvailable = ?, productCost = ?, categoryID = ? WHERE productID = ?;";
	protected static String updateInchargeQuery = "UPDATE incharge SET inchargeName = ?,counterID = ? where inchargeID = ? ";
	protected static String updateCategoryQuery = "UPDATE category SET categoryName = ? where categoryID = ?;";
	public static void databaseConnectingMethod() {
		try {
			DatabaseConnectivity.databaseConnector = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo",
					"root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void databaseConnectionCloseMethod() {
		try {
			DatabaseConnectivity.databaseConnector.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
