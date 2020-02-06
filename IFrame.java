package com.sqtl.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IFrame {

	public static void main(String[] args) {
		String url = "http://www.symantec.com";
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		
		WebElement destination_window = driver.findElement(By.xpath("//div[@id='cboxClose']"));
		//close the popup
		destination_window.click();
		
		WebElement us_link = driver.findElement(By.xpath("//a[@title='Change Country']"));
		us_link.click();

		WebElement india_link = driver.findElement(By.xpath("//a[@href='/en/in/globalsites/popup.jsp']"));
		india_link.click();

		//switch to frame
		driver.switchTo().frame(0);
		//click ok button
		WebElement ok_button = driver.findElement(By.xpath("//a[@class='yesLocale']"));
		ok_button.click();
		
		//goto main window
		driver.switchTo().defaultContent();
		System.out.println(driver.getCurrentUrl());
	} //main
} //class
