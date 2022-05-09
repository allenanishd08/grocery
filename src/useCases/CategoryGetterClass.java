package useCases;

import java.util.ArrayList;
import database.SelectQueriesClass;
import entities.CategoryEntity;
import services.CategoryGetterInterface;


public class CategoryGetterClass implements CategoryGetterInterface {
	public ArrayList<CategoryEntity> getCategoryDetails() {
		return SelectQueriesClass.getCategoryDetails();
	}
}
