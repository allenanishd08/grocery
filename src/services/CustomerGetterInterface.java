package services;

import java.util.ArrayList;

import entities.CustomerEntity;

public interface CustomerGetterInterface {
	public ArrayList<CustomerEntity> getCustomerDetails(String sortBy);
}
