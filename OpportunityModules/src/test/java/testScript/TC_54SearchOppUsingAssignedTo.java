package testScript;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebdriverUtilty;

public class TC_54SearchOppUsingAssignedTo {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	@Test
	public void createOpp() throws Throwable
	{
		ExcelUtility eu = new ExcelUtility();
		FileUtility fu = new FileUtility();
		WebdriverUtilty wdu = new WebdriverUtilty();
		String un = fu.getPropertKeyValue("username");
		String pwd = fu.getPropertKeyValue("password");
		String url = fu.getPropertKeyValue("url");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		String orgName = eu.getExcelData("Sheet1", 5, 1);
		driver.findElement(By.name("potentialname")).sendKeys(orgName + JavaUtility.getRandomData());
		WebElement relatedTo = driver.findElement(By.id("related_to_type"));
		wdu.SelectOption(relatedTo, 1);
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		Set<String> allWh = driver.getWindowHandles();
		String pwh = driver.getWindowHandle();
		for(String wh:allWh)
		{
			driver.switchTo().window(wh);
			if(!wh.equals(pwh))
			{
				driver.findElement(By.id("1")).click();
			}
		}
		driver.switchTo().window(pwh);
		driver.findElement(By.name("amount")).clear();
		driver.findElement(By.name("amount")).sendKeys("2000000");
		WebElement type = driver.findElement(By.name("opportunity_type"));
		wdu.SelectOption(type, 1);
		WebElement lead = driver.findElement(By.name("leadsource"));
		wdu.SelctOption(lead, "Existing Customer");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement assign = driver.findElement(By.name("assigned_group_id"));
		wdu.SelctOption(assign, "4");
		WebElement sales = driver.findElement(By.name("sales_stage"));
		wdu.SelectOption(sales, 7);
		String desc = eu.getExcelData("Sheet1", 5, 3);
		driver.findElement(By.name("description")).sendKeys(desc);
		driver.findElement(By.name("button")).click();
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.linkText("Go to Advanced Search")).click();
		WebElement dd1 = driver.findElement(By.id("fcol0"));
		wdu.SelctOption(dd1, "vtiger_crmentity:smownerid:assigned_user_id:Potentials_Assigned_To:V");
		WebElement dd2 = driver.findElement(By.xpath("//select[@class='repBox']"));
		wdu.SelectOption(dd2, 3); 
		driver.findElement(By.xpath("//input[@class='repBox']")).sendKeys("s");
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
	}

}
