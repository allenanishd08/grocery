package useCases;

import java.util.ArrayList;

import database.SelectQueriesClass;
import entities.ProductEntity;
import services.ProductGetterInterface;

public class ProductGetterClass implements ProductGetterInterface{
	public ArrayList<ProductEntity> getProductDetails(String condition, String sortBy)
	{
		return SelectQueriesClass.getProductDetails(condition, sortBy);
	}
}
