package com.nopcommerce.testCases;

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
	public void importExcelFile() throws InterruptedException, SikuliException
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
		catalogpage.setImportExcelFile("C:\\excelData\\ImportExcel.xlsx");
		Thread.sleep(3000);
		
		boolean status=catalogpage.verifyingCofirmMsg("Categories have been imported successfully.");
		if(status==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
	}
}
