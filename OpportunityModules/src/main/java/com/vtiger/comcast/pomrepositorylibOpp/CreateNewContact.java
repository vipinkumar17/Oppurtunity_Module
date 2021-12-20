package com.vtiger.comcast.pomrepositorylibOpp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact  {
	WebDriver driver = null; //global driver variable
	public CreateNewContact(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "firstname")
	private WebElement fn;
	
	@FindBy(name ="lastname")
	private WebElement ln;
	
	@FindBy(name = "button")
	private WebElement saveBtn;
	
	public WebElement getFn() {
		return fn;
	}

	public WebElement getLn() {
		return ln;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createContact(String firstname , String lastname )
	{
		Home h = new Home(driver);
		h.getContactLnk().click();
		Contact ccp = new Contact(driver);
		ccp.getCreateConImg().click();
		fn.sendKeys(firstname);
		ln.sendKeys(lastname);
		saveBtn.click();
	}
}
