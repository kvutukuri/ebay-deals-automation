package org.kiran.eBay.automation.hubpagetest;

import java.util.concurrent.TimeUnit;

import org.kiran.eBay.automation.pageobject.locators.HubPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TrendingDealTest {

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
		String heading=driver.findElement(By.className("ebayui-refit-itemcarousel-heading")).getText();
		Assert.assertNotNull(heading, "Trending Deals");
	}
	@Test(priority=2)
	public void testTrendingDealItemNameAndImage(){
		WebElement image=driver.findElement(By.id("w2-w25-w0"));
		image.isDisplayed();
		Assert.assertNotNull(image);
		WebElement itemName=driver.findElement(By.className("ebayui-ellipsis-2"));
		Assert.assertNotNull(itemName);
	}
	@Test(priority=3)
	public void testAllTrendingDeals(){
		WebElement allTrendingDeals=driver.findElement(By.partialLinkText("See all trending deals"));
		String allDeals=allTrendingDeals.getText();
		Assert.assertNotNull(allDeals, "See all trending deals");
		allTrendingDeals.click();
		System.out.println(driver.getTitle());
		driver.navigate().back();

	}

	@Test(priority=5)
	public void testArrows(){
		WebElement rightArrow=driver.findElement(By.xpath("//*[@id='w2-w25']/button[2]"));
		Assert.assertNotNull(rightArrow);
		String imageName1=driver.findElement(By.className("ebayui-ellipsis-2")).getText();
		rightArrow.click();
		System.out.println("Right arrow is clikced.");
		String imageName2=driver.findElement(By.className("ebayui-ellipsis-2")).getText();
		Assert.assertEquals(imageName1, imageName2);
		WebElement leftArrow=driver.findElement(By.xpath("//*[@id='w2-w25']/button[1]"));
		leftArrow.click();
		System.out.println("Left arrow is clikced.");
		String imageName3=driver.findElement(By.className("ebayui-ellipsis-2")).getText();
		Assert.assertEquals(imageName3, imageName1);
	}

	@Test(priority=4)
	public void testIconOnItem(){
		WebElement redIcon=driver.findElement(By.xpath("//*[@id='w2-w25-w0']/a/div[3]"));
		redIcon.isDisplayed();
		System.out.println("Red Flag is displayed");
	}

	@Test(priority=6)
	public void testMoreOptions(){
		WebElement moreOptions=driver.findElement(By.className("dne-itemtile-more-options"));
		String options=moreOptions.getText();
		Assert.assertNotNull(options, "More options");
		moreOptions.click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
	}
	
	@Test(priority=7)
	public void testItemprice(){
		WebElement itemPrice=driver.findElement(By.xpath("//*[@id='w2-w25-w1']/a/div[2]/div[1]/span[1]"));
		System.out.println(itemPrice.getText());
	}
}

