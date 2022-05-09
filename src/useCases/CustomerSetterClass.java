package useCases;

import database.InsertQueriesClass;
import database.SelectQueriesClass;
import entities.CustomerEntity;
import services.CustomerSetterInterface;

public class CustomerSetterClass implements CustomerSetterInterface{
	public String setCustomerDetails(String customerName) {
		String customerID = SelectQueriesClass.getLastInsertedValue("customer");
		CustomerEntity newCustomer = new CustomerEntity(customerID,customerName);
		if(InsertQueriesClass.addNewCustomerTuple(newCustomer))	return customerID;
		return "-";
	}
}
