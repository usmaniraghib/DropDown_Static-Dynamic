package com.raghib.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownDynamicExample extends BaseClass {

	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";

	public static String url = "https://www.spicejet.com/";

	public static String soucreLocation = "DEL";
	public static String destinationLocation = "BLR";

	public static void main(String[] args) throws InterruptedException {
		// Chrome Browser
		driver = BaseClass.getDriver(browserName, browserVersion);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//input[@type='text']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'" + soucreLocation + "')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'" + destinationLocation + "')]")).click();

		BaseClass.quitDriver();
	}
}
