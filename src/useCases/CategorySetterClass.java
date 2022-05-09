package useCases;

import database.InsertQueriesClass;
import database.SelectQueriesClass;
import entities.CategoryEntity;
import services.CategorySetterInterface;

public class CategorySetterClass implements CategorySetterInterface{
	public String setCategoryDetails(String categoryName) {
		String categoryID = SelectQueriesClass.getLastInsertedValue("category");
		CategoryEntity newCategory = new CategoryEntity(categoryID, categoryName);
		if(InsertQueriesClass.addNewCategoryTuple(newCategory)) return categoryID;
		return "-";
	}
}
