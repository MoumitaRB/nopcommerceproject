package com.nopcommerce.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.TestBaseClass;

public class SearchCustomerByName_005 extends TestBaseClass {
	
	public LoginPage lp;
	public AddCustomerPage addcust;
	public SearchCustomerPage searchcust;
	
	
	@Test(priority=1)
	public void searchCustomerByName() throws InterruptedException, IOException
	{
		logger.info("*********************Starting SearchCustomerByName_005*********************");
		driver.get(configPropObj.getProperty("baseURL"));
	    lp=new LoginPage(driver);
	   
		lp.setUserName(configPropObj.getProperty("userEmail"));
		lp.setPassword(configPropObj.getProperty("passWord"));
		lp.clickOnLoginBtn();
		
		
		addcust=new  AddCustomerPage(driver);
		addcust.clickOnCustomerMenu();
		addcust.clickOnCustomerMenuItems();
	
		//providing name details
		searchcust=new SearchCustomerPage(driver);
		searchcust.setFirstName("James");
		searchcust.setLastName("Pan");
		searchcust.clickOnSearchBtn();
		Thread.sleep(5000);
		
		boolean status=searchcust.searchByName("James Pan1");
		if(status==true)
		{   
			logger.info("*********************SearchCustomer by name is passed*****************************");
			Assert.assertTrue(true);
		}
		else
		{   
			
			logger.info("*********************SearchCustomer by name is passed*****************************");
			captureScreen(driver,"searchCustomerByName");
			Assert.assertTrue(false);
		
		}
		
	
		logger.info("************************End of SearchCustomerByName_005**************************");

		
	}	
	
}
	
	
	
	
	
	
	
	


