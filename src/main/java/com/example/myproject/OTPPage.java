package com.example.myproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OTPPage extends CodeBase{
	
	public OTPPage(RemoteWebDriver driver) {
        this.driver = driver;
    }
	
	//Locator
	private By emailText = By.xpath("//span[contains(text(), 'Enter Email')]");
	private By loginText = By.xpath("//span[text() = 'Login']");
	private By descriptionText = By.xpath("//span[contains(text(), 'Get access to your Orders')]");
	private By loginLink = By.xpath("//a[text() = 'Login']");
	private By userID = By.xpath("//input[contains(@class, 'r4vIwl')]");
	private By requestOTP = By.xpath("//button[text() = 'Request OTP']");
		
	//Actions
	public boolean textEmail() {
		return driver.findElement(emailText).isDisplayed();
	}
	
	public boolean textLogin() {
		return driver.findElement(loginText).isDisplayed();
	}
	
	public boolean textDescription() {
		return driver.findElement(descriptionText).isDisplayed();
	}
	
	public boolean linkLogin() {
		return driver.findElement(loginLink).isDisplayed();
	}
	
	public OTPPage enterUserID(String user) {
		driver.findElement(userID).sendKeys(user);;
		return this;
	}
	
	public HomePage OTPRequest() {
		driver.findElement(requestOTP).click();;
		return new HomePage(driver);
	}
}
