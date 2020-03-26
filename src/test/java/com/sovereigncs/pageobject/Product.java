package com.sovereigncs.pageobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sovereigncs.repo.LoadManager;
import com.sovereigncs.repo.ObjectRepository;
import com.sovereigncs.test.BaseClass;

public class Product extends BaseClass {

	public ObjectRepository objectrepository = null;
	String display_product_price ="";
	String labelTotalPrice ="";

	public Product(WebDriver driver) {
		objectrepository = ObjectRepository.getInstance(driver);
	}

	public void womenProduct(WebDriver driver) throws InterruptedException, IOException {
//		buttonClick(driver,ObjectRepository., 10, "Login");
		buttonClick(driver, objectrepository.clicklinkWomen(), 5, "Click on Woment button");
		mouseHover(driver, objectrepository.mouseHoverProduct(), 5, "Hover over Product");
		System.out.println("Now clicking on Quick View");
		buttonClick(driver, objectrepository.clickbtnQuickView(), 5, "Click on QuickView");

		waitforpageload(driver, 5);
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

		for (WebElement iframe : iframes) {
			driver.switchTo().frame(iframe);
			display_product_price = objectrepository.getlabelProductPrice().getText();
			System.out.println("display_product_price->"+display_product_price);
			buttonClick(driver, objectrepository.clickbtnAddQuantity(), 5, "Click Add Qunantity");
			buttonClick(driver, objectrepository.clickbtnAddtoCart(), 5, "Click Add to Cart");
		}
		driver.switchTo().defaultContent();
		buttonClick(driver, objectrepository.clickbtnProceedToCheckOut(), 5, "Click on Proceed To Checkout");
		
		/*String total_product = objectrepository.getlabelProductPrice().getText();
		int toal_product_price = Integer.parseInt(display_product_price)*2;
		System.out.println("toal_product_price->"+toal_product_price);
		labelTotalPrice = driver.findElement((By) objectrepository.getlabelTotalPrice()).getText();
		
		int total_TotalPrice =  Integer.parseInt(labelTotalPrice);
		System.out.println("total_TotalPrice->"+total_TotalPrice);
		Assert.assertEquals(toal_product_price, total_TotalPrice);
		*/
	}
	public void checkOut(WebDriver driver) throws InterruptedException, IOException{
		System.out.println("CheckOut function has been called..");
		buttonClick(driver, objectrepository.clickbtnCheckOut(), 10, "Click on Proceed to checkOut");
		buttonClick(driver, objectrepository.clickbtnCheckOutAddress(), 3, "Click on Proceed to CheckOutAddress");
		
		buttonClick(driver, objectrepository.clickchkTermsCondition(), 3, "Click on chkTermsCondition");
		buttonClick(driver, objectrepository.clickbtnCheckOutCarrier(), 3, "Click on Proceed to CheckOutCarrier");
		
		
		
		buttonClick(driver, objectrepository.clickbtnPayByWire(), 3, "Click clickbtnPayByWire");
		buttonClick(driver, objectrepository.clickbtnConfirmOrder(), 3, "Click clickbtnConfirmOrder");
		
		String curr_tilte = driver.getTitle();
		String exp_title= "Order confirmation - My Store";
		Assert.assertEquals(curr_tilte, exp_title);
		
		
	}

}
