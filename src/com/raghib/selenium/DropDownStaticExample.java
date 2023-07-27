package com.raghib.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownStaticExample {
	
	public static Select selectObject = null;
	public static Select selectObject1 = null;

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Deprecated - Method
		//driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.spicejet.com/");
                
        /*Dynamic Drop Down - Select Source and Destination*/
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.xpath("//a[@value='GAY']")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();		
	    
	    /*Date Selection - Departure Date Only*/
        //driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
                       
        /*Static Drop Down - Select No of Passenger*/
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click(); 
		WebElement adult = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']"));
		selectObject1 = new Select(adult); 
		selectObject1.selectByIndex(2);
	    
	    /*Static Drop Down - Select Currency*/
        WebElement dropDownListCurrency = driver.findElement(By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency']"));
		selectObject = new Select(dropDownListCurrency);
		selectObject.selectByIndex(2); selectObject.selectByValue("BDT");
		selectObject.selectByVisibleText("USD");
				 
        //driver.quit();
	}
}
