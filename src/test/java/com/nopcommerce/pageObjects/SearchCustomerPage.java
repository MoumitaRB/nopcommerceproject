package com.nopcommerce.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileDeleteStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.utilities.XUtils;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	
	
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	
	}
	
	//locators
	
	@FindBy(how=How.ID, using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.ID, using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how=How.ID, using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.ID, using="search-customers")
	@CacheLookup
	WebElement searchBtn;

	@FindBy(how=How.XPATH, using="//div[@class='dataTables_scrollBody']//table//tbody//tr")
	@CacheLookup
	List<WebElement>  tableRows;
	
	@FindBy(how=How.XPATH, using="//div[@class='dataTables_scrollBody']//table//tbody//tr[1]//td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	//extra
	@FindBy(how=How.XPATH, using="//span[@id='customer-delete']")
	@CacheLookup
	WebElement deleteBtn1;
	
	@FindBy(how=How.XPATH, using="//button[@class='btn bg-red pull-right']")
	@CacheLookup
	WebElement deleteBtn2;
	
	@FindBy(how=How.XPATH, using="//div[@class='alert alert-success alert-dismissable']")
	@CacheLookup
	WebElement crfmDeleteTxt;
	
	@FindBy(how=How.XPATH, using="//button[@class='btn btn-success dropdown-toggle']")
	@CacheLookup
	WebElement exportBtn;
	
	@FindBy(how=How.ID, using="exportexcel-selected")
	@CacheLookup
	WebElement exportToExcel;
	
	
	//methods
	
	public void setFirstName(String fName)
	{   
		txtFirstName.clear();
		txtFirstName.sendKeys(fName);
	}
	
    public void setLastName(String lName)
    {
    	txtLastName.clear();
    	txtLastName.sendKeys(lName);
    }
    
    public void setEmailid(String emailid)
    {
    	txtEmail.clear();
    	txtEmail.sendKeys(emailid);
    }
    
    public void clickOnSearchBtn()
    {
    	searchBtn.click();
    }
    
    public int getNoOfRow()
    {
    	return(tableRows.size());
    }
    
    public int getNoOfCol()
    {
    	return(tableColumns.size());
    }
    
    public boolean searchByEmail(String email)
    {  boolean flag=false;
    
    	for(int i=1; i<=getNoOfRow();i++)
    	{
    		String email_id=ldriver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//table//tbody//tr["+i+"]//td[2]")).getText();
    	    System.out.println(email_id);
    		
    		if(email_id.equals(email))
    	    {
    	    	flag=true;
    	    	break;
    	    }
    	    
    	  
    	  }
    	
		return flag;
    	
      }
    
    
    public boolean searchByName(String name)
    {    
    	boolean flag=false;
    	
    	for(int i=1; i<=getNoOfRow(); i++)
    	{
    		String cus_name=ldriver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//table//tbody//tr["+i+"]/td[3]")).getText();
    	    System.out.println(cus_name);
    	    
    	    if(cus_name.equals(name))
    	    {
    	    	flag=true;
    	    	break;
    	    }
    	
        }
    
    	return flag;
    	
    }
    
    public void deleteNewAddedName(String name) throws InterruptedException
    {   
    
    	for(int i=1; i<=getNoOfRow(); i++)
    	{
    		String cus_name=ldriver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//table//tbody//tr["+i+"]/td[3]")).getText();
    		System.out.println(cus_name);
    	    if(cus_name.equals(name))
    	    {
    	    	ldriver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//table//tbody//tr["+i+"]//td[1]//input[1]")).click();
    	    	ldriver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//table//tbody//tr["+i+"]//td[9]//a[1]")).click();
    	    	Thread.sleep(3000);
    	    	deleteBtn1.click();
    	    	deleteBtn2.click();
    	    	break;
    	    	
    	    }
    	    
    	}
    	
    	
      }

	 public boolean verifyingDeleteMsg()
	 {  
		 String delete_msg=crfmDeleteTxt.getText();
		 if(delete_msg.contains("The customer has been deleted successfully."))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		 
	 }

	 
	 public void clickOnExport()
	 {
		 exportBtn.click();
	 }
	 
	 public void clickOnExportToExcel()
	 {
		 exportToExcel.click();
	 }
	 
	 public boolean clickOnCustomerToExportExcel(String name) throws InterruptedException
	 {    boolean flag=false;
		 for(int i=1; i<=getNoOfRow(); i++)
	    	{
	    		String cus_name=ldriver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//table//tbody//tr["+i+"]/td[3]")).getText();
	    		System.out.println(cus_name);
	    	    if(cus_name.equals(name))
	    	    {
	    	    	ldriver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//table//tbody//tr["+i+"]//td[1]//input[1]")).click();
	    	    	clickOnExport();
	    	        clickOnExportToExcel();
	    	        Thread.sleep(4000);
	    	        flag=true;
	    	    }
	    	    else
	    	    {
	    	    	flag=false;
	    	    }

	    	}
            return flag;
	 }    
    
	 
	 public boolean isFileExist(String location)
	 {   
		 File f= new File(location);
		 if(f.exists())
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }

		 
	  }
	 
	 public boolean isEmailExists(String location, String email) throws IOException
	 {    
		    boolean flag=false;
	 
		    String path=location;
			int rownum=XUtils.getRowCount(path, "Customer");
			System.out.println(rownum);
		
			
		  for(int r=1; r<=rownum; r++)
		  {
			String act_email= XUtils.getCellData(path, "Customer", r, 3);
			if(act_email.equals(email)) 
			{
				flag= true;
				break;
			}
			else
			{
				flag= false;
			}
		  }
		  
		   return flag;
		 
	 }
    
	 public boolean isFileDelete(String location)
	 {  
		 File f= new File(location);
		 
		 try {
			 FileDeleteStrategy.FORCE.delete(f);
		 }catch (IOException ioEx) {
			 ioEx.printStackTrace();
			 return false;
		 }
		 return true;
		
	 }
   }