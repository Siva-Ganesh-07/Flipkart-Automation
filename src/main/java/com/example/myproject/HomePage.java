package com.example.myproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends CodeBase{
	
	public HomePage(RemoteWebDriver driver) {
        this.driver = driver;
    }
	
	//Locator
	private By searchInput = By.xpath("//input[contains(@title, 'Search for Products')]");
	private By sortByLowToHigh = By.xpath("//div[contains(text(), 'Price -- Low to High')]");
	private By headphone = By.xpath("//a[contains(text(),'ZEBRONICS ZEB-BRO, With In-Line MiC') and contains(@href, '/zebronics-zeb-bro-in-line-mic-3-5mm-jack-10mm-drivers-compatible-phone-tablet-wired/p/itm2')]");
		
	
	//actions
	public HomePage searchProduct(String product) {
		driver.findElement(searchInput).sendKeys(product + Keys.ENTER);
		return this;
	}
	
	public HomePage clickSortByLowToHigh() {
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.elementToBeClickable(sortByLowToHigh)).click();
	    return this;
	}
	
	public HomePage chooseHeadphone() {
		driver.findElement(headphone).click();
		return this;
	}
	
	public ProductPage switchTo() {
		for(String handle : driver.getWindowHandles()) {
	        driver.switchTo().window(handle);
	    }
		return new ProductPage(driver);
	}
	
	

}
