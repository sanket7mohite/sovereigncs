package com.sovereigncs.test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sovereigncs.pageobject.Register;
import com.sovereigncs.utilities.XLUtils;

public class TC_CreateUser extends BaseClass {

	public String day;
	public String month;
	public String year;

	@Test(dataProvider = "register")
	public void register(String FirstName, String LastName, String DOB, String Company, String Address1, String City,
			String State, String ZipCode, String Mobile, String Alias_Address,String Email, String Password)
			throws InterruptedException, IOException {

		System.out.println("Register Function has been called...!");
		Register reg = new Register(driver);
		reg.clickSiginIn(); // Click on Sign in button

		String email = "sovereigncs" + currentDate() + "" + "@test.com";
		reg.setEmail(email); // Enter new Email Address
		reg.clickCreateAccnt(); // Click on Create Account

		waitforpageload(driver, 10);

		reg.clickrdGenderMale();
		reg.setCustFname(FirstName);
		reg.setCustLname(LastName);
		reg.clicktxtCustEmail();

		String password = "sovereigncs" + currentDate();
		reg.settxtPassword(password);

		String tmpDOB = DOB;
		String[] separated = tmpDOB.split("-");

		for (int i = 0; i < separated.length; i++) {
			if (i == 0) {
				day = (separated[0].trim());
				System.out.println("day-->" + day);
			} else if (i == 1) {
				month = (separated[1].trim());
				System.out.println("Month-->" + month);
			} else if (i == 2) {
				year = (separated[2].trim());
				System.out.println("Year-->" + year);
			}
		}

		reg.ClickdrpDays();
		reg.ClickdrpSelDays(day);
		reg.ClickdrpMonths();
		reg.ClickdrpSelMonths(month);
		reg.ClickdrpdrpYears();
		reg.ClickdrpSelYears(year);

		reg.settxtCompany(Company);
		reg.settxtAddress1(Address1);
		reg.settxtCity(City);
		reg.ClickdrpselState();
		reg.ClickdrpSelState(State);

		reg.settxtZipcode(ZipCode);
		reg.settxtMobile(Mobile);
		reg.settxtAlias(Alias_Address);
		reg.CickSubmitAccount();

		String path = System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\sovereigncs\\testdata\\DataProviderExp.xlsx";

		int rownNum = XLUtils.getRowCount(path, "Sheet");

		for (int i = 1; i <= rownNum; i++) 
		{
			XLUtils.setCellData(path, "Sheet", i, 10, email);
			XLUtils.setCellData(path, "Sheet", i, 11, password);
		}
		
		reg.CickclickLogout();
	}

	@DataProvider(name = "register")
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
