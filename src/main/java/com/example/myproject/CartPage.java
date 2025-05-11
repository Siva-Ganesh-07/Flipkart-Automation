package com.example.myproject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CartPage extends CodeBase{
	
	public CartPage(RemoteWebDriver driver) {
        this.driver = driver;
    }
	
	//Locator
	private By Total = By.xpath("//div[contains(@class, 'PWd9A7 xvz6eC')]//div[@class = '_1Y9Lgu']/span");
	private By Flipkart = By.xpath("//img[@title = 'Flipkart']//..");
	
	//Actions
	public CartPage totalAmountExist() {
		driver.findElement(Total).isDisplayed();
		return this;
	}
	
	public CartPage totalAmount(){
		driver.findElement(Total).getText();
		return this;
	}
	
	public MenPage FlipkartImage() {
		driver.findElement(Flipkart).click();
		return new MenPage(driver);
	}
}
