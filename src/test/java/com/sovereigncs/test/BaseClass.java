package com.sovereigncs.test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.google.common.base.Function;
import com.sovereigncs.repo.LoadManager;
import com.sovereigncs.utilities.ReadConfig;
import com.sovereigncs.utilities.XLUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public File AutmSnapfile;
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getAppURL();
	public static Logger logger;

	@BeforeTest
	public void setup() throws IOException {
		logger = LogManager.getLogger(BaseClass.class);
		
		logger.info("Setup Function has been called...");
//		logger.error("test_error");
//		logger.fatal("test_fatal");
		
//		System.out.println("Setup Function has been called...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		captureScreen(driver, "Home Page");
		
	}
	
	public void checkFramePopup(WebDriver driver, WebElement element, String Label) throws InterruptedException, IOException {
		logger.info("checkFramePopup Function has been called...");
		waitforpageload(driver, 5);
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		
		for (WebElement iframe : iframes) {
			driver.switchTo().frame(iframe);
			buttonClick(driver, element, 30, Label);
			
		}
		driver.switchTo().defaultContent();
	}
	
	public void mouseHover(WebDriver driver,WebElement element, int waitAfterClick, String label) throws InterruptedException, IOException {
		logger.info(" Function has been called...");
	Actions actions = new Actions(driver);
	drawBorder(driver,element);
 	actions.moveToElement(element).build().perform();
 	
	}
	
	   public static void buttonClick(WebDriver driver,WebElement element, int waitAfterClick, String label) throws InterruptedException, IOException {
		   logger.info(" Function has been called...");
				drawBorder(driver,element);
				element.click(); 
				waitforpageload(driver, waitAfterClick);
				System.out.println(label);
				
			}	
	   
	public static void drawBorder(WebDriver driver, WebElement element) throws InterruptedException {
		logger.info("drawBorder Function has been called...");

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6.5px solid rgb(0, 230, 0)'",
					element);
		}
	}
	
	public static String currentDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("MMddyy_HHmm");
	    Date date = new Date();
	    String current_date = dateFormat.format(date);
		return current_date;
	}
	
	static Function<WebDriver, Boolean> documentWait = new Function<WebDriver, Boolean>() {
		public Boolean apply(WebDriver driver) {
			return (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState=='complete'")
					? (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0")
					: false;
		}
	};
	
   public static void waitforpageload(WebDriver driver, int iTimeOut) {
	   logger.info("waitforpageload Function has been called...");
		
		String Label = "";
		try {
			Label = driver.getTitle();
			Wait<WebDriver> waitforload = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(iTimeOut))
					.pollingEvery(Duration.ofSeconds(iTimeOut)).ignoring(NoSuchElementException.class);
			waitforload.until(documentWait);
		} catch (Exception ex) {
			System.out.println("Error: " + Label + " " + ex.getMessage());
		}
	}
   
   public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
	   logger.info("captureScreen Function has been called...");
		TakesScreenshot sc = (TakesScreenshot)driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/ScreenShots/" + tname + ".png");
		FileUtils.copyFile(src, target);
		System.out.println("ScreenShot Taken"); 
	
	}

	@AfterTest
	public void tearDown() {
//		driver.quit();
	}

}
