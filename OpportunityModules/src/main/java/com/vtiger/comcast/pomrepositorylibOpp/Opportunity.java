package com.vtiger.comcast.pomrepositorylibOpp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebdriverUtilty;

public class Opportunity  extends WebdriverUtilty
{
	WebDriver driver = null;
	public Opportunity(WebDriver driver) 
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOppImg;

	@FindBy(linkText = "Go to Advanced Search")
	private WebElement advanceSearchLnk;

	@FindBy(xpath = "//select[@class = 'detailedViewTextBox']")
	private WebElement dd1;
	
	@FindBy(className =  "repBox")
	private WebElement dd2;
	
	@FindBy(name ="fval0")
	private WebElement searchBox;
	
	@FindBy(xpath = "(//input[@class= 'crmbutton small create'])[2]")
	private WebElement searchNowBtn;
	
	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getCreateOppImg()
	{
		return createOppImg;
	}

	public WebElement getAdvanceSearchLnk() {
		return advanceSearchLnk;
	}

	public WebElement getdd2() 
	{
		return dd2;
	}
	
	public WebElement getdd() 
	{
		return dd1;
	}
	
	
	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public void searchWithStartWith(String search)
	{
		SelectOption(dd2, 3);
		searchBox.sendKeys(search);
		searchNowBtn.click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
	}
	public void searchWithContains(String search)
	{
		SelectOption(dd2, 5);
		searchBox.sendKeys(search);
		searchNowBtn.click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
	}
	public void searchWithDoesNotContains(String search)
	{
		SelectOption(dd2, 6);
		searchBox.sendKeys(search);
		searchNowBtn.click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
	}
	public void searchWithAssignedToStartsWith(String search)
	{
		SelectOption(dd1, 3);
		SelectOption(dd2, 3);
		searchBox.sendKeys(search);
		searchNowBtn.click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
	}
	public void searchWithAssignedToEquals(String search)
	{
		SelectOption(dd1, 3);
		SelectOption(dd2, 1);
		searchBox.sendKeys(search);
		searchNowBtn.click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
	}
	public void searchWithAssignedToNotEquals(String search)
	{
		SelectOption(dd1, 3);
		SelectOption(dd2, 2);
		searchBox.sendKeys(search);
		searchNowBtn.click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
	}
}
