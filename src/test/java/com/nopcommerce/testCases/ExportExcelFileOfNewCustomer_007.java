package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.TestBaseClass;



public class ExportExcelFileOfNewCustomer_007 extends TestBaseClass{

	
	public LoginPage lp;
    public AddCustomerPage addcust;
    public SearchCustomerPage searchcust;
    
    @Test
    public void ExportExcelFile() throws InterruptedException
    {   
    	logger.info("*******************Starting ExportExcelFileOfNewCustomer_007**********************");
    	driver.get(configPropObj.getProperty("baseURL"));
	    lp=new LoginPage(driver);
	   
		lp.setUserName(configPropObj.getProperty("userEmail"));
		lp.setPassword(configPropObj.getProperty("passWord"));
		lp.clickOnLoginBtn();
		
		addcust=new  AddCustomerPage(driver);
		addcust.clickOnCustomerMenu();
		addcust.clickOnCustomerMenuItems();
		Thread.sleep(3000);
		
		searchcust=new SearchCustomerPage(driver);
		boolean status=searchcust.clickOnCustomerToExportExcel("Victoria Terces");
		if(status==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
    }

	@Test
	public void verifyingExistingFile() throws IOException, InterruptedException
	{
		boolean status=searchcust.isFileExist("C:\\Users\\moumi\\Downloads\\customers.xlsx");
		if(status==true)
		{   
			logger.info("**************************Export File is successfull******************************");
			Assert.assertTrue(true);
		}
		else
		{	
		    logger.warn("**************************Export File is not successfull**********************");
		    captureScreen(driver,"ExportExcelFile");
			Assert.assertTrue(false);
		}
		
		logger.info("******************************Ending of ExportExcelFileOfNewCustomer_007*************************");
		Thread.sleep(7000);
	}
	
    @Test
    public void verifyingExistingEmail() throws IOException, InterruptedException 
    {  
    	
    	boolean status=searchcust.isEmailExists("C:\\Users\\moumi\\Downloads\\customers.xlsx", "victoria_victoria@nopCommerce.com");
    	Thread.sleep(4000);
    	if(status==true)
    	{   
    		logger.info("***********************Email exists in Excel*******************************");
    		Assert.assertTrue(true);
    	}
    	else
    	{   
    		logger.warn("**************************Email dose not exists*****************************");
    		captureScreen(driver, "ExportExcelFile");
    		Assert.assertTrue(false);
    	}
    	logger.info("******************************Ending of ExportExcelFileOfNewCustomer_007*************************");
    }
    
    
//    @Test(priority=4)
//    public void verifyingDeletedFile() throws InterruptedException
//    {   
//    	Thread.sleep(3000);
//    	boolean status=searchcust.isFileDelete("C:\\Users\\moumi\\Downloads\\customers.xlsx");
//    	Thread.sleep(3000);
//    	if(status==true)
//    	{
//    		Assert.assertTrue(true);
//    	}
//    	else
//    	{
//    		Assert.assertTrue(false);
//    	}
//    }
    
	
}


