package services;

import java.util.ArrayList;

import entities.ProductEntity;

public interface ProductGetterInterface {
	public ArrayList<ProductEntity> getProductDetails(String condition, String sortBy);
}
