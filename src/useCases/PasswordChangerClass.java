package useCases;

import database.LoginCredentialsClass;

public class PasswordChangerClass {
	public static void changePasswordMethod(String userName, String password) {
		boolean result = LoginCredentialsClass.changePassword(userName, password);
		if(result) System.out.println("Password Updated Successfully..");
	}
}
