package useCases;

import database.UpdateQueriesClass;
import entities.CategoryEntity;
import services.CategoryUpdaterInterface;

public class CategoryUpdaterClass implements CategoryUpdaterInterface{
	public void changeCategoryDetails(String categoryID, String categoryName) {
	
	CategoryEntity updateCategory = new CategoryEntity(categoryID, categoryName);
	boolean status = UpdateQueriesClass.updateCategoryDetails(updateCategory);
	if(status) System.out.println("\nCategory Details Updated Successfully...");
	else System.out.println("\nUpdation Failed..");
	}
}
