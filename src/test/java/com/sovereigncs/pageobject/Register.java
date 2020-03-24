package com.sovereigncs.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sovereigncs.test.BaseClass;

public class Register extends BaseClass {
WebDriver localdriver;
	
	public Register(WebDriver remotedriver) {
		// TODO Auto-generated constructor stub
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign in') and @class='login']")
	@CacheLookup
	WebElement btSignIn;
	
	@FindBy(xpath="//INPUT[@id='email_create']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	@CacheLookup
	WebElement btnCreateAccnt;
	
	
	@FindBy(xpath="//h1[contains(text(),'Create an account')]")
	@CacheLookup
	WebElement lblCreateAccnt;

	@FindBy(xpath="//div[@id='uniform-id_gender1']")
	@CacheLookup
	WebElement rdGenderMale;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	@CacheLookup
	WebElement txtCustFname;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	@CacheLookup
	WebElement txtCustLname;
	
	@FindBy(xpath="//input[@id='email']")
	@CacheLookup
	WebElement txtCustEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//select[@id='days']")
	@CacheLookup
	WebElement drpDays;
	
	@FindBy(xpath="//select[@id='months']")
	@CacheLookup
	WebElement drpMonths;
	
	@FindBy(xpath="//select[@id='years']")
	@CacheLookup
	WebElement drpYears;
	
	@FindBy(xpath="//input[@id='firstname']")
	@CacheLookup
	WebElement txtFname;
	
	@FindBy(xpath="//input[@id='lastname']")
	@CacheLookup
	WebElement txtLname;
	
	@FindBy(xpath="//input[@id='company']")
	@CacheLookup
	WebElement txtCompany;
	
	@FindBy(xpath="//input[@id='address1']")
	@CacheLookup
	WebElement txtAddress1;
	
	@FindBy(xpath="//input[@id='city']")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(xpath="//select[@id='id_state']")
	@CacheLookup
	WebElement selState;
	
	@FindBy(xpath="//input[@id='postcode']")
	@CacheLookup
	WebElement txtZipcode;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	@CacheLookup
	WebElement txtMobile;
	
	@FindBy(xpath="//input[@id='alias']")
	@CacheLookup
	WebElement txtAlias;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	@CacheLookup
	WebElement clickSubmitAccount;
	
	
	public void clickSiginIn() throws InterruptedException 
	{
		drawBorder(driver, btSignIn);
		btSignIn.click();
		
	}

	public void setEmail(String email) throws InterruptedException 
	{
		waitforpageload(driver, 5);
		drawBorder(driver, txtEmail);
		txtEmail.sendKeys(email);
	}
	
	public void clickCreateAccnt() throws InterruptedException 
	{
		drawBorder(driver, btnCreateAccnt);
		btnCreateAccnt.click();
		
	}

	
	public void clickrdGenderMale() throws InterruptedException 
	{	
		
		drawBorder(driver, rdGenderMale);
		rdGenderMale.click();
	}
	
	public void setCustFname(String CustFname) throws InterruptedException 
	{
		drawBorder(driver, txtCustFname);
		txtCustFname.sendKeys(CustFname);
	}
	
	public void setCustLname(String CustLname) throws InterruptedException 
	{
		drawBorder(driver, txtCustLname);
		txtCustLname.sendKeys(CustLname);
	}
	
	public void clicktxtCustEmail() throws InterruptedException 
	{
		drawBorder(driver, txtCustEmail);
		txtCustEmail.click();
	}
	public void settxtPassword(String pwd) throws InterruptedException 
	{
		drawBorder(driver, txtPassword);
		txtPassword.sendKeys(pwd);
	}
		
	public void ClickdrpDays() throws InterruptedException 
	{	
		drawBorder(driver, drpDays);
		drpDays.click();
	}
	
	public void ClickdrpSelDays(String day) throws InterruptedException 
	{	
		driver.findElement(By.xpath("//select[@id='days']//option[@value='"+day+"']")).click();
	}
	public void ClickdrpMonths() throws InterruptedException 
	{	
		drawBorder(driver, drpMonths);
		drpMonths.click();
	}
	public void ClickdrpSelMonths(String month) throws InterruptedException 
	{	
		driver.findElement(By.xpath("//select[@id='months']//option[@value='"+month+"']")).click();
	}
	
	public void ClickdrpdrpYears() throws InterruptedException 
	{	
		drawBorder(driver, drpYears);
		drpYears.click();
	}
	public void ClickdrpSelYears(String year) throws InterruptedException 
	{	
		driver.findElement(By.xpath("//select[@id='years']//option[@value='"+year+"']")).click();
	}
	
	public void settxtCompany(String companyName) throws InterruptedException 
	{
		drawBorder(driver, txtCompany);
		txtCompany.sendKeys(companyName);
	}
	
	public void settxtAddress1(String Address1) throws InterruptedException 
	{
		drawBorder(driver, txtAddress1);
		txtAddress1.sendKeys(Address1);
	}
	public void settxtCity(String city) throws InterruptedException 
	{
		drawBorder(driver, txtCity);
		txtCity.sendKeys(city);
	}
	
	public void ClickdrpselState() throws InterruptedException 
	{	
		drawBorder(driver, selState);
		selState.click();
	}
	public void ClickdrpSelState(String state) throws InterruptedException 
	{	
		
		System.out.println("State --->"+state);
		if(state.equalsIgnoreCase("Alaska")) {
			driver.findElement(By.xpath("//select[@id='id_state']//option[@value='2']")).click();
		}
		else if(state.equalsIgnoreCase("Florida"))
		{
			driver.findElement(By.xpath("//select[@id='id_state']//option[@value='9']")).click();
		}
		else
		{
			System.out.println("Invalid Sate");
		}

}
	public void settxtZipcode(String zipcode) throws InterruptedException 
	{
		drawBorder(driver, txtZipcode);
		txtZipcode.sendKeys(zipcode);
	}
	
	public void settxtMobile(String mobile) throws InterruptedException 
	{
		drawBorder(driver, txtMobile);
		txtMobile.sendKeys(mobile);
	}
	public void settxtAlias(String alias) throws InterruptedException 
	{
		drawBorder(driver, txtAlias);
		txtAlias.sendKeys(alias);
	}
	public void CickSubmitAccount() throws InterruptedException 
	{	
		drawBorder(driver, clickSubmitAccount);
		clickSubmitAccount.click();
	}
	
	
	
}
