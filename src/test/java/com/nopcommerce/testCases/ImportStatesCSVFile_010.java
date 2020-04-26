package com.nopcommerce.testCases;

import java.io.IOException;

import org.sikuli.script.SikuliException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.ConfigurationPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.TestBaseClass;

public class ImportStatesCSVFile_010 extends TestBaseClass{
	
	 public LoginPage lp;
	 public ConfigurationPage configpage;
	
	@Test
	public void verifyingImportCSVFile() throws InterruptedException, SikuliException, IOException
	{   
		logger.info("***********************Starting ImportStatesCSVFile_010***************************");
		
		driver.get(configPropObj.getProperty("baseURL"));
		lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("userEmail"));
		lp.setPassword(configPropObj.getProperty("passWord"));
		lp.clickOnLoginBtn();
		
		configpage=new ConfigurationPage(driver);
		
		configpage.clickOnConfigurationTab();
		configpage.clickOnCountryList();
		configpage.clickOnImportStatesFromCvs();
		Thread.sleep(3000);
		configpage.uploadImportCvsFile("C:\\CSVfile\\StatesName.csv");
		Thread.sleep(4000);
		
		boolean status=configpage.verifyingConfirmMsg("75 states have been successfully imported");
		if(status==true)
		{  
			logger.info("******************Import CSV file is successful*****************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("*********************Import CSV file is not successful************************");
			captureScreen(driver, "verifyingImportCSVFile");
			Assert.assertTrue(false);
		}
		
		logger.info("***************************End of ImportStatesCSVFile_010************************");
	}
	
	

}
