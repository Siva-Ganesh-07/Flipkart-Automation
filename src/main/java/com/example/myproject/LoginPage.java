package com.example.myproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends CodeBase
{
	public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;
    }
	
    //Locator 
    private By cart = By.xpath("//a[text() = 'Cart']");
    private By becomeSeller = By.xpath("//a[text() = 'Become a Seller']");
	private By login = By.xpath("//a[@title = 'Login' and @aria-haspopup = 'true']");
	//private By enterUserID = By.xpath("//input[contains(@class, \\\"r4vIwl \\\")]");
	

    // Page Actions (Methods)
    public String getTitle() {
    	return driver.getCurrentUrl();
    }
	
	
    public boolean testCart() {
    	return driver.findElement(cart).isDisplayed();
    }
    
    public String seller() {
    	return driver.findElement(becomeSeller).getText();
    }
    
    public OTPPage clickLogin() {
        driver.findElement(login).click();;
        return new OTPPage(driver);
    }
    	
}
