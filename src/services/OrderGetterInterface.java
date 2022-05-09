package services;

import java.util.ArrayList;

import entities.OrderEntity;

public interface OrderGetterInterface {
	public ArrayList<OrderEntity> getOrderDetails(String condition, String sortBy);
}
