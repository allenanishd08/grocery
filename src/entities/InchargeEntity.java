package entities;

public class InchargeEntity {
	public String inchargeID;
	public String inchargeName;
	public String counterID;
	public InchargeEntity(String inchargeID,String inchargeName, String counterID)
	{
		this.inchargeID = inchargeID;
		this.inchargeName = inchargeName;
		this.counterID = counterID;
	}
	
}
