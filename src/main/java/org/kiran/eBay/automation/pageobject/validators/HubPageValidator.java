package org.kiran.eBay.automation.pageobject.validators;

import org.kiran.eBay.automation.pageobject.locators.HubPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HubPageValidator {

	private WebDriver driver;

	public HubPageValidator(WebDriver driver) {
		this.driver = driver;

	}

	public void validateSpotlightDealsBasics(){

		WebElement spotlightDeal = driver.findElement(By.cssSelector(HubPageLocators.SPOTLIGHT_DEALS_LOCATOR));
		Assert.assertNotNull(spotlightDeal);


		System.out.println("in spotlight deal basics");
	}

	public void validateTrendingDealsBasics(){
		WebElement trendingDeal=driver.findElement(By.cssSelector(HubPageLocators.TRENDING_DEALS_LOCATOR));
		Assert.assertNotNull(trendingDeal);
		System.out.println("in Trenidng deal basics");
	}

	public void validateFeaturedDealsBasics(){
		WebElement featuredDeal=driver.findElement(By.cssSelector(HubPageLocators.FEATURED_DEALS_LOCATOR));
		Assert.assertNotNull(featuredDeal);
		System.out.println("In Featured Deals Basics");

	}

}
