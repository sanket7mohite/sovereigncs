package com.sovereigncs.repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class ObjectRepository {

	private static ObjectRepository objectrepository = null;
	@SuppressWarnings("unused")
	private WebDriver driver;
	
	
	
	ObjectRepository(WebDriver driver) {
		PageFactory.initElements(driver, this); // 15, TimeUnit.SECONDS, this) {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(factory, this);
		this.driver = driver;

	}

	public static ObjectRepository getInstance(WebDriver driver) {
		objectrepository = new ObjectRepository(driver);
		return objectrepository;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Categories')]//following-sibling::ul//li//a[contains(text(), 'Women')]") 
	private WebElement btnWomen;
	
	@FindBy(xpath = "//div[@class='product-container']//parent::li") 
	private WebElement hoverProduct;
	
	@FindBy(xpath = "//a[@class='quick-view']") 
	private WebElement btnQuickView;
	
	@FindBy(xpath = "//a[@data-field-qty='qty']//i[@class='icon-plus']") 
	private WebElement btnAddQuantity;
	
	
	@FindBy(xpath = "//div[@class='box-cart-bottom']//button") 
	private WebElement btnAddtoCart;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']") 
	private WebElement btnProceedToCheckOut;
	
	@FindBy(xpath = "//span[@id='our_price_display']") 
	private WebElement labelProductPrice;
	
	@FindBy(xpath = "//td[@id='total_price_container']//span") 
	private WebElement labelTotalPrice;
	
	@FindBy(xpath = "//div[@id='HOOK_SHOPPING_CART']//following-sibling::p//a[@title='Proceed to checkout']") 
	private WebElement btnCheckOut;
	
	@FindBy(xpath = "//button[@name='processAddress']") 
	private WebElement btnCheckOutAddress;
	
	@FindBy(xpath = "//button[@name='processCarrier']") 
	private WebElement btnCheckOutCarrier;
	
	
	@FindBy(xpath = "//input[@id='cgv']") 
	private WebElement chkTermsCondition;
	
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']") 
	private WebElement btnPayByWire;
	
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]//parent::button") 
	private WebElement btnConfirmOrder;
	
	
	public WebElement clicklinkWomen() {
		return btnWomen;
	}
	public WebElement mouseHoverProduct() {
		return hoverProduct;
	}
	public WebElement clickbtnQuickView() {
		return btnQuickView;
	}
	public WebElement clickbtnAddQuantity() {
		return btnAddQuantity;
	}
	public WebElement clickbtnAddtoCart() {
		return btnAddtoCart;
	}
	public WebElement clickbtnProceedToCheckOut() {
		return btnProceedToCheckOut;
	}
	public WebElement getlabelProductPrice() {
		return labelProductPrice;
	}
	public WebElement getlabelTotalPrice() {
		return labelTotalPrice;
	}
	public WebElement clickbtnCheckOut() {
		return btnCheckOut;
	}
	
	public WebElement clickbtnCheckOutAddress() {
		return btnCheckOutAddress;
	}
	
	public WebElement clickbtnCheckOutCarrier() {
		return btnCheckOutCarrier;
	}
	
	public WebElement clickchkTermsCondition() {
		return chkTermsCondition;
	}
	public WebElement clickbtnPayByWire() {
		return btnPayByWire;
	}
	public WebElement clickbtnConfirmOrder() {
		return btnConfirmOrder;
	}
}


