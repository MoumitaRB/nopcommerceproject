package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.TestBaseClass;
import com.nopcommerce.utilities.XUtils;

public class TC_LoginDDT_002 extends TestBaseClass {
	public LoginPage lp;
	
	@Test(dataProvider="LoginData")
	public void loginTest(String uname, String pwd, String exp) throws IOException, InterruptedException
	
	{  
		logger.info("***********Starting TC_LoginDDT_002**********");
		
		driver.get(configPropObj.getProperty("baseURL"));
	    lp=new LoginPage(driver);
		
		logger.info("*************Providing login data************");
		lp.setUserName(uname);
		lp.setPassword(pwd);
		lp.clickOnLoginBtn();
		Thread.sleep(5000);
		
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		
		logger.info("***************validation*********************");
		
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
	
	
	@DataProvider(name="LoginData")
	public Object[][]getData() throws Exception
	{   
		String path=System.getProperty("user.dir")+"\\TestData\\LoginData.xlsx";
		int rownum=XUtils.getRowCount(path, "Sheet1");
		int colnum=XUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rownum][colnum];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colnum; j++)
			{
				loginData[i-1][j]=XUtils.getCellData(path, "Sheet1", i, j);
		
		        System.out.print(loginData[i-1][j]+" ");
			}
			System.out.println();
		}
		
		Thread.sleep(3000);
		return loginData;
	}
}
