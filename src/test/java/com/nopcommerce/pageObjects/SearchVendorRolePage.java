package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchVendorRolePage {

	
	public WebDriver driver;
	
	public SearchVendorRolePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	
	//locators
	By lnkVendors=By.xpath("//span[contains(text(),'Vendors')]");
	By txtSearchName=By.id("SearchName");
	By searchBtn=By.id("search-vendors");
	
	
	//methods
	
	public void clickOnVendorLnk()
	{
	    driver.findElement(lnkVendors).click();  
	}
	
	public void setSearchName(String name)
	{
		driver.findElement(txtSearchName).sendKeys(name);
	}
	
	public void clickOnSearchBtn()
	{
		driver.findElement(searchBtn).click();
	}
	
	public boolean verifyingVendorEmail(String email)
	{  
		String act_email=driver.findElement(By.xpath("//table//tbody//tr//td[2]")).getText();
		if(act_email.equals(email))
		{
			return true;
		}
		else
		{
			return false;
		}
	 
	}
}
