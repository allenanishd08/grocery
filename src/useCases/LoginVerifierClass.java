package useCases;

import database.*;
import services.*;

public class LoginVerifierClass implements LoginVerifierInterface{
	public boolean verifyLogin(String userName, String userPassword) {
		String originalPassword = LoginCredentialsClass.getPassword(userName);
		if(userPassword.equals(originalPassword)) return true;
		return false;
	}
}
