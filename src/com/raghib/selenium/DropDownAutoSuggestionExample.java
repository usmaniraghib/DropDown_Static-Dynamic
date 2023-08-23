package com.raghib.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownAutoSuggestionExample {
	// TODO Program Pending to implement.
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(Keys.ENTER);
        
        WebElement sourceLocation = driver.findElement(By.xpath("//div[@role='combobox']//input[@type='text']"));
        
        try {
			Thread.sleep(3000);
			sourceLocation.sendKeys("GAY");
			Thread.sleep(2000);
			sourceLocation.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
	        sourceLocation.sendKeys(Keys.ENTER);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(Keys.ENTER);
        WebElement destinationLocation = driver.findElement(By.xpath("//div[@role='combobox']//input[@placeholder='To']"));
        
        try {
			Thread.sleep(3000);
			destinationLocation.sendKeys("BLR");
			
			int count = 1;
			while (count<3) {
				Thread.sleep(3000);
				destinationLocation.sendKeys(Keys.ARROW_DOWN);
				count++;
			}
			
			Thread.sleep(3000);
			destinationLocation.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        driver.quit();
		
	}

}
