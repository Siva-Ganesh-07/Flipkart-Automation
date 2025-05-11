package com.example.myproject;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest extends CodeBase{
	@Test
	public void loginTest() throws InterruptedException {
		LoginPage lp =new LoginPage(driver);
		try {
			String currentURL = "https://www.flipkart.com/";
			String title = lp.getTitle();
			Assert.assertEquals(title, currentURL);
		}catch (AssertionError e) {
            takeScreenshot("testExample");
            throw e;
        }
		
		boolean cartExist = lp.testCart();
		Assert.assertTrue(cartExist);
		try {
			String sellerText = "Become a Seller";
			String sellerExist = lp.seller();
			Assert.assertEquals(sellerExist, sellerText, "Correct");
		}catch(AssertionError e) {
			takeScreenshot("testExample");
			throw e;
		}
		lp.clickLogin();
		
		
		OTPPage otp = new OTPPage(driver);
		
		boolean emailText = otp.textEmail();
		Assert.assertTrue(emailText);
		
		boolean loginText = otp.textLogin();
		Assert.assertTrue(loginText);
		
		boolean descriptionText = otp.textDescription();
		Assert.assertTrue(descriptionText);
		
		boolean loginLink = otp.linkLogin();
		Assert.assertTrue(loginLink);
		
		otp.enterUserID("8248963707");
		
		otp.OTPRequest();
		
		Thread.sleep(15000);
		
		HomePage home = new HomePage(driver);
		home.searchProduct("ZEBRONICS ZEB-BRO");
		Thread.sleep(2000);
		
		home.clickSortByLowToHigh();
		Thread.sleep(2000);
		
		home.chooseHeadphone();
		Thread.sleep(2000);
		
		home.switchTo();
		Thread.sleep(2000);
		
		ProductPage product = new ProductPage(driver);
		Assert.assertTrue(product.cartExist()); 
		
		product.cart();
		Thread.sleep(2000);
	}
	
	public void takeScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./screenshots/" + testName + ".png"));
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
    
}
