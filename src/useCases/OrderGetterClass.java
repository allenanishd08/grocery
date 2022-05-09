package useCases;

import java.util.ArrayList;

import database.SelectQueriesClass;
import entities.OrderEntity;
import services.OrderGetterInterface;

public class OrderGetterClass implements OrderGetterInterface{
	public ArrayList<OrderEntity> getOrderDetails(String condition, String sortBy)
	{
		return SelectQueriesClass.getOrderDetails(condition, sortBy);
	}
}
