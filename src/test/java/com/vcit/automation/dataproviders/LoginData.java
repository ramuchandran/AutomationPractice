package com.vcit.automation.dataproviders;

import org.testng.annotations.DataProvider;

public class LoginData {

	@DataProvider(name = "users",parallel = false)
	public static Object[][] users(){
		return new Object[][] {{"ramu.chandran@gmail.com","acha2519"},{"raja01@yopmail.com","Test@1234"}};
	}
}
