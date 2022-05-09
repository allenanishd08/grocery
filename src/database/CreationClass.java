package database;

import java.sql.*;

public class CreationClass extends DatabaseConnectivity{
	public static void createSchema()
	{
		try {
			Statement checkTableStatement = databaseConnector.createStatement();
			ResultSet tablesPresent = checkTableStatement.executeQuery("SHOW TABLES;");
			if(!tablesPresent.next())
			{
				CreationClass.setCategoryTable();
				CreationClass.setCustomerTable();
				CreationClass.setInchargeTable();
				CreationClass.setLoginCredentialsTable();
				CreationClass.setProductTable();
				CreationClass.setOrdersTable();
				CreationClass.setMapperTable();
			}
			
		} catch (Exception e) {
		}
	}
	
	
	private static void setCategoryTable(){
		String tableCreation = "CREATE TABLE `category`("
				+ "`categoryID` VARCHAR(5) NOT NULL,"
				+ "`categoryName` VARCHAR(45) NOT NULL,"
				+ "PRIMARY KEY (`categoryID`));";
		String [] defaultInsertionStrings = {"INSERT INTO `category` (`categoryID`, `categoryName`) VALUES ('Q001', 'Chocolates');",
				"INSERT INTO `category` (`categoryID`, `categoryName`) VALUES ('Q002', 'Biscuits');",
				"INSERT INTO `category` (`categoryID`, `categoryName`) VALUES ('Q003', 'Spices');",
				"INSERT INTO `category` (`categoryID`, `categoryName`) VALUES ('Q004', 'Grains');"
		};
		
		try {		
			Statement createTableStatement = databaseConnector.createStatement();
			createTableStatement.executeUpdate(tableCreation);
			for (String string : defaultInsertionStrings) {
				createTableStatement.executeUpdate(string);
			}			
		} catch (Exception e) {		
			
		}
		
		

	}
	
	private static void setCustomerTable() {
		String tableCreation = "CREATE TABLE `customer` ("
				+ "  `customerID` VARCHAR(5) NOT NULL,"
				+ "  `customerName` VARCHAR(45) NOT NULL,"
				+ "  `customerRP` DECIMAL(6,2) NOT NULL DEFAULT '0.00',"
				+ "  PRIMARY KEY (`customerID`),"
				+ "  UNIQUE INDEX `customerID_UNIQUE` (`customerID` ASC) VISIBLE);";
		String [] defaultInsertionStrings = {"INSERT INTO `customer` (`customerID`, `customerName`, `customerRP`) VALUES ('C001', 'Allen', '15.00');"
		};
		
		try {		
			Statement createTableStatement = databaseConnector.createStatement();
			createTableStatement.executeUpdate(tableCreation);
			for (String string : defaultInsertionStrings) {
				createTableStatement.executeUpdate(string);
			}			
		} catch (Exception e) {		
			
		}
		
		
	}
	
	private static void setLoginCredentialsTable() {
		String tableCreation = "CREATE TABLE `logincredentials` ("
				+ "  `userID` VARCHAR(6) NOT NULL,"
				+ "  `userPassword` VARCHAR(20) NOT NULL,"
				+ "  PRIMARY KEY (`userID`),"
				+ "  UNIQUE INDEX `userID_UNIQUE` (`userID` ASC) VISIBLE);"
				+ "";
		String [] defaultInsertionStrings = {"INSERT INTO `logincredentials` (`userID`, `userPassword`) VALUES ('admin', 'admin');"
				, "INSERT INTO `logincredentials` (`userID`, `userPassword`) VALUES ('I001', 'I001');"
				, "INSERT INTO `logincredentials` (`userID`, `userPassword`) VALUES ('I002', 'I002');"

		};		
		try {		
			Statement createTableStatement = databaseConnector.createStatement();
			createTableStatement.executeUpdate(tableCreation);
			for (String string : defaultInsertionStrings) {
				createTableStatement.executeUpdate(string);
			}			
		} catch (Exception e) {		
			
		}
		
		
	}

