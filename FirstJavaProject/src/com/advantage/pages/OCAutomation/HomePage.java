package com.advantage.pages.OCAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advantage.framework.Framework;
import com.advantage.fileutils.*;

/**
 * This class is for the Login page
 */

public class HomePage extends Framework {
	PropertyFile propF;
	PropertyFile propF1;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public HomePage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_HomePage.properties");
		propF1 = new PropertyFile("objectrepository\\OR_LoginPage.properties");
	}	

	/**
	 * verify BMC logo on Homepage
	 * @return boolean true or false
	 */
	public boolean verifyHomePage()
	{
		WebElement usrNavBtn = findElement(driver, propF.getPropertyValue("sLoc_UserNavBtn"));
		
		if(usrNavBtn.isDisplayed()){
			return true;
		}
		return false;
		
	}	
	
	/**
	 * Logout from application
	 * 
	 */
	public void clickLogout()
	{
		WebElement logo = findElement(driver, propF.getPropertyValue("sLoc_MoreOption"));
		click(logo, propF.getPropertyValue("sLog_MoreOption"));
		WebElement logout = findElement(driver, propF.getPropertyValue("sLoc_Logout"));
		click(logout, propF.getPropertyValue("sLog_Logout"));		
	}	
	
	/**
	 * click on Tab
	 * 
	 */
	public boolean clickTab(String sTabName)
	{
		WebElement tab = driver.findElement(By.linkText(sTabName));
		if((tab.isDisplayed()) && (tab.isEnabled())){
			click(tab, propF.getPropertyValue("sLog_Tab") + "-" + sTabName);
			//sleep(10000);
			return true;
		}
			
		return false;
	}	
	
	/**
	 * Global Search
	 * 
	 */
	public void globalSearch1(String sSearchString)
	{
		sleep(10000);
		
		
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TxtBxSearch"));
		enterField(textbox, propF.getPropertyValue("sLog_TxtBxSearch"), sSearchString);
		//textbox.sendKeys(Keys.ENTER);
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_BtnSearch"));
		
		click(button, propF.getPropertyValue("sLog_BtnSearch"));	
		sleep(5000);
	}	
	
	/**
	 * Click on Edit link
	 * 
	 */
	public void clickEdit1()
	{
		driver.findElement(By.linkText("Edit")).click();	
	}	
	
	/**
	 * Global Search
	 * 
	 */
	public void globalSearch(String sSearchString)
	{
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TxtBxSearch"));
		enterField(textbox, propF.getPropertyValue("sLog_TxtBxSearch"), sSearchString);
		
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_BtnSearch"));
		
		click(button, propF.getPropertyValue("sLog_BtnSearch"));
		sleep(5000);
	}	
	
	/**
	 * Click on Edit link
	 * 
	 */
	public void clickEdit()
	{
		driver.findElement(By.linkText("Edit")).click();	
	}	
	
	/**
	 * Verify Login Page
	 * 
	 */
	public void verifyLoginPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propF1.getPropertyValue("sLoc_UserName"))));
	}	
	
	/**
	 * Click on Edit link
	 * 
	 */
	public void clickSARLink(String sSAR_ID)	{
		
		driver.findElement(By.linkText(sSAR_ID)).click();	
		sleep(10000);		
	}	
	
	
	
}
