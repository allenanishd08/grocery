package services;

import java.util.ArrayList;

import entities.InchargeEntity;

public interface InchargeGetterInterface {
	public ArrayList<InchargeEntity> getInchargeDetails(String condition, String sortBy);
}
