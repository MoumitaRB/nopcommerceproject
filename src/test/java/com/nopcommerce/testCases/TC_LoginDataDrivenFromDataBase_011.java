package com.nopcommerce.testCases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.TestBaseClass;
import com.nopcommerce.utilities.DataBaseUtils;

public class TC_LoginDataDrivenFromDataBase_011 extends TestBaseClass{
	
	public LoginPage lp;
	
	
	@Test(dataProvider="getTestData")
	public void verifyingLoginData(String email, String pword,String exp) throws InterruptedException
	{    
	    logger.info("**********************Starting TC_LoginDataDrivenFromDataBase_011*******************************");
	    
		driver.get(configPropObj.getProperty("baseURL"));
	    lp=new LoginPage(driver);
		lp.setUserName(email);
		lp.setPassword(pword);
		lp.clickOnLoginBtn();
		
		Thread.sleep(5000);
		
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		
		logger.info("***************************validation********************************");
		
		if(act_title.equals(exp_title))
		{
			if(exp.equals("Pass"))
			{   
				logger.info("*******************LoginTest is Passed********************");
				lp.clickOnLogoutBtn();
				Assert.assertTrue(true);
			}
			else if(exp.equals("Fail"))
			{
				logger.warn("******************LoginTest is Failed*******************" );
				lp.clickOnLogoutBtn();
				Assert.assertTrue(false);
			}
		}
		
		if(!act_title.equals(exp_title))
		{
			if(exp.equals("Pass"))
			{
				logger.warn("*********************LoginTest is failed************************");
				lp.clickOnLogoutBtn();
				Assert.assertTrue(false);
			}
			else if(exp.equals("Fail"))
			{
				logger.info("********************LoginTest is Passed*******************");
				lp.clickOnLogoutBtn();
				Assert.assertTrue(true);
			}
		  }
		  logger.info("**************Finished TC_LoginDDT_002***********************" );
		
		
		
		
		
	}
   
	
	@DataProvider
	public Iterator<Object[]>getTestData() throws SQLException
	{
		ArrayList<Object[]>testData= DataBaseUtils.populateData();
        return testData.iterator();
		
	}
}