	private static void setInchargeTable() {
		String tableCreation = "CREATE TABLE `incharge` ("
				+ "		  `inchargeID` VARCHAR(5) NOT NULL,"
				+ "		  `inchargeName` VARCHAR(45) NOT NULL,"
				+ "		  `counterID` VARCHAR(2) NOT NULL,"
				+ "		  PRIMARY KEY (`inchargeID`),"
				+ "		  UNIQUE INDEX `inchargeID_UNIQUE` (`inchargeID` ASC) VISIBLE);"
				+ "";
		String [] defaultInsertionStrings = {"INSERT INTO `incharge` (`inchargeID`, `inchargeName`, `counterID`) VALUES ('I001', 'Lee', 'C3');",
				 "INSERT INTO `incharge` (`inchargeID`, `inchargeName`, `counterID`) VALUES ('I002', 'Amalan ', 'C2');"
		};		
		try {		
			Statement createTableStatement = databaseConnector.createStatement();
			createTableStatement.executeUpdate(tableCreation);
			for (String string : defaultInsertionStrings) {
				createTableStatement.executeUpdate(string);
			}			
		} catch (Exception e) {		
			
		}
		
		
	}
	
	private static void setOrdersTable() {
		String tableCreation = "CREATE TABLE `orders` ("
				+ "		  `ordersID` VARCHAR(5) NOT NULL,"
				+ "		  `customerID` VARCHAR(5) NOT NULL,"
				+ "		  `inchargeID` VARCHAR(5) NOT NULL,"
				+ "		  `paymentType` VARCHAR(4) NOT NULL,"
				+ "		  `orderCost` INT UNSIGNED NOT NULL,"
				+ "		  PRIMARY KEY (`ordersID`),"
				+ "		  UNIQUE INDEX `ordersID_UNIQUE` (`ordersID` ASC) VISIBLE,"
				+ "		  INDEX `customerID_idx` (`customerID` ASC) VISIBLE,"
				+ "		  INDEX `inchargeID_idx` (`inchargeID` ASC) VISIBLE,"
				+ "		  CONSTRAINT `customerID`"
				+ "		    FOREIGN KEY (`customerID`)"
				+ "		    REFERENCES `customer` (`customerID`)"
				+ "		    ON DELETE CASCADE"
				+ "		    ON UPDATE CASCADE,"
				+ "		  CONSTRAINT `inchargeID`"
				+ "		    FOREIGN KEY (`inchargeID`)"
				+ "		    REFERENCES `incharge` (`inchargeID`)"
				+ "		    ON DELETE CASCADE"
				+ "		    ON UPDATE CASCADE);";
		String [] defaultInsertionStrings = {"INSERT INTO `orders` (`ordersID`, `customerID`, `inchargeID`, `paymentType`, `orderCost`) VALUES ('O001', 'C001', 'I001', 'Card', '1500');"
		};		
		try {		
			Statement createTableStatement = databaseConnector.createStatement();
			createTableStatement.executeUpdate(tableCreation);
			for (String string : defaultInsertionStrings) {
				createTableStatement.executeUpdate(string);
			}			
		} catch (Exception e) {		
			
		}
	}
	
