package org.kiran.eBay.automation.pageobject;

import org.kiran.eBay.automation.pageobject.components.FeaturedDeals;
import org.kiran.eBay.automation.pageobject.components.SpotlightDeals;
import org.kiran.eBay.automation.pageobject.components.TrendingDeals;

public class HubPage extends BasePageObject {
	private SpotlightDeals spotlightDeal;
	private FeaturedDeals featuredDeal;
	private TrendingDeals trendingDeal;
	
	
	
	public HubPage() {
		super();
		System.out.println("am in hub page constructor");
	}
	
	public SpotlightDeals getSpotlightDeals(){
		
		return new SpotlightDeals();
	}
	
	public TrendingDeals getTrendingDeals(){
		
		return new TrendingDeals();
	}
	
	public FeaturedDeals getFeaturedDeals(){
		return new FeaturedDeals();
	}

}
