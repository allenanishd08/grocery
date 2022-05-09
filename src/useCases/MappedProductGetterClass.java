package useCases;

import java.util.ArrayList;

import database.SelectQueriesClass;
import entities.MappedProductEntity;
import services.MappedProductGetterInterface;

public class MappedProductGetterClass implements MappedProductGetterInterface{
	public ArrayList<MappedProductEntity> getMappedProductDetails(String orderID)
	{
		return SelectQueriesClass.getMappedProductDetails(orderID);
	}
}
