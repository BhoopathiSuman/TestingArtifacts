package com.advantage.pages.OCAutomation;

import java.text.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advantage.fileutils.PropertyFile;
import com.advantage.framework.Framework;

/**
 * This class is for the SARs Home page
 */

public class CreateNewSARPage extends Framework {
	
	PropertyFile propF;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CreateNewSARPage(WebDriver driver)
	{
		super(driver);	
		propF = new PropertyFile("objectrepository\\OR_CreateNewSARPage.properties");
	}	

	/**
	 * Get/Retrieve Page Header
	 * @return sPgHeader - Page Header
	 */
	public boolean verifyNewSARPage()
	{
		WebDriverWait wait = new WebDriverWait(driver,40);				
		boolean flag = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(propF.getPropertyValue("sLoc_PageHeader")), "Special Authorization Request New"));
		return flag;		
	}	
		
	public  void EnterNewSARData(String sBusiness, String sSARType, String sSegment, String sPricingAnalyst, 
			String sChannel, String sEffDate, String sTermDate, String sDistributor, String sState,
			String sPayer, String sCompSituation, String sCompetitor, String sCompConfMethod, 
			String sCompEffDate, String sCompTermDate, String sCompLearnedDate, String sLearnedFrmName,
			String sLearnedCompany, String sProdName, String sType, String sUnitOfMeasure, String sCurrentPrice,
			String sRequestedPrice, String sVolume, String sTerm) throws ParseException
	{
		selectBusiness(sBusiness);
		selectSARType(sSARType);
		//sleep(2000);
		
		selectSegment(sSegment);
		searchPricingAnalyst(sPricingAnalyst);
		//sleep(4000);		
		selectChannel(sChannel);
		//sleep(2000);
		
		enterEffectiveDate(sEffDate);
		//sleep(2000);
		//checkPageLoading();
		enterTerminationDate(sTermDate);
		//sleep(2000);
		//checkPageLoading();
		searchDistributor(sDistributor);
		//sleep(4000);
		//checkPageLoading();
		selectState(sState);
		selectPayer(sPayer);
		
		selectCompetitiveSituation(sCompSituation);
		searchCompetitor(sCompetitor);
		//sleep(2000);
		//checkPageLoading();
		selectCompetitorConfMethod(sCompConfMethod);
		//enterCompetitorEffectiveDate(sCompEffDate);
		//enterCompetitorTermDate(sCompTermDate);
		enterLearnedFromDate(sCompLearnedDate);
		//sleep(2000);		
		enterLearnedFromName(sLearnedFrmName);
		enterLearnedFromCompany(sLearnedCompany);
		
		clickAddProductLineitemsBtn();
		searchProductName(sProdName);
		//sleep(2000);		
		selectType(sType);
		selectUnitOfMeasure(sUnitOfMeasure);
		enterCurrentPrice(sCurrentPrice);
		enterRequestedPrice(sRequestedPrice);
		enterVolume(sVolume);
		enterTerm(sTerm);
		
		clickSaveButton();
	}
	
	/**
	 * Select Business 
	 * @param sOption
	 */
	public  void selectBusiness(String sOption)
	{
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_DDBusiness"));		
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_DDBusiness"), sOption);			
	}	
	
	/**
	 * Select SAR Type 
	 * @param sOption
	 */
	public  void selectSARType(String sOption)
	{
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_DDSARType"));		
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_DDSARType"), sOption);			
		checkPageLoading();
	}
	
	/**
	 * Select Segment
	 * @param sOption 
	 */
	public  void selectSegment(String sOption)
	{
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_DDSegment"));		
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_DDSegment"), sOption);			
	}	
	
	/**
	 * Select Initiator
	 * @param sSearchString 
	 */
	public  void searchInitiator(String sSearchString)
	{
		 String sParentWindowHandle = driver.getWindowHandle();
		 WebElement lookup = findElement(driver, propF.getPropertyValue("sLoc_InitiatorLookup"));
		 click(lookup, propF.getPropertyValue("sLog_InitiatorLookup"));
		 driver.switchTo().window("Window2");
		 WebElement txtsearch = findElement(driver, propF.getPropertyValue("sLoc_LookupSerchTxtBx"));
		 enterField(txtsearch, propF.getPropertyValue("sLog_LookupSerchTxtBx"), sSearchString);
		 
		 WebElement goBtn = findElement(driver, propF.getPropertyValue("sLoc_LookupGoBtn"));
		 click(goBtn, propF.getPropertyValue("sLog_LookupGoBtn"));
		 
		 driver.findElement(By.linkText(sSearchString)).click();
		 
		 driver.switchTo().window(sParentWindowHandle);			
	}	
	
	/**
	 * Select Pricing Analyst
	 * @param sSearchString 
	 */
	public  void searchPricingAnalyst(String sSearchString)
	{
		 String sParentWindowHandle = driver.getWindowHandle();
		 WebElement lookup = findElement(driver, propF.getPropertyValue("sLoc_PricingAnalystLookup"));
		 click(lookup, propF.getPropertyValue("sLog_PricingAnalystLookup"));
		 sleep(50000);
		 driver.switchTo().window("Window2");
		 //sleep(10000);
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_LookupSerchTxtBx"))));
		 WebElement txtsearch = findElement(driver, propF.getPropertyValue("sLoc_LookupSerchTxtBx"));
		 enterField(txtsearch, propF.getPropertyValue("sLog_LookupSerchTxtBx"), sSearchString);
		 
		 WebElement goBtn = findElement(driver, propF.getPropertyValue("sLoc_LookupGoBtn"));
		 click(goBtn, propF.getPropertyValue("sLog_LookupGoBtn"));
		 
		 driver.findElement(By.linkText(sSearchString)).click();
		 //checkPageLoading();
		 driver.switchTo().window(sParentWindowHandle);			
	}	
	
	/**
	 * Select Channel
	 * @param sOption 
	 */
	public  void selectChannel(String sOption)
	{
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_DDChannel"));		
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_DDChannel"), sOption);			
	}
	
	/**
	 * Enter Effective Date
	 * @param sInputValue 
	 * @throws ParseException 
	 */
	
	public  void enterEffectiveDate(String sInputValue) throws ParseException
	{
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TxtBxEffectiveDate"));		
		enterField(textbox, propF.getPropertyValue("sLog_TxtBxEffectiveDate"), sInputValue);	
		textbox.sendKeys(Keys.TAB);
		//sleep(8000);
		checkPageLoading();
	}
	
	/**
	 * Enter Termination Date
	 * @param sInputValue 
	 */
	public  void enterTerminationDate(String sInputValue)
	{
		sleep(2000);
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TxtBxTerminationDate"));		
		enterField(textbox, propF.getPropertyValue("sLog_TxtBxTerminationDate"), sInputValue);
		textbox.sendKeys(Keys.TAB);
	}
	
	/**
	 * Select Distributor
	 * @param sSearchString 
	 */
	public  void searchDistributor(String sSearchString)
	{
		 String sParentWindowHandle = driver.getWindowHandle();
		 WebElement lookup = findElement(driver, propF.getPropertyValue("sLoc_DistributorLookup"));
		 click(lookup, propF.getPropertyValue("sLog_DistributorLookup"));
		 driver.switchTo().window("Window2");
		 //sleep(10000);
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_LookupSerchTxtBx"))));
		 WebElement txtsearch = findElement(driver, propF.getPropertyValue("sLoc_LookupSerchTxtBx"));
		 enterField(txtsearch, propF.getPropertyValue("sLog_LookupSerchTxtBx"), sSearchString);
		 
		 WebElement goBtn = findElement(driver, propF.getPropertyValue("sLoc_LookupGoBtn"));
		 click(goBtn, propF.getPropertyValue("sLog_LookupGoBtn"));
		 checkPageLoading();
		 driver.findElement(By.linkText(sSearchString)).click();
		 //checkPageLoading();
		 driver.switchTo().window(sParentWindowHandle);	
		 sleep(5000);
	}	
	
	
	/**
	 * Select Sate
	 * @param sOption 
	 */
	public  void selectState(String sOption)
	{
		//WebElement dropdown = findElement(driver, sLoc_DDStateLeftRegion);		
		//dropDownSelect(dropdown, sLog_DDStateLeftRegion, sOption);
		sleep(5000);
		WebElement dropdown= driver.findElement(By.cssSelector("option[title=\"" + sOption +"\"]"));
		dropdown.click();
		Actions oAction=new Actions(driver);
		oAction.doubleClick().perform();
		sleep(5000);
	}
	
	/**
	 * Select payer
	 * @param sOption 
	 */
	public  void selectPayer(String sOption)
	{
		//WebElement dropdown = findElement(driver, sLoc_DDPayerLeftRegion);		
		//dropDownSelect(dropdown, sLog_DDPayerLeftRegion, sOption);	
		WebElement dropdown= driver.findElement(By.cssSelector("option[label=\"" + sOption +"\"]"));
		dropdown.click();
		Actions oAction=new Actions(driver);
		oAction.doubleClick().perform();
		sleep(2000);
	}
	
	/**
	 * Select Competitive Situation
	 * @param sOption 
	 */
	public  void selectCompetitiveSituation(String sOption)
	{
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_DDCompetitiveSituation"));		
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_DDCompetitiveSituation"), sOption);			
	}
	
	/**
	 * Select Competitor
	 * @param sSearchString 
	 */
	public  void searchCompetitor(String sSearchString)
	{
		 String sParentWindowHandle = driver.getWindowHandle();
		 WebElement lookup = findElement(driver, propF.getPropertyValue("sLoc_CompetitorLookup"));
		 click(lookup, propF.getPropertyValue("sLog_CompetitorLookup"));
		 driver.switchTo().window("Window2");
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_LookupSerchTxtBx"))));
		
		 //sleep(10000);
		 WebElement txtsearch = findElement(driver, propF.getPropertyValue("sLoc_LookupSerchTxtBx"));
		 enterField(txtsearch, propF.getPropertyValue("sLog_LookupSerchTxtBx"), sSearchString);
		 
		 WebElement goBtn = findElement(driver, propF.getPropertyValue("sLoc_LookupGoBtn"));
		 click(goBtn, propF.getPropertyValue("sLog_LookupGoBtn"));
		 
		 driver.findElement(By.linkText(sSearchString)).click();
		 //checkPageLoading();
		 driver.switchTo().window(sParentWindowHandle);			
	}	
	
	/**
	 * Select Competitor Conf Method	
	 * @param sOption 
	 */
	public  void selectCompetitorConfMethod(String sOption)
	{
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_DDCompetitorConfMethod"));		
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_DDCompetitorConfMethod"), sOption);			
	}
	
	
	/**
	 * Enter Competitor Effective Date
	 * @param sInputValue 
	 */
	public  void enterCompetitorEffectiveDate(String sInputValue)
	{
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TxtBxCompetitorEffectiveDate"));		
		enterField(textbox, propF.getPropertyValue("sLog_TxtBxCompetitorEffectiveDate"), sInputValue);	
		textbox.sendKeys(Keys.TAB);
	}
	
	/**
	 * Enter Competitor Termination Date
	 * @param sInputValue 
	 */
	public  void enterCompetitorTermDate(String sInputValue)
	{
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TxtBxCompetitorTermDate"));		
		enterField(textbox, propF.getPropertyValue("sLog_TxtBxCompetitorTermDate"), sInputValue);		
		textbox.sendKeys(Keys.TAB);
	}
	
	/**
	 * Enter Learned From Date
	 * @param sInputValue 
	 */
	public  void enterLearnedFromDate(String sInputValue)
	{
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TxtBxCompetitorLearnedDate"));		
		enterField(textbox, propF.getPropertyValue("sLog_TxtBxCompetitorLearnedDate"), sInputValue);		
		textbox.sendKeys(Keys.TAB);
	}
	
	/**
	 * Enter Learned From Name
	 * @param sInputValue 
	 */
	public  void enterLearnedFromName(String sInputValue)
	{
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TxtBxLearnedFromName"));		
		enterField(textbox, propF.getPropertyValue("sLog_TxtBxLearnedFromName"), sInputValue);			
	}
	
	/**
	 * Enter Learned From Company
	 * @param sInputValue 
	 */
	public  void enterLearnedFromCompany(String sInputValue)
	{
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_TxtBxLearnedFromCompany"));		
		enterField(textbox, propF.getPropertyValue("sLog_TxtBxLearnedFromCompany"), sInputValue);			
	}
	
	/**
	 * Click Add Product Line Items Button
	 *  
	 */
	public  void clickAddProductLineitemsBtn()
	{
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_BtnAddProdLineItems"));		
		click(button, propF.getPropertyValue("sLog_BtnAddProdLineItems"));	
		//sleep(10000);
		checkPageLoading();
		WebDriverWait wait = new WebDriverWait(driver,60);				
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(propF.getPropertyValue("sLoc_ProdNameLookup"))));
		
	}
	
	/**
	 * Select Product Name
	 * @param sSearchString 
	 */
	public  void searchProductName(String sSearchString)
	{
		 String sParentWindowHandle = driver.getWindowHandle();
		 WebElement lookup = findElement(driver, propF.getPropertyValue("sLoc_ProdNameLookup"));
		 click(lookup, propF.getPropertyValue("sLog_ProdNameLookup"));
		 driver.switchTo().window("Window2");
		 
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_LookupSerchTxtBx"))));
		 sleep(30000);
		 WebElement txtsearch = findElement(driver, propF.getPropertyValue("sLoc_LookupSerchTxtBx"));
		 enterField(txtsearch, propF.getPropertyValue("sLog_LookupSerchTxtBx"), sSearchString);
		 
		 WebElement goBtn = findElement(driver, propF.getPropertyValue("sLoc_LookupGoBtn"));
		 click(goBtn, propF.getPropertyValue("sLog_LookupGoBtn"));
		 sleep(30000);
		 //checkPageLoading();
		 driver.findElement(By.linkText(sSearchString)).click();
		 sleep(10000);
		 //checkPageLoading();
		 driver.switchTo().window(sParentWindowHandle);			
	}	
	
	/**
	 * Select Type	
	 * @param sOption 
	 */
	public  void selectType(String sOption)
	{
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_DDProdLineItemType"));		
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_DDProdLineItemType"), sOption);	
		sleep(5000);
	}
	
	/**
	 * Select Unit Of Measure	
	 * @param sOption 
	 */
	public  void selectUnitOfMeasure(String sOption)
	{
		WebElement dropdown = findElement(driver, propF.getPropertyValue("sLoc_DDProdLineUnitOfMeasure"));		
		dropDownSelect(dropdown, propF.getPropertyValue("sLog_DDProdLineUnitOfMeasure"), sOption);	
		sleep(5000);
		//checkPageLoading();
	}
	
	/**
	 * Enter Current Price
	 * @param sInputValue 
	 */
	public  void enterCurrentPrice(String sInputValue)
	{
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_txtBxCurrentPrice"));		
		enterField(textbox, propF.getPropertyValue("sLog_txtBxCurrentPrice"), sInputValue);			
	}
	
	/**
	 * Enter Requested Price
	 * @param sInputValue 
	 */
	public  void enterRequestedPrice(String sInputValue)
	{
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_txtBxRequestedPrice"));		
		enterField(textbox, propF.getPropertyValue("sLog_txtBxRequestedPrice"), sInputValue);			
	}
	
	/**
	 * Enter Volume
	 * @param sInputValue 
	 */
	public  void enterVolume(String sInputValue)
	{
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_txtBxVolume"));		
		enterField(textbox, propF.getPropertyValue("sLog_txtBxVolume"), sInputValue);			
	}
	
	/**
	 * Enter Term
	 * @param sInputValue 
	 */
	public  void enterTerm(String sInputValue)
	{
		WebElement textbox = findElement(driver, propF.getPropertyValue("sLoc_txtBxTerm"));		
		enterField(textbox, propF.getPropertyValue("sLog_txtBxTerm"), sInputValue);			
	}
	
	/**
	 * Click Save Button
	 * 
	 */
	public  void clickSaveButton()
	{
		WebElement button = findElement(driver, propF.getPropertyValue("sLoc_BtnSave"));		
		click(button, propF.getPropertyValue("sLog_BtnSave"));
		sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,40);				
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(propF.getPropertyValue("sLoc_PageHeader")), "Special Authorization Request"));
	}
	
	/**
	 * Select Level1 Approver
	 * @param sSearchString 
	 */
	public  void searchLevel1Approver(String sSearchString)
	{
		 String sParentWindowHandle = driver.getWindowHandle();
		 WebElement lookup = findElement(driver, propF.getPropertyValue("sLoc_Level1Lookup"));
		 click(lookup, propF.getPropertyValue("sLog_Level1Lookup"));
		 driver.switchTo().window("Popup");
		 //sleep(10000);
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propF.getPropertyValue("sLoc_LookupSerchTxtBx"))));
		 WebElement txtsearch = findElement(driver, propF.getPropertyValue("sLoc_LookupSerchTxtBx"));
		 enterField(txtsearch, propF.getPropertyValue("sLog_LookupSerchTxtBx"), sSearchString);
		 
		 WebElement goBtn = findElement(driver, propF.getPropertyValue("sLoc_LookupGoBtn"));
		 click(goBtn, propF.getPropertyValue("sLog_LookupGoBtn"));
		 checkPageLoading();
		 driver.findElement(By.linkText(sSearchString)).click();
		 //checkPageLoading();
		 driver.switchTo().window(sParentWindowHandle);			
	}
	
	/**
	 * Verify Page Loading
	 * 
	 */
	public void checkPageLoading()
	{
		WebDriverWait wait = new WebDriverWait(driver,40);				
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(propF.getPropertyValue("sLoc_PageLoad"))));		
		
	}
	
	
}
