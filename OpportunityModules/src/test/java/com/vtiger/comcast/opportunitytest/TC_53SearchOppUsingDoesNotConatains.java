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
public class TC_53SearchOppUsingDoesNotConatains extends BaseClass {
@Test(groups = {"regression"})
public void searchOppWithDoesNotContains() throws Throwable
{
	/* read test data from excel */
	String orgName = elib.getExcelData("Opp", 1, 1) + "_" + JavaUtility.getRandomData();
	
	String FN = elib.getExcelData("Contacts", 1, 1);
	
	String LN = elib.getExcelData("Contacts", 1, 2) ;
	
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
	
	op.searchWithDoesNotContains("ab");
	
}
}
