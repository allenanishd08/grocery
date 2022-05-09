package services;

import java.util.ArrayList;

import entities.MappedProductEntity;

public interface MappedProductGetterInterface {
	public ArrayList<MappedProductEntity> getMappedProductDetails(String orderBy);
}