	private static void setProductTable() {
		String tableCreation = "CREATE TABLE `product` ("
				+ "  `productID` VARCHAR(5) NOT NULL,"
				+ "  `productName` VARCHAR(45) NOT NULL,"
				+ "  `productQuantityAvailable` INT UNSIGNED NOT NULL,"
				+ "  `productCost` DECIMAL(7,2) UNSIGNED NOT NULL,"
				+ "  `categoryID` VARCHAR(5) NOT NULL,"
				+ "  PRIMARY KEY (`productID`),"
				+ "  UNIQUE INDEX `productID_UNIQUE` (`productID` ASC) VISIBLE,"
				+ "  INDEX `categoryID_idx` (`categoryID` ASC) VISIBLE,"
				+ "  CONSTRAINT `categoryID`"
				+ "    FOREIGN KEY (`categoryID`)"
				+ "    REFERENCES `category` (`categoryID`)"
				+ "    ON DELETE CASCADE"
				+ "    ON UPDATE CASCADE);"
				+ "";
		String [] defaultInsertionStrings = {"INSERT INTO `product` (`productID`, `productName`, `productQuantityAvailable`, `productCost`, `categoryID`) VALUES ('P001', 'MarieGold', '20', '20.00', 'Q002');"
				, "INSERT INTO `product` (`productID`, `productName`, `productQuantityAvailable`, `productCost`, `categoryID`) VALUES ('P002', 'Dairy Milk', '15', '10.00', 'Q001');"
				, "INSERT INTO `product` (`productID`, `productName`, `productQuantityAvailable`, `productCost`, `categoryID`) VALUES ('P003', '5 Star', '15', '10.00', 'Q001');"
				, "INSERT INTO `product` (`productID`, `productName`, `productQuantityAvailable`, `productCost`, `categoryID`) VALUES ('P004', 'Kitkat', '28', '10.00', 'Q001');"
				, "INSERT INTO `product` (`productID`, `productName`, `productQuantityAvailable`, `productCost`, `categoryID`) VALUES ('P005', 'Parle - G', '50', '5.00', 'Q002');"
				, "INSERT INTO `product` (`productID`, `productName`, `productQuantityAvailable`, `productCost`, `categoryID`) VALUES ('P006', 'Rice - Samba 5KG', '10', '200.00', 'Q004');"
				, "INSERT INTO `product` (`productID`, `productName`, `productQuantityAvailable`, `productCost`, `categoryID`) VALUES ('P007', 'Rice - Samba 10KG', '25', '400.00', 'Q004');"
				, "INSERT INTO `product` (`productID`, `productName`, `productQuantityAvailable`, `productCost`, `categoryID`) VALUES ('P008', 'Rice - Ponni 5KG', '13', '250.00', 'Q004');"
				, "INSERT INTO `product` (`productID`, `productName`, `productQuantityAvailable`, `productCost`, `categoryID`) VALUES ('P009', 'Rice - Ponni 10KG', '23', '500.00', 'Q004');"
		};		
		try {		
			Statement createTableStatement = databaseConnector.createStatement();
			createTableStatement.executeUpdate(tableCreation);
			for (String string : defaultInsertionStrings) {
				createTableStatement.executeUpdate(string);
			}			
		} catch (Exception e) {		
			
		}
	}
	
	private static void setMapperTable() {
		String tableCreation = "CREATE TABLE `productordermapper` ("
				+ "  `productID` VARCHAR(5) NOT NULL,"
				+ "  `orderID` VARCHAR(5) NOT NULL,"
				+ "  `productQuantity` INT UNSIGNED NOT NULL,"
				+ "  PRIMARY KEY (`productID`, `orderID`),"
				+ "  INDEX `orderID_idx` (`orderID` ASC) VISIBLE,"
				+ "  CONSTRAINT `orderID`"
				+ "    FOREIGN KEY (`orderID`)"
				+ "    REFERENCES `orders` (`ordersID`)"
				+ "    ON DELETE CASCADE"
				+ "    ON UPDATE CASCADE,"
				+ "  CONSTRAINT `productID`"
				+ "    FOREIGN KEY (`productID`)"
				+ "    REFERENCES `product` (`productID`)"
				+ "    ON DELETE CASCADE"
				+ "    ON UPDATE CASCADE);";
		String [] defaultInsertionStrings = {"INSERT INTO `productordermapper` (`productID`, `orderID`, `productQuantity`) VALUES ('P008', 'O001', '2');"
				, "INSERT INTO `productordermapper` (`productID`, `orderID`, `productQuantity`) VALUES ('P009', 'O001', '2');"
				};		
		try {		
			Statement createTableStatement = databaseConnector.createStatement();
			createTableStatement.executeUpdate(tableCreation);
			for (String string : defaultInsertionStrings) {
				createTableStatement.executeUpdate(string);
			}			
		} catch (Exception e) {		
			
		}
	}
}



