package com.vtiger.comcast.pomrepositorylibOpp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebdriverUtilty;

public class Home {
	WebDriver driver = null; //global driver variable
	public Home(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;

	@FindBy(linkText = "Products")
	private WebElement produclink;

	//@FindBy(xpath = "(//td[@valign = 'bottom'])[2]")
	@FindBy(xpath = "//img[@src = 'themes/softed/images/user.PNG']")
	private WebElement administratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink ;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLnk;
	
	public WebElement getContactLnk() {
		return contactLnk;
	}
	public WebElement getOpportunitiesLink() 
	{
		return opportunitiesLink;
	}

	public WebElement getProduclink() 
	{
		return produclink;
	}

	public WebElement getAdainstratorImg() 
	{
		return administratorImg;
	}

	public WebElement getsignOutLink()
	{
		return signOutLink;
	}

	public void logout() throws Throwable 
	{
		WebdriverUtilty wdu = new WebdriverUtilty();
		Thread.sleep(4000);
		wdu.mouseOver(driver, administratorImg);
		signOutLink.click();
	}
}
