package practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

@Listeners(com.crm.vtiger.GenericUtils.ListenerImplimentation.class)
public class OrgTest extends BaseClass {
@Test
public void createOrgTest()
{
	System.out.println("Execute createOrgTest");
}
@Test
public void editOrgTest()
{
	System.out.println("Execute editOrgTest");
}
}
