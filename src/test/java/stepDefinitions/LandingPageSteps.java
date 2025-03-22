package stepDefinitions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LandingPage;
import utils.TestContextSetup;

public class LandingPageSteps {
	
    WebDriverWait wait;
    TestContextSetup testContextSetup;
    LandingPage landingPage;
    
    public LandingPageSteps(TestContextSetup testContextSetup) {
    	this.testContextSetup = testContextSetup;
    }
    

    @Given("the user launches the browser and opens the LuggageHero landing page")
    public void the_user_opens_the_landing_page() {
    	landingPage= testContextSetup.pageObjectManager.getLandingPage();
    	landingPage.navigateToLandingPage();
    }

    @Then("the landing page should load successfully with title {string}")
    public void the_landing_page_should_load_successfully_with_title(String expectedTitle) {
        String actualTitle = landingPage.getLandingPageTitle();
        System.out.println("Page Loaded with Title: " + actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);
//        Assert.assertTrue(landingPage.isHeroSectionVisible());
    }
}