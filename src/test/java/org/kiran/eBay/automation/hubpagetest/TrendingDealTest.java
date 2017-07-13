package org.kiran.eBay.automation.hubpagetest;

import java.util.concurrent.TimeUnit;

import org.kiran.eBay.automation.pageobject.components.TrendingDeals;
import org.kiran.eBay.automation.pageobject.locators.HubPageLocators;
import org.kiran.eBay.automation.pageobject.locators.TrendingDealsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TrendingDealTest {

	// this is trending deal test class
	WebDriver driver;

	@BeforeClass
	public void openBrowser(){
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.ebay.com/deals/");
		
	}
	@Test(priority=0)
	public void testTrendingDealbasics(){
		WebElement trendingDeal=driver.findElement(By.cssSelector(HubPageLocators.TRENDING_DEALS_LOCATOR));
		Assert.assertNotNull(trendingDeal);
	}

	@Test(priority=1)
	public void testTrendingDealHeading(){
		String heading=driver.findElement(By.className(TrendingDealsLocators.TRENDING_DEALS_HEADING)).getText();
		Assert.assertNotNull(heading, "Trending Deals");
	}
	@Test(priority=2)
	public void testTrendingDealItemNameAndImage(){
		WebElement image=driver.findElement(By.id(TrendingDealsLocators.TRENDING_DEALS_IMAGE));
		image.isDisplayed();
		Assert.assertNotNull(image);
		WebElement itemName=driver.findElement(By.className(TrendingDealsLocators.TRENDING_DEALS_ITEMNAME));
		Assert.assertNotNull(itemName);
	}
	@Test(priority=3)
	public void testAllTrendingDeals(){
		WebElement allTrendingDeals=driver.findElement(By.partialLinkText(TrendingDealsLocators.TRENDING_DEALS_ALLDEALS));
		String allDeals=allTrendingDeals.getText();
		Assert.assertNotNull(allDeals, "See all trending deals");
		allTrendingDeals.click();
		System.out.println(driver.getTitle());
		driver.navigate().back();

	}

	@Test(priority=5)
	public void testArrows(){
		WebElement rightArrow=driver.findElement(By.xpath(TrendingDealsLocators.TRENDING_DEALS_RIGHTARROW));
		Assert.assertNotNull(rightArrow);
		String imageName1=driver.findElement(By.className(TrendingDealsLocators.TRENDING_DEALS_IMAGENAME1)).getText();
		rightArrow.click();
		System.out.println("Right arrow is clikced.");
		String imageName2=driver.findElement(By.className(TrendingDealsLocators.TRENDING_DEALS_IMAGENAME2)).getText();
		Assert.assertEquals(imageName1, imageName2);
		WebElement leftArrow=driver.findElement(By.xpath(TrendingDealsLocators.TRENDING_DEALS_LEFTARROW));
		leftArrow.click();
		System.out.println("Left arrow is clikced.");
		String imageName3=driver.findElement(By.className(TrendingDealsLocators.TRENDING_DEALS_IMAGENAME3)).getText();
		Assert.assertEquals(imageName3, imageName1);
	}

	@Test(priority=4)
	public void testIconOnItem(){
		WebElement redFlag=driver.findElement(By.xpath(TrendingDealsLocators.TRENDING_DEALS_REDFLAG));
		redFlag.isDisplayed();
		System.out.println("Red Flag is displayed");
	}

	@Test(priority=6)
	public void testMoreOptions(){
		WebElement moreOptions=driver.findElement(By.className(TrendingDealsLocators.TRENDING_DEALS_MOREOPTIONS));
		String options=moreOptions.getText();
		Assert.assertNotNull(options, "More options");
		moreOptions.click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
	}
	
	@Test(priority=7)
	public void testItemprice(){
		WebElement itemPrice= driver.findElement(By.xpath(TrendingDealsLocators.TRENDING_DEALS_ITEM_PRICE));
		System.out.println(itemPrice.getText());
	}
}

