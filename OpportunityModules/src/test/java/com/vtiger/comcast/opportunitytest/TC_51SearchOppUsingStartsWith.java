package com.vtiger.comcast.opportunitytest;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.vtiger.comcast.pomrepositorylibOpp.CreateNewContact;
import com.vtiger.comcast.pomrepositorylibOpp.CreateNewOpportunities;
import com.vtiger.comcast.pomrepositorylibOpp.Home;
import com.vtiger.comcast.pomrepositorylibOpp.Opportunity;


@Listeners(com.crm.vtiger.GenericUtils.ListenerImplimentation.class)
public class TC_51SearchOppUsingStartsWith extends BaseClass {
	@Test(groups = {"regression"})
	public void searchOppWithStartsWith() throws Throwable {
		/* Create Object */
	//ExcelUtility eLib = new ExcelUtility();
//		FileUtility fLib = new FileUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebdriverUtilty wduLib = new WebdriverUtilty();
//		WebDriver driver = null;
//		
//		/* Read Common Data*/
//		String BROWSER = fLib.getPropertKeyValue("browser");
//		String  URL = 	fLib.getPropertKeyValue("url");
//		String  USERNAME = fLib.getPropertKeyValue("username");
//		String  PASSWORD = fLib.getPropertKeyValue("password");
//
//		/* read test data from excel */
//		
		String orgName = elib.getExcelData("Opp", 1, 1) + "_" + JavaUtility.getRandomData();
		
		String FN = elib.getExcelData("Contacts", 1, 1);
		
		String LN = elib.getExcelData("Contacts", 1, 2) ;
		
		/* Step 1 :launch the browser */
//		if(BROWSER.equals("firefox"))
//		{
//		 driver = new FirefoxDriver();
//		}
//		else if(BROWSER.equals("Chrome")) 
//		{
//		 driver = new ChromeDriver();	
//		}
//		else if(BROWSER.equals("IE")) 
//		{
//		 driver = new InternetExplorerDriver();	
//		}
//		else
//		{
//			 driver = new ChromeDriver();
//			
//		}
//		/* Step 2 : login to app*/
//			
//			driver.get(URL);
//			Login lp = new Login(driver);
//			lp.loginToApp(USERNAME, PASSWORD);
//			
			/*navigate to opportunities*/
		    Home h = new Home(driver);	
		   CreateNewContact cncp = new CreateNewContact(driver);
			cncp.createContact(FN, LN);
			
			h.getOpportunitiesLink().click();
			
			Opportunity op = new Opportunity(driver);
			op.getCreateOppImg().click();
			
			CreateNewOpportunities cnop = new CreateNewOpportunities(driver);
			cnop.createOpp(orgName);
			
			h.getOpportunitiesLink().click();
			
			op.getAdvanceSearchLnk().click();
			op.searchWithStartWith("abc");	
		 
	}
}