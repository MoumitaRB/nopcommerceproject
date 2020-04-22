package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.TestBaseClass;

public class TC_LoginTest_001 extends TestBaseClass {
	
	public LoginPage lp;
	
	@Test
	public void loginTest() throws IOException, InterruptedException
	
	{  
		logger.info("***********Starting TC_LoginTest_001**********");
		driver.get(configPropObj.getProperty("baseURL"));
		
	    lp=new LoginPage(driver);
	    
	    logger.info("************Providing login details****************");
		lp.setUserName(configPropObj.getProperty("userEmail"));
		lp.setPassword(configPropObj.getProperty("passWord"));
		lp.clickOnLoginBtn();
		
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		logger.info("************Verifying login test************************");
		if(act_title.equals(exp_title))
		{   
			logger.info("*******************Login Test Passed******************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.info("******************Login Test Failed**********************");
			captureScreen(driver,"LoginTest");
			Thread.sleep(3000);
			Assert.assertTrue(false);
		}
		
		
		logger.info("****************Finishing TC_Login_Test_001****************");
	}
	
}
