package com.sovereigncs.test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sovereigncs.pageobject.Login;

import com.sovereigncs.utilities.XLUtils;

public class TC_Login extends BaseClass {
	
	@Test(dataProvider="login")
	public void Login(String FirstName, String LastName, String DOB, String Company, String Address1, String City,
			String State, String ZipCode, String Mobile, String Alias_Address, String Email, String Password) throws InterruptedException, IOException {
		System.out.println("Login Fucntion has been called...!");
		Login lg =  new Login(driver);
		lg.clickSiginIn();
		lg.settxtEmail(Email);
		lg.settxtPasswd(Password);
		lg.clickbtnSubmitLogin();
		

	}
	
	
	@DataProvider(name = "login")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\sovereigncs\\testdata\\DataProviderExp.xlsx";
		int rownNum = XLUtils.getRowCount(path, "Sheet");
		int colCount = XLUtils.getCellCount(path, "Sheet", 1);

		String logindata[][] = new String[rownNum][colCount];
		for (int i = 1; i <= rownNum; i++) {
			for (int j = 0; j < colCount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet", i, j); // 1 0
			}
		}
		return logindata;
	}
}
