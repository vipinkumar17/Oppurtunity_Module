package com.vtiger.comcast.pomrepositorylibOpp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebdriverUtilty;

public class CreateNewOpportunities extends WebdriverUtilty
{
	WebDriver driver = null;
	public CreateNewOpportunities(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "potentialname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath = "//select[@name = 'sales_stage']")
	private WebElement salesStageDropDown;
	
	@FindBy(name = "related_to_type")
	private WebElement relatedToDropdown;
	@FindBy(linkText = "ExperisIT")
	private WebElement relatedToOrg;
	
	@FindBy(linkText = "Arjun Reddy")
	private WebElement relatedToConatct;
	
	@FindBy (xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement relatedToLookUpBtn;
	
	@FindBy(name = "button")
	private WebElement saveBtn;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSalesStageDropDown() {
		return salesStageDropDown;
	}

	public WebElement getRelatedToDropdown() {
		return relatedToDropdown;
	}

	public WebElement getRelatedToOrg() {
		return relatedToOrg;
	}

	public WebElement getRelatedToConatct() {
		return relatedToConatct;
	}

	public WebElement getRelatedToLookUpBtn() {
		return relatedToLookUpBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createOpp(String orgName )
	{
		orgNameEdt.sendKeys(orgName);
		
		String pwh = driver.getWindowHandle();
		SelectOption(relatedToDropdown, 1);
		
		relatedToLookUpBtn.click();
		switchToWIndow(driver, "Accounts&action");
		relatedToConatct.click();
		driver.switchTo().window(pwh);
		//SelectOption(salesStageDropDown, 5);
		saveBtn.click();
		
	}
	
	
}