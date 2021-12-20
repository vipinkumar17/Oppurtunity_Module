package com.vtiger.comcast.pomrepositorylibOpp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver = null;
	public Login(WebDriver driver)
	{											// Rule 3; Execute all the elements t initialize the elements PageFactoryinitEleants [initialization)
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "user_name")           //Rule 2 : Identify all the elements using findBy t findbys • findAll (Declaration )"
	private WebElement userNameEdt;
	
	@FindBy(name ="user_password")
	private WebElement userPasswordEdt;
	
	@FindAll({@FindBy(id="submitButton") , @FindBy(xpath="//input[@id='submitButton']")})
	private WebElement loginBtn ;        //Rule 4 : Declare ail the elements as private t provide getters method , business method for (Utilization)
	
	public WebElement getuserNameEdt()
	{
		return userNameEdt;
	}
	public WebElement getuserPasswordEdt() 
	{
		return userPasswordEdt;
	}
	public WebElement getLoglnBtn() 
	{
		return loginBtn;
	}
	public void loginToApp(String userName , String password) 
	{
		// step 1 : login
		userNameEdt.sendKeys(userName);
		userPasswordEdt. sendKeys(password);
		loginBtn.click();
	}
}
