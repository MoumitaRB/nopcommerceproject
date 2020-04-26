package com.nopcommerce.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

public class ConfigurationPage {
	
	public WebDriver ldriver;
	
	
	public ConfigurationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	//locator
	
	@FindBy(xpath="//a[@href='#']//span[contains(text(),'Configuration')]")
	@CacheLookup
	WebElement configuration_menu;
	
	@FindBy(xpath="//span[contains(text(),'Countries')]")
	@CacheLookup
	WebElement listmenu_countries;
	
	@FindBy(name="importcsv")
	@CacheLookup
	WebElement importBtn;
	
	@FindBy(id="importcsvfile")
	@CacheLookup
	WebElement choosefile;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	@CacheLookup
	WebElement importfromcsvBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
	@CacheLookup
	WebElement cfmText;
	
	//actions
	
	public void clickOnConfigurationTab()
	{
		configuration_menu.click();
	}
	
	public void clickOnCountryList()
	{
		listmenu_countries.click();
	}
    
	public void clickOnImportStatesFromCvs()
	{
		importBtn.click();
	}
	public void uploadImportCvsFile(String path) throws InterruptedException, SikuliException
	{
		choosefile.sendKeys(path);
		
	/*	JavascriptExecutor js= (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", choosefile);
		
		Thread.sleep(3000);
		
		Screen s=new Screen();
		Pattern fileInputTextBox=new Pattern("C:\\SikuliPics\\TextBox.png");
		Pattern openBtn= new Pattern("C:\\SikuliPics\\OpenBtn1.png");
		
		s.wait(fileInputTextBox,4);
		s.type(fileInputTextBox, path);
		s.click(openBtn);
	*/
		Thread.sleep(3000);
	    importfromcsvBtn.click();
		Thread.sleep(4000);
		
	}
	
	public boolean verifyingConfirmMsg(String exp_text)
	{  
		boolean flag=false;
		String act_text=cfmText.getText();
		if(act_text.contains(exp_text))
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		return flag;
		
	}
	
	
}
