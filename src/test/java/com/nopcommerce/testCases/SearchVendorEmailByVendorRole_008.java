package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchVendorRolePage;
import com.nopcommerce.testBase.TestBaseClass;

public class SearchVendorEmailByVendorRole_008 extends TestBaseClass {
	
	public LoginPage lp;
	public AddCustomerPage addcust;
	public SearchVendorRolePage searchvr;
	
	@Test
	public void SearchVendorEmail() throws InterruptedException, IOException
	{
	    logger.info("****************************Starting of SearchVendorEmailByVendorRole_008**************************");
        driver.get(configPropObj.getProperty("baseURL"));
	    lp=new LoginPage(driver);
	   
		lp.setUserName(configPropObj.getProperty("userEmail"));
		lp.setPassword(configPropObj.getProperty("passWord"));
		lp.clickOnLoginBtn();
		
		addcust=new AddCustomerPage(driver);
		addcust.clickOnCustomerMenu();
		
		searchvr=new SearchVendorRolePage(driver);
		searchvr.clickOnVendorLnk();
		searchvr.setSearchName("Vendor 1");
		searchvr.clickOnSearchBtn();
		boolean status=searchvr.verifyingVendorEmail("vendor1email@gmail.com");
		if(status==true)
		{   
			logger.info("*******************Vendor email search is successfull*******************");
			Assert.assertTrue(true);
		}
		else
		{   logger.warn("************************Vendor email search is not successfull******************");
			captureScreen(driver,"SearchVendorEmail");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		
		logger.info("**********************Ending of SearchVendorEmailByVendorRole_008*************************" );
		
	 }
	

}
