package useCases;

import database.InsertQueriesClass;
import database.SelectQueriesClass;
import entities.InchargeEntity;
import services.InchargeSetterInterface;

public class InchargeSetterClass implements InchargeSetterInterface{
	public String setInchargeDetails(String inchargeName,String counterID) {
		String inchargeID = SelectQueriesClass.getLastInsertedValue("incharge");
		InchargeEntity newIncharge = new InchargeEntity(inchargeID,inchargeName, counterID);
		if(InsertQueriesClass.addNewInchargeTuple(newIncharge)) return inchargeID;
		return "-";
		
	}
}
