package presentationLayer;

import services.*;
import useCases.*;

public class LoginIndex {
	public static void loginDisplay(ScanIt input) {
		boolean iterator = true;
		boolean passFind = false;
		while (iterator) {
			System.out.println("\n************************************************************");
			if (passFind)
				System.out.println("\nInvalid Login Credentials..!!!\n");
			
			System.out.print("User Name\t:");
			String userName = input.next();
			System.out.print("Password\t:");
			String userPassword = input.next();			
			LoginVerifierInterface newPasswordVerifier = new LoginVerifierClass();
			if (newPasswordVerifier.verifyLogin(userName, userPassword))
			{
				if(userName.equals("admin")) AdminIndex.adminDisplayControl(input);
				else InchargeIndex.inchargeDisplayControl(input,userName);
				iterator = false;
			}
			else {
				passFind  = true;
			}
		}
	}

}
