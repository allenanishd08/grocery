package useCases;

import database.UpdateQueriesClass;
import entities.InchargeEntity;
import services.InchargeUpdaterInterface;

public class InchargeUpdaterClass implements InchargeUpdaterInterface{
	public void changeInchargeDetails(String inchargeID, String inchargeName, String counterID)
	{
		InchargeEntity updateIncharge = new InchargeEntity(inchargeID, inchargeName, counterID);
		boolean status = UpdateQueriesClass.updateInchargeDetails(updateIncharge);
		if(status) System.out.println("\nIncharge Details Updated Successfully...");
		else System.out.println("\nUpdation Failed..");
	}
}
