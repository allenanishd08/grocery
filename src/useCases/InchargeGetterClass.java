package useCases;

import java.util.ArrayList;

import database.SelectQueriesClass;
import entities.InchargeEntity;
import services.InchargeGetterInterface;

public class InchargeGetterClass implements InchargeGetterInterface{
	public ArrayList<InchargeEntity> getInchargeDetails(String condition, String sortBy)
	{
		return SelectQueriesClass.getInchargeDetails(condition, sortBy);
	}
}