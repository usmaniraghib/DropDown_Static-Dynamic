package com.raghib.selenium;

/**
 * Reference:-
 * https://www.youtube.com/watch?v=VeJ5WH_9PPg
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownDynamicSpicyJet extends BaseClass  {
	
	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";
	
	public static String url = "https://www.spicejet.com/";
	
	public static String dynamicDate = "10";
	public static String dynamicMonth = "September";
	public static String dynamicYear = "2023";
	
	public static void main(String[] args) {
		// Chrome Browser
		driver = BaseClass.getDriver(browserName, browserVersion);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	
	    /*Dynamic Drop Down - Select Source and Destination*/
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//input[@type='text']")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'DEL')]")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'BLR')]")).click();		
	    
	    /*Date Selection - Departure Date Only*/
        driver.findElement(By.xpath("//div[@data-testid='undefined-month-"+dynamicMonth+"-"+dynamicYear+"']//div[@data-testid='undefined-calendar-day-"+dynamicDate+"']")).click();
        
        /*Static Drop Down - Select No of Passenger*/
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click(); 
		
		int adultCount = 0;
		if(adultCount  <= 2) {
			driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		}		
	    
	    /*Static Drop Down - Select Currency*/
        driver.findElement(By.xpath("//div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e' and text()='Currency']")).click();
        driver.findElement(By.xpath("//div[text()='SGD']")).click();
        
		BaseClass.quitDriver();
	}
}
