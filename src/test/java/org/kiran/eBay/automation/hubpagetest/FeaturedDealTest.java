package org.kiran.eBay.automation.hubpagetest;

import java.util.concurrent.TimeUnit;

import org.kiran.eBay.automation.pageobject.locators.FeaturedDealsLocators;
import org.kiran.eBay.automation.pageobject.locators.HubPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FeaturedDealTest {

	private WebDriver driver;
	
	@Test
	public void openBrowser(){
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.ebay.com/deals/");
	}
	
	@Test
	public void validateFeaturedDealsBasics(){
		WebElement featuredDeal=driver.findElement(By.cssSelector(HubPageLocators.FEATURED_DEALS_LOCATOR));
		Assert.assertNotNull(featuredDeal);
		System.out.println("In Featured Deals Basics");
	}
	
	@Test
	public void testFeaturedDealHeading(){
		WebElement featuredHeading=driver.findElement(By.className(FeaturedDealsLocators.FEATUREDDEALHEADING));
		String heading=featuredHeading.getText();
		Assert.assertEquals(heading, "FEATURED DEALS");
	}
}
