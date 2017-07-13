package org.kiran.eBay.automation.hubpagetest;

import java.util.concurrent.TimeUnit;

import org.kiran.eBay.automation.pageobject.locators.HubPageLocators;
import org.kiran.eBay.automation.pageobject.validators.HubPageValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpotlightDealTest {
 
	WebDriver driver;
	
	@BeforeClass
	public void openBrowser(){
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		driver.get("http://www.ebay.com/deals/");
	}
	
/*	@AfterClass
	public void closeBrowser(){
		System.out.println("Current page is closed.");
		driver.quit();
	} */
	
	@Test
	public void testSpotlightDealBasics(){
		
		WebElement spotlightDeal = driver.findElement(By.cssSelector(HubPageLocators.SPOTLIGHT_DEALS_LOCATOR));
		Assert.assertNotNull(spotlightDeal);
		
//		HubPageValidator hubValidator = new HubPageValidator(driver);
//		hubValidator.validateSpotlightDealBasics();
		
	}
	
	@Test()
	public void testSpotlightHeading(){
		
		String heading=driver.findElement(By.xpath("//h2[contains(text(),'Spotlight Deal')]")).getText();
		Assert.assertEquals(heading, "SPOTLIGHT DEAL");		
	}
	
	@Test()
	public void testSpotligtItemNameAndImage(){
		String itemName=driver.findElement(By.xpath("//span[@class='ebayui-ellipsis-3']")).getText();
		Assert.assertNotNull(itemName);
		WebElement itemImage=driver.findElement(By.className("slashui-image-cntr"));
		Assert.assertNotNull(itemImage);
	}
	
	@Test()
	public void testLineSeprator(){
		WebElement testLine=driver.findElement(By.xpath("//div[@id='w2-w0']"));
		Assert.assertNotNull(testLine);
	}
}

