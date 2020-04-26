package com.nopcommerce.testCases;

import java.io.IOException;

import org.sikuli.script.SikuliException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCatalogPage;
import com.nopcommerce.testBase.TestBaseClass;

public class ImportExcelFile_009 extends TestBaseClass{
	
	public LoginPage lp;
	public SearchCatalogPage  catalogpage;
	
	@Test
	public void verifyingimportExcelFile() throws InterruptedException, SikuliException, IOException
	{  
		logger.info("************************Starting ImportExcelFile_009************************" );
		
		driver.get(configPropObj.getProperty("baseURL"));
		lp=new LoginPage(driver);
		lp.setUserName(configPropObj.getProperty("userEmail"));
		lp.setPassword(configPropObj.getProperty("passWord"));
		lp.clickOnLoginBtn();
		
		catalogpage=new SearchCatalogPage(driver);
		catalogpage.clickOnCatalogMenu();
		catalogpage.clickOnListCatagories();
		catalogpage.clickOnImportBtn();
		Thread.sleep(3000);
		catalogpage.uploadImportExcelFile("C:\\excelData\\ImportExcel.xlsx");
		Thread.sleep(3000);
		
		boolean status=catalogpage.verifyingCofirmMsg("Categories have been imported successfully.");
		if(status==true)
		{   
			logger.info("***********************Import excel file is successfull********************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("*************************Import Excel file is not successfull*********************");
			captureScreen(driver,"verifyingimportExcelFile");
			Assert.assertTrue(false);
		}
		
		logger.info("**************************End of ImportExcelFile_009****************************");
	}
}
