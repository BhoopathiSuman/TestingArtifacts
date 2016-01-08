package com.advantage.pages.OCAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advantage.fileutils.PropertyFile;
import com.advantage.framework.Framework;

/**
 * This class is for the SARs Home page
 */

public class SARsHomePage extends Framework {
	
	PropertyFile propF;
		
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public SARsHomePage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_SARsHomePage.properties");
		
	}	

	/**
	 * click on New Button
	 * 
	 */
	public void clickNewButton()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(propF.getPropertyValue("sLov_PageTitleIcon"))));
		//sleep(10000);
		WebElement newBtn = findElement(driver, propF.getPropertyValue("sLoc_NewBtn"));		
		click(newBtn, propF.getPropertyValue("sLog_NewBtn"));		
	}		
		
	
}
