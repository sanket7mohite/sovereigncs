package com.sovereigncs.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sovereigncs.pageobject.Product;

public class TC_AddProduct extends BaseClass {
	@Test
	public void addProduct() throws InterruptedException, IOException {
		logger.info("addProduct Fucntion has been called...!");
		Product pd = new Product(driver);
		pd.womenProduct(driver);
		pd.checkOut(driver);
		pd.profile(driver);
	}

}
