package com.advantage.pages.OCAutomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advantage.fileutils.PropertyFile;
import com.advantage.framework.Framework;
import com.advantage.reporting.Report;

/**
 * This class is for the SARs Home page
 */

public class SARDetailPage extends Framework {
	
	PropertyFile propF;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public SARDetailPage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_SARDetaiilPage.properties");
		
	}	
	
	/**
	 * Get SARID
	 * 
	 */
	public void getSARDetails()
	{
		List<String> sarDtl = new ArrayList<String>();
		List<WebElement> sarInfo = findElements(driver, propF.getPropertyValue("sLoc_SARInformation"));		
		
	    for(WebElement ul : sarInfo){		
	    	
	    	sarDtl.add(ul.getText());	    	
	    	  
	    }

	    for(int i=0; i<sarDtl.size(); i++) {
	    	System.out.println(sarDtl.get(i));
	    }
	}		

	/**
	 * Get SARID
	 * 
	 */
	public String getSARID()
	{
		List<String> sarDtl = new ArrayList<String>();
		String sID = null;
		List<WebElement> sarInfo = findElements(driver, propF.getPropertyValue("sLoc_SARInformation"));		
		
	    for(WebElement ul : sarInfo){		
	    	
	    	sarDtl.add(ul.getText());	    	
	    	  
	    }

	    for(int i=0; i<sarDtl.size(); i++) {
	    	if(sarDtl.get(i).contains("SAR ID")){
	    		sID = sarDtl.get(i).toString().split("ID")[1];	   
	    		sID = sID.split("SAR Status")[0];
	    	}
	    	
	    }
		return sID;
	}	
	
	
	/**
	 * Get SAR Status
	 * 
	 */
	public String getSARStatus()
	{
		List<String> sarDtl = new ArrayList<String>();
		String sStatus = null;
		String sStatus1 = null;
		List<WebElement> sarInfo = findElements(driver, propF.getPropertyValue("sLoc_SARInformation"));		
		
	    for(WebElement ul : sarInfo){		
	    	
	    	sarDtl.add(ul.getText());	    	
	    	  
	    }

	    for(int i=0; i<sarDtl.size(); i++) {
	    	if(sarDtl.get(i).contains("SAR Status")){
	    		sStatus = sarDtl.get(i).toString().split("Status")[1];	    		
	    		//sStatus1 = sStatus.split("Business")[0].toString().split("Draft")[1];
	    		
	    	}
	    	
	    }
	    System.out.println(sStatus);
		return sStatus;
	}	
		
	/**
	 * Click on Submit to Pricing Analyst Button
	 */
	public void clickPAButton(){
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_SubmitToPABtn"));
		click(button, propF.getPropertyValue("sLog_SubmitToPABtn"));
	}
	
	/**
	 * Accept Alert Message
	 */
	public String getAlertMsg(){
		WebDriverWait wait = new WebDriverWait(driver,40);				
		 wait.until(ExpectedConditions.alertIsPresent());	
		 return workWithAlert(driver, true, false);		 
	}
	
	/**
	 * Check Submit To PA button invisible
	 */
	public boolean checkSubmitToPABtn(){
		WebDriverWait wait = new WebDriverWait(driver,40);				
		 boolean flag =wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_SubmitToPABtn"))));	
		 return flag; 
	}
	
	/**
	 * Click Submit for Approval Button
	 */
	public void clickSubmitForApprovalBtn(){
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_SubmitForApprovalBtn"));
		click(button, propF.getPropertyValue("sLog_SubmitForApprovalBtn"));
	}
	
	/**
	 * Verify Level 1 Approver Assigned
	 * @param sInputValue - Approver name
	 * @return boolean - true/false
	 */
	public boolean verifyLevel1Approver(String sInputValue)
	{
		List<String> sarDtl = new ArrayList<String>();
		String sID = null;
		List<WebElement> sarInfo = findElements(driver, propF.getPropertyValue("sLoc_SARInformation"));		
		
	    for(WebElement ul : sarInfo){		
	    	
	    	sarDtl.add(ul.getText());	    	
	    	  
	    }

	    for(int i=0; i<sarDtl.size(); i++) {
	    	if(sarDtl.get(i).contains(sInputValue)){
	    		return true;
	    	}
	    	
	    }
		return false;
	}
	
	public boolean getStatus()
	{
		List<String> sarDtl = new ArrayList<String>();
		String sID = null;
		List<WebElement> sarInfo = findElements(driver, propF.getPropertyValue("sLoc_SARInformation"));		
		
	    for(WebElement ul : sarInfo){		
	    	
	    	sarDtl.add(ul.getText());	    	
	    	  
	    }

	    for(int i=0; i<sarDtl.size(); i++) {
	    	if(sarDtl.get(i).contains("SAR Status QA")){
	    		return true;
	    	}
	    	
	    }
		return false;
	}	
	
	public boolean verifyStatus(String sSARStatus)
	{
		ArrayList sar = new ArrayList<String>();
		WebElement dtl = findElement(driver, propF.getPropertyValue("sLoc_SARInformation"));
		List<WebElement> RowSARInfo = dtl.findElements(By.tagName("tr"));
		String sSubject = null, sStatus=null, sChannel = null, sQueueName = null;
		
		for(WebElement ul : RowSARInfo){
					
			sar.add(ul.getText());
		}
		
		String[] rowData = sar.toString().split(",");
			
		for(int i=0; i<rowData.length; i++) { 
			
			if(rowData[i].contains("SAR Status")){
				sStatus = rowData[i].split("Status")[1];	
				
			}	
		}
		
		if((sStatus.contains(sSARStatus))) {	    			
			return true;				    		
		}	    	
		return false;
	}	
	
	/**
	 * Click on Edit link
	 * 
	 */
	public void clickApproveRejectLink()
	{
		//findElement(driver, sLoc_lnkApproveReject).click();
		driver.findElement(By.linkText(propF.getPropertyValue("sLoc_ActionLink"))).click();
	}
	
	/**
	 * Click on Edit link
	 * 
	 */
	public void EnterCommentToSAR(String sComment)
	{
		WebElement textarea = findElement(driver, propF.getPropertyValue("sLoc_txtAreaComments"));
		textarea.sendKeys(sComment);
		sleep(10000);
	}
	
	public void clickActionButton(String sActionName){
		WebElement button;
		if(sActionName.equalsIgnoreCase("Approve")){
			button = findElement(driver, propF.getPropertyValue("sLoc_AprroveBtn"));
			click(button, propF.getPropertyValue("sLog_AprroveBtn"));
		}
		else if(sActionName.equalsIgnoreCase("Reject")){
			button = findElement(driver, propF.getPropertyValue("sLoc_RejectBtn"));
			click(button, propF.getPropertyValue("sLog_RejectBtn"));
		} 
		else if(sActionName.equalsIgnoreCase("Cancel")){
			button = findElement(driver, propF.getPropertyValue("sLoc_CancelBtn"));
			click(button, propF.getPropertyValue("sLog_CancelBtn"));
		}
		else {
			Report.logInfo("Invalid Action Name");
		}
		WebDriverWait wait = new WebDriverWait(driver,40);				
		boolean flag = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(propF.getPropertyValue("sLoc_PageHeader")), "Special Authorization Request"));
		sleep(30000);
	}
	
	/**
	 * Click on Marked As Closed Button
	 */
	public void clickClosedButton(){
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_MarkedAsClosedBtn"));
		click(button, propF.getPropertyValue("sLog_MarkedAsClosedBtn"));
		WebDriverWait wait = new WebDriverWait(driver,40);				
		boolean flag = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(propF.getPropertyValue("sLoc_PageHeader")), "Special Authorization Request"));
		
		sleep(30000);
	}
	
	/**
	 * Verify Pending Status of SAR
	 */
	public boolean verifyPendingStatus(){
		WebElement status = findElement(driver, propF.getPropertyValue("sLoc_SARStatusIncdicator"));
		if(status.getText().toString().equalsIgnoreCase("Pending")){
			return true;
		}
		return false;
	}
	
	/**
	 * Click on Edit Button
	 */
	public void clickEditButton(){
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_EditBtn"));
		click(button, propF.getPropertyValue("sLog_EditBtn"));
	}
	
}
