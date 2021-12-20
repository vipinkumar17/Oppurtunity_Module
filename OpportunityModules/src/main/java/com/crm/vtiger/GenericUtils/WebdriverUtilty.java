package com.crm.vtiger.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebdriverUtilty 
{
/*
 * author @ vipin
 */
	/**
	 * This method wait for 20 sec for page loading
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * this method wait for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver , WebElement element)
	{
		WebDriverWait  wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method wait for the element to be clicked
	 * @param element
	 * @throws throwable 
	 */
	public void waitAndClick(WebElement element) throws Throwable
	{
		int count  = 0;
		while(count<40)
		{
			try
			{
				element.click();
				break;
			}
		catch(Throwable e)
			{
			Thread.sleep(2000);
			count++;
			}
		}
	}
	/**
	 * This method enables user to handle dropdown using visibletext
	 * @param element
	 * @param option
	 */
		public void SelectOption(WebElement element , String option)
		{
			Select s = new Select(element);
			s.selectByVisibleText(option);
		}
		/**
		 * This method enable user to handle dropdown using index
		 */
		public void SelectOption(WebElement element , int index)
		{
			Select s = new Select(element);
			s.selectByIndex(index);
		}
		/**
		 * This method enable user to handle dropdown using value
		 * @param element
		 * @param value
		 */
		public void SelctOption(WebElement element , String value)
		{
			Select s = new Select(element);
			s.selectByValue(value);
		}
		/**
		 *  This method will perform mouse over action
		 * @param driver
		 * @param element
		 */
		public void mouseOver(WebDriver driver , WebElement element)
		{
			Actions a = new Actions(driver);
			a.moveToElement(element).perform();
		}
		/**
		 * This method perform right click operations
		 * @param driver
		 * @param element
		 */
		public void rightClick(WebDriver driver , WebElement element)
		{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
		}
		/**
		 * This method helps to switch from one window to another
		 * @param driver
		 * @param partialWinTitle
		 */
		public void switchToWIndow(WebDriver driver , String partialWinTitle)
		{
			Set<String> window = driver.getWindowHandles();
			Iterator<String> itr = window.iterator();
			while(itr.hasNext())
			{
				String winId = itr.next();
				String title = driver.switchTo().window(winId).getTitle();
				if(title.contains(partialWinTitle))
				{
					break;
				}
			}
		}
		/**
		 * Accept alert
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		/**
		 * Cancel alert
		 * @param driver
		 */
		public void cnacelAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		/**
		 * This method is used for scrolling action in webpage
		 * @param driver
		 * @param element
		 */
		public void scrollToWebElement(WebDriver driver , WebElement element)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			int y = element.getLocation().getY();
			js.executeScript("windoe.scrollBy(0,"+y+")", element);
		}
		public void switchFrame(WebDriver driver , int index)
		{
			driver.switchTo().frame(index);
		}
		
		public void switchFrame(WebDriver driver , WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		public void switchFrame(WebDriver driver , String idOrName)
		{
			driver.switchTo().frame(idOrName);
		}
		
		public String takeScreenshot(WebDriver driver , String screenshotName) throws Throwable
		{
			String screenshotPath = "./screenshot/"+screenshotName+JavaUtility.getRandomData()+".PNG";
			TakesScreenshot t = (TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			File dest = new File(screenshotPath);
			//   Files.copy(src, dest);
			
			FileUtils.copyFile(src, dest);
			return screenshotPath;
		}
		
		public void pressEnterKey() throws AWTException
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		public void maximizeWindow(WebDriver driver) {
			driver.manage().window().maximize();
			
		}
}
