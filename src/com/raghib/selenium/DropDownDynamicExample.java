package com.raghib.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDynamicExample {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        
       driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
       driver.findElement(By.xpath("//a[@value='GAY']")).click();
       driver.findElement(By.xpath("//a[@value='BLR']")).click();
       
       driver.quit();
	}
}
