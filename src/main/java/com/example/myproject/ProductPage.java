package com.example.myproject;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ProductPage extends CodeBase{
	
	public ProductPage(RemoteWebDriver driver) {
        this.driver = driver;
    }
	
	//Locator
	private By addToCart = By.xpath("//button[contains(text(), 'cart') or contains(text(), 'CART')]");
	
	
	//Actions
	public boolean cartExist() {
		return driver.findElement(addToCart).isDisplayed();
	}
	public CartPage cart() {
		driver.findElement(addToCart).click();
		return new CartPage(driver);
	}
}
