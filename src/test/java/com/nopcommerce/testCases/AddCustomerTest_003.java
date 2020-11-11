package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.TestBaseClass;

public class AddCustomerTest_003 extends TestBaseClass{
	public LoginPage lp;
	public AddCustomerPage addcust;
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		
		driver.get(configPropObj.getProperty("baseURL"));
		lp=new LoginPage(driver) ;
	    
		lp.setUserName(configPropObj.getProperty("userEmail"));
		lp.setPassword(configPropObj.getProperty("passWord"));
		lp.clickOnLoginBtn();
		
		logger.info("****************Starting AddCustomerTest_003******************");
		
		addcust=new AddCustomerPage(driver);
		addcust.clickOnCustomerMenu();
		addcust.clickOnCustomerMenuItems();
		addcust.clickOnAddNewBtn();
		
		logger.info("***********************Providing Customer details****************************");
		String email=randomString()+"@gamil.com";
		addcust.setEmail(email);
		
		addcust.setPassword("1234");
		addcust.setFirstName("Sarah");
		addcust.setLastName("John");
		addcust.setGender("Female");
		addcust.setDateOfBirth("November 2018","17");
		addcust.setCompany("Wipro");
		addcust.setOnTaxExempt();
		//addcust.setOnNewsLetter();
		addcust.setCustomerRole("Forum Moderators");
		addcust.setManagerOfVendor("Vendor 1");
		addcust.setAdminComment("This is for testing");
		addcust.clickOnSaveBtn();
		
		if(addcust.verifyingConfirmationMsg())
		{
			logger.info("******************New customer added successfully**********************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.warn("***********************New customer did not add seccessfully*********************");
			captureScreen(driver, "addNewCustomer" );
			Assert.assertTrue(false);
			
		}
		
		logger.info("************************Finishing AddCustomerTest_003****************************");
		Thread.sleep(3000);
		
		
	}
	
	

}
