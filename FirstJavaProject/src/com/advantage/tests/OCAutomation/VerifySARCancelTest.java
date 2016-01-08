package com.advantage.tests.OCAutomation;


import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.advantage.datastructures.OCAutomation.*;
import com.advantage.fileutils.Excel_poi;
import com.advantage.framework.Framework;
import com.advantage.framework.TestTemplate;
import com.advantage.pages.OCAutomation.*;
import com.advantage.reporting.Logs;
import com.advantage.reporting.Report;


public class VerifySARCancelTest extends TestTemplate {
	
	private static final String VerifySARReject = "runVerifySARReject";
	
	/**i
	 * Initializes all variables from config file
	 * 
	 * @param sUseConfigFile - Configuration file to load variables from
	 */
	@Parameters("sUseConfigFile")
	@BeforeSuite(groups = "setup")
	// @Override
	public void initialization(@Optional(CONFIG_FILE) String sUseConfigFile)
	{
		
	}
	
	/**
	 * Gets data driven values for the test. (This is used for both positive & negative tests.)
	 * 
	 * @param m
	 * @return data for testNG
	 */
	@DataProvider(name = "DataFromExcel")
	public static Object[][] dataForLogin1(Method m)
	{
		String sTestDataFilePath;		
		sTestDataFilePath = ConfigInfo.getTestDataPath() + "\\testdata_CreateNewSAR.xlsx";		
		
		System.out.println(sTestDataFilePath);
		// Object array for testNG
		Object[][] testngDataObject = null;
		
		String sBusiness=null, sSARType=null, sSegment=null, sPricingAnalyst=null, 
		sChannel=null, sEffDate=null, sTermDate=null, sDistributor=null, sState=null,
		sPayer=null, sCompSituation=null, sCompetitor=null, sCompConfMethod=null, 
		sCompEffDate=null, sCompTermDate=null, sCompLearnedDate=null, sLearnedFrmName=null,
		sLearnedCompany=null, sProdName=null, sType=null, sUnitOfMeasure=null, sCurrentPrice=null,
		sRequestedPrice=null, sVolume=null, sTerm=null, sLevel1Approver=null;
		
		Excel_poi excel;
		try
		{
			excel = new Excel_poi(sTestDataFilePath, "CreateNewSAR");
			
			int iRowCount = excel.getExcelRowCount();
			int iColCount = excel.getExcelColumnCount();
			
			System.out.println(iRowCount);
			System.out.println(iColCount);
			
			// Initialize array which will store the test data			
			testngDataObject = new Object[1][2];
			
			// Loop through all the test cases and load the data into the array
			for (int i = 0; i < 1; i++)
			{
			
				// Construct the xpath to the specific test case
					
					List<CreateNewSARDetails> createNewSARtDtl = new ArrayList<CreateNewSARDetails>();
					String[][] dataexcel= excel.getExcelSheetData();	
					
					LoginDetails details = null;

					for(int j=1;j<iRowCount;j++){
						for( int k=0;k<iColCount;k++) {					
						
							if(dataexcel[0][k].equals("Business")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sBusiness = dataexcel[j][k];
								}
																	
							}
							else if(dataexcel[0][k].equals("SARType")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sSARType = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Segment")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sSegment = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("PricingAnalyst")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sPricingAnalyst = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Channel")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sChannel = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("EffectiveDate")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									System.out.println(dataexcel[j][k]);
									sEffDate = dataexcel[j][k];
									System.out.println(sEffDate);
								}
							}
							else if(dataexcel[0][k].equals("TerminationDate")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sTermDate = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Distributor")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sDistributor = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("State")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sState = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Payer")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sPayer = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("CompetitiveSituation")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sCompSituation = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Competitor")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sCompetitor = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("CompetitorConfMethod")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sCompConfMethod = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("CompEffectiveDate")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sCompEffDate = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("CompTermDate")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sCompTermDate = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("LearnedFromDate")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sCompLearnedDate = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("LearnedFromName")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sLearnedFrmName = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("LearnedFromCompany")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sLearnedCompany = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("ProductName")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sProdName = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Type")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sType = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("UnitOfMeasure")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sUnitOfMeasure = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("CurrentPrice")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sCurrentPrice = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("RequestedPrice")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sRequestedPrice = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Volume")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sVolume = dataexcel[j][k];
								}
							}
							else if(dataexcel[0][k].equals("Term")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sTerm = dataexcel[j][k];
								}
							}	
							else if(dataexcel[0][k].equals("Level1Approver")){
								if(dataexcel[j][k].equals("")){
									continue;
								}
								else {
									sLevel1Approver = dataexcel[j][k];
								}
							}	
							else {
								Logs.logWarning("Invalid excel column name");
							}						
						}		
						
						// Instantiate the objects
						details = new LoginDetails(ConfigInfo.getASMsUserName(),ConfigInfo.getsASMPassword());		
										
						createNewSARtDtl.add(new CreateNewSARDetails(sBusiness, sSARType, sSegment, sPricingAnalyst, 
								sChannel, sEffDate, sTermDate, sDistributor, sState,
								sPayer, sCompSituation, sCompetitor, sCompConfMethod, 
								sCompEffDate, sCompTermDate, sCompLearnedDate, sLearnedFrmName,
								sLearnedCompany, sProdName, sType, sUnitOfMeasure, sCurrentPrice,
								sRequestedPrice, sVolume, sTerm, sLevel1Approver));							
					}	
					
					// Put in the object array for testNG
					testngDataObject[i][0] = details;
					
					// Put in the object array for testNG				
					testngDataObject[i][1] = createNewSARtDtl;					
				}
			
		}
		
		catch (Exception ex)
		{
			Logs.logError("Unable to read test data", ex);
			browser.quitBrowser();
			System.exit(0);
		}			
		
		return testngDataObject;
	}
	
	/**
	 * Test the create new user functionality
	 * 
	 * 
	 * @param details - Login detail variables
	 * @param lstNewUser - List of new user test case
	 * @throws InterruptedException 
	 * @throws ParseException 
	 */

	@Test(dataProvider = "DataFromExcel")
	public static void runVerifySARReject(LoginDetails details, List<CreateNewSARDetails> createNewSARtDtl) throws InterruptedException, ParseException
	{
		/* Test case initiation */
		
		Report.logTitle(Framework.getNewLine() + "Method " + VerifySARReject + " executing ..."
				+ Framework.getNewLine());		
		setScreenshotPreferences();
					
		/* Login to application */		
		Login loginPage = new Login(driver);
		HomePage homePage = new HomePage(driver);
		SARsHomePage SARPage = new SARsHomePage(driver);
		CreateNewSARPage createNewSAR = new CreateNewSARPage(driver);
		SARDetailPage SARDtlPage = new SARDetailPage(driver);
		
		try{
			for(CreateNewSARDetails createlead:createNewSARtDtl){			
				
				loginPage.loginAs(details.sUserName, details.sPassword);
				
				if(homePage.verifyHomePage()==true){
					Report.logPass("User logged in successfully to the application");
				}
				else {
					Report.logError("Login failed to the application");
				}	
				
				if(homePage.clickTab("SARs") ==true){
					Report.logPass("SARs tab is visible and clickable.");
				}
				else {
					Report.logError("SARs is not visible and clickable.");
				}
				
				SARPage.clickNewButton();
				
				
				if(createNewSAR.verifyNewSARPage()== true){
					Report.logPass("Create New SARs page opened successfully.");
				}
				else {
					Report.logError("Failed to open Create New SARs page.");
				}
				
				createNewSAR.EnterNewSARData(createlead.sBusiness, createlead.sSARType, createlead.sSegment, 
						createlead.sPricingAnalyst, createlead.sChannel, createlead.sEffDate, createlead.sTermDate,
						createlead.sDistributor, createlead.sState, createlead.sPayer, createlead.sCompSituation, 
						createlead.sCompetitor, createlead.sCompConfMethod, createlead.sCompEffDate, 
						createlead.sCompTermDate, createlead.sCompLearnedDate, createlead.sLearnedFrmName,
						createlead.sLearnedCompany, createlead.sProdName, createlead.sType, 
						createlead.sUnitOfMeasure, createlead.sCurrentPrice, createlead.sRequestedPrice, 
						createlead.sVolume, createlead.sTerm);
				
				String sSAR_ID= SARDtlPage.getSARID().trim();
				boolean blnFlag = SARDtlPage.verifyStatus("Draft");
								
				if((sSAR_ID.isEmpty()==false) && (blnFlag==true)){
					Report.logPass("SAR has been created successfully with status as - Draft and its ID is - " + sSAR_ID);
				}
				else{
					Report.logError("Failed to Create SAR.");
				}	
				
				SARDtlPage.clickPAButton();
				SARDtlPage.getAlertMsg();
				boolean flag = SARDtlPage.checkSubmitToPABtn();
				
				if(flag){
					Report.logPass("SAR is submitted to Pricing Analyst.");
				}
				else{
					Report.logError("SAR is not submitted to Pricing Analyst.");
				}
								
				if(SARDtlPage.verifyStatus("QA")==true){
					Report.logPass("SAR has been submitted to Pricing Analyst and its status changed to - QA");				}
				else{
					Report.logError("Submit To Pricing Analyst failed.");
				}
				homePage.clickLogout();	
				homePage.verifyLoginPage();
				//String sSAR_ID="SAR-0000003437";
				loginPage.loginAs(ConfigInfo.getPAsUserName(), ConfigInfo.getsPAPassword());
				//homePage.globalSearch(sSAR_ID);
				homePage.clickSARLink(sSAR_ID);
				
				SARDtlPage.clickEditButton();
				createNewSAR.searchLevel1Approver(createlead.sLevel1Approver);
				createNewSAR.clickSaveButton();
						
				if(SARDtlPage.verifyLevel1Approver(createlead.sLevel1Approver)==true){
					Report.logPass("SAR has been assigned to " + createlead.sLevel1Approver +" who is Level1 Approver");
				}
				else{
					Report.logError("Failed to assign Level 1 Approver.");
				}
				
				if(SARDtlPage.verifyStatus("QA")==true){
					Report.logPass("After assigning Level 1 Approver, SAR is in QA status");
				}
				else{
					Report.logError("After assigning Level 1 Approver, SAR is not in QA status");
				}
				SARDtlPage.clickSubmitForApprovalBtn();
				SARDtlPage.getAlertMsg();
				if(SARDtlPage.verifyStatus("LOA")==true){
					Report.logPass("SAR status changed to LOA after submitting for approval");
				}
				else{
					Report.logError("SAR status has not changed to LOA after submitting for approval");
				}
				homePage.clickLogout();
				homePage.verifyLoginPage();
				loginPage.loginAs(ConfigInfo.getLOAsUserName(), ConfigInfo.getsLOAPassword());
				//homePage.globalSearch("SAR-0000003418");
				homePage.clickSARLink(sSAR_ID);
				SARDtlPage.clickApproveRejectLink();
				SARDtlPage.EnterCommentToSAR("Cancelled");
				SARDtlPage.clickActionButton("Cancel");
				if(SARDtlPage.verifyStatus("LOA")==true){
					Report.logPass("SAR status changed to LOA after submitting for approval");
				}
				else{
					Report.logError("SAR status has not changed to LOA after submitting for approval");
				}
				
				if(SARDtlPage.verifyPendingStatus()==true){
					Report.logPass("SAR status is Pending");
				}
				else{
					Report.logError("SAR status is not Pending");
				}
				homePage.clickLogout();				
			}
			
		}	
		catch(RuntimeException ex){
			Report.logError("Verify SAR Cancelled Test failed.", ex);
		}
	}
}
