package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.TestBaseClass;

public class SearchCustomerByEmail_004 extends TestBaseClass {
    
	public LoginPage lp;
	public AddCustomerPage addcust;
	public SearchCustomerPage searchcust;
	
	
	@Test
	public void searchCustomerByEmailTest() throws InterruptedException, IOException
	{
		logger.info("*********************Starting SearchCustomerByEmail_004*********************");
		driver.get(configPropObj.getProperty("baseURL"));
	    lp=new LoginPage(driver);
	   
		lp.setUserName(configPropObj.getProperty("userEmail"));
		lp.setPassword(configPropObj.getProperty("passWord"));
		lp.clickOnLoginBtn();
	    
		addcust=new  AddCustomerPage(driver);
		addcust.clickOnCustomerMenu();
		addcust.clickOnCustomerMenuItems();
		
	   
	    //proving email id
		searchcust=new SearchCustomerPage(driver);
		searchcust.setEmailid("arthur_holmes@nopCommerce.com");
		searchcust.clickOnSearchBtn();
		Thread.sleep(5000);
		
		boolean status=searchcust.searchByEmail("arthur_holmes@nopCommerce.com");
		if(status==true)
		{	
		   logger.info("*********************SearchCustomer by email is Passed*****************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.info("*********************SearchCustomer by email is Failed*****************************");
			captureScreen(driver, "searchCustomerByEmailTest");
			Assert.assertTrue(false);
		}
		
	   logger.info("**********************End of SearchCustomerByEmail_004*****************************");
	}
	

}
