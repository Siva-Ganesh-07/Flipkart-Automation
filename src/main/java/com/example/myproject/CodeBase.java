package com.example.myproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class CodeBase {
	String URL = "https://www.flipkart.com/";
	RemoteWebDriver driver = null;
	
	@BeforeTest
	public void startApp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_new.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	@AfterMethod
	public void closeApp() {
		driver.quit();
	}
}
