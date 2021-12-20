package practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
@Listeners(com.crm.vtiger.GenericUtils.ListenerImplimentation.class)
public class ContactTest extends BaseClass{
@Test
public void createContactTest ()
{
	System.out.println("Execute createContactTest");
	String URL = System.getProperty("url");
	String BROWSER = System.getProperty("browser");
	String USERNAME = System.getProperty("username");
	String PASSWORD = System.getProperty("password");
	
	System.out.println(URL);
	System.out.println(BROWSER);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
	
}
@Test
public void editContactTest()
{
	System.out.println("Execute editContactTest");
}
}
