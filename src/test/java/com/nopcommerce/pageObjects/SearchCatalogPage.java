package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

public class SearchCatalogPage {
	 public WebDriver ldriver;
	 WebElement choosefile;
	
	public SearchCatalogPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	//locators
	By catalog_menu=By.xpath("//a[@href='#']//span[contains(text(),'Catalog')]");
    By catagories_listmenu= By.xpath("//span[contains(text(),'Categories')]");
    By txtcatagory= By.id("SearchCategoryName");
    By searchBtn=By.id("SearchCategoryName");
    By importBtn=By.name("importexcel");
    By txtexcelfile= By.id("importexcelfile");
    By importfromexcelBtn= By.xpath("//button[@class='btn btn-primary']");
    By confirmtext= By.xpath("//div[@class='alert alert-success alert-dismissable']");
    
    //methods

    public void clickOnCatalogMenu()
    {
    	ldriver.findElement(catalog_menu).click();
    }
    
    public void clickOnListCatagories()
    {
    	ldriver.findElement(catagories_listmenu).click();
    }
    
    public void clickOnImportBtn()
    {
    	ldriver.findElement(importBtn).click();
    }
    
    public void uploadImportExcelFile(String path) throws InterruptedException, SikuliException
    {
    	choosefile=ldriver.findElement(txtexcelfile);
    	JavascriptExecutor js= (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", choosefile);
		
		Thread.sleep(3000);
		
		Screen s= new Screen();
		Pattern fileInputTextBox= new Pattern("C:\\SikuliPics\\TextBox.png");
		Pattern openBtn= new Pattern("C:\\SikuliPics\\OpenBtn1.png");
		s.wait(fileInputTextBox, 4);
    	
		s.type(fileInputTextBox, path);
		s.click(openBtn);
		Thread.sleep(3000);
		ldriver.findElement(importfromexcelBtn).click();
		
		Thread.sleep(4000);
    }
    
   public boolean verifyingCofirmMsg(String Exp_text)
   {  
	  boolean flag=true;
	  String act_text= ldriver.findElement(confirmtext).getText();
	  if(act_text.contains(Exp_text))
	  {
		  flag= true;
	  }
	  else
	  {
		  flag= false;
	  }
	  
	  return flag;
   }
}
