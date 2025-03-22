package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import utils.TestContextSetup;

public class StorageSearchSteps {
	
    WebDriverWait wait;
    TestContextSetup testContextSetup;
    LandingPage landingPage;
    
    public StorageSearchSteps(TestContextSetup testContextSetup) {
    	this.testContextSetup = testContextSetup;
    	 landingPage= testContextSetup.pageObjectManager.getLandingPage();
    }
    
	@Given("the user is on the LuggageHero homepage")
	public void the_user_is_on_the_luggage_hero_homepage() {
	 landingPage.navigateToLandingPage();
	}
	
	@When("the homepage is fully loaded")
	public void the_homepage_is_fully_loaded() {
		landingPage.acceptCookies();
		String actualTitle = landingPage.getLandingPageTitle();
        System.out.println("Page Title: " + actualTitle);
        //assertEquals(expectedTitle, actualTitle);
	}
	
	@Then("the page title should contain {string}")
	public void the_page_title_should_contain(String expectedTitle) {
	    String actualTitle = landingPage.getLandingPageTitle();
	    Assert.assertTrue(actualTitle.contains(expectedTitle), 
		        "Page title does not contain expected text. Expected: " + expectedTitle + ", but got: " + actualTitle);
	}
	
//	public void the_page_title_should_contain(String expectedTitle) {
//	    String actualTitle = driver.getTitle();
//	    System.out.println("Actual Page Title: " + actualTitle);
//	    Assert.assertTrue(actualTitle.contains(expectedTitle), 
//	        "Page title does not contain expected text. Expected: " + expectedTitle + ", but got: " + actualTitle);
//	}
	
	@Then("the search bar should be visible and functional")
	public void the_search_bar_should_be_visible_and_functional() {
		Assert.assertTrue(landingPage.isSearchTextVisibleAndEnabled(),"Search bar is either not visible or not enabled.");
	}
	
	
	@When("the user searches for {string} luggage storage locations")
	public void the_user_searches_for_luggage_storage_locations(String cityname) {
		landingPage.searchLocation(cityname);
	}
	
	
	@When("the user selects the date {string} and {string} bags")
	public void the_user_selects_the_date_and_bags(String date, String bags) {
		landingPage.selectTravelDate(date);
		landingPage.enterBags(bags);
		landingPage.findStorage();
        
	}
	
	@Then("search results should display relevant luggage storage locations for {string}")
	public void search_results_should_display_relevant_luggage_storage_locations_for(String cityName) {
		Assert.assertTrue(landingPage.isSearchedLocationStoreFound());
	}

}
