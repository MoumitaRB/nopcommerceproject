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
    
    @Test(priority=1)
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
		searchcust.clickOnCustomerToExportExcel("Victoria Terces");
		
		
    }

	@Test(priority=2, dependsOnMethods="ExportExcelFile")
	public void verifyingExistingFile() throws IOException
	{
		boolean status=searchcust.isFileExist("C:\\Users\\moumi\\Downloads\\customers.xlsx");
		if(status==true)
		{   
			logger.info("**************************Export file is successfull******************************");
			Assert.assertTrue(true);
		}
		else
		{	
		    logger.warn("**************************Export File is not successfull**********************");
		    captureScreen(driver,"ExportExcelFile");
			Assert.assertTrue(false);
		}
		
		logger.info("******************************Ending of ExportExcelFileOfNewCustomer_007*************************");
	}
	
	
}


