package useCases;

import java.util.ArrayList;

import database.SelectQueriesClass;
import entities.CustomerEntity;
import services.CustomerGetterInterface;

public class CustomerGetterClass implements CustomerGetterInterface{
	public ArrayList<CustomerEntity> getCustomerDetails(String sortBy)
	{
		return SelectQueriesClass.getCustomerDetails(sortBy);
	}
}