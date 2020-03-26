package com.sovereigncs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sovereigncs.test.BaseClass;

public class Login extends BaseClass {

WebDriver localdriver;
	
	public Login(WebDriver remotedriver) {
		// TODO Auto-generated constructor stub
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign in') and @class='login']")
	@CacheLookup
	WebElement btSignIn;
	
	@FindBy(xpath="//input[@id='email']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	@CacheLookup
	WebElement txtPasswd;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	@CacheLookup
	WebElement btnSubmitLogin;
	
	
	
	public void clickSiginIn() throws InterruptedException 
	{
		drawBorder(driver, btSignIn);
		btSignIn.click();
	}
	public void settxtEmail(String email) throws InterruptedException 
	{
		drawBorder(driver, txtEmail);
		txtEmail.sendKeys(email);
	}
	public void settxtPasswd(String passwd) throws InterruptedException 
	{
		drawBorder(driver, txtPasswd);
		txtPasswd.sendKeys(passwd);
	}
	public void clickbtnSubmitLogin() throws InterruptedException 
	{
		drawBorder(driver, btnSubmitLogin);
		btnSubmitLogin.click();
	}
}
