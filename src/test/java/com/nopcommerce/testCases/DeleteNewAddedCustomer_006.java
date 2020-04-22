package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.TestBaseClass;


public class DeleteNewAddedCustomer_006 extends TestBaseClass {
	public LoginPage lp;
    public AddCustomerPage addcust;
    public SearchCustomerPage searchcust;
    
    @Test
    public void deleteNewCustomer() throws InterruptedException, IOException
    {  
    	
    	logger.info("**********************Starting DeleteAddCustomer_006*************************");
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
		searchcust.deleteNewAddedName("SarahJohn");
		boolean status1=searchcust.verifyingDeleteMsg();
		if(status1==true)
		{   
			logger.info("***************************New customer deleted successfully**************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("**************************New customer did not delete successfully*********************");
			captureScreen(driver, "deleteNewCustomer");
			Thread.sleep(3000);
			Assert.assertTrue(false);
		}
		
		
		Thread.sleep(3000);
		
		logger.info("***************************End of DeleteAddCustomer_006************************** ");
		
		
    }
    
    
	


}
