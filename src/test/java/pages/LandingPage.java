package pages;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {

    public WebDriver driver;
    WebDriverWait wait;
    String landingPageURL = "https://luggagehero.com";

    // Locators
    By btnCookiesAccept = By.xpath("//div[@class='coi-banner__page-footer']//button[contains(text(), 'Accept all')]");
    By lblPageHeader = By.cssSelector("header");
    By txtSearchLocation = By.id("location");
    By selectListedLocation = By.cssSelector("div.location-input-dropdown.open ul.dropdown-menu li:nth-child(1) a");
    By btnBookNow = By.id("cta-1");
    By dpDate = By.xpath("//div[@class='datepicker-wrapper']//span[@class='date-label']");
    By dtTravelDate = By.xpath("//span[@class='flatpickr-day' and @aria-label='March 28, 2025']");
    By bagsCount = By.id("bag-picker");
    By btnFindStorage = By.xpath("//a[@id='findStorage' and .//span[text()='Find storage']]");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Accept cookies if banner is displayed
    public void acceptCookies() {
        try {
            WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(btnCookiesAccept));
            acceptBtn.click();
        } catch (Exception e) {
            System.out.println("Cookie banner not displayed, proceeding...");
        }
    }

    // Return the page title
    public String getLandingPageTitle() {
        return driver.getTitle();
    }

    // Verify hero section visibility
    public boolean isHeroSectionVisible() {
        return driver.findElement(By.cssSelector(".hero-section")).isDisplayed();
    }

    // Navigate to landing page
    public void navigateToLandingPage() {
        System.out.println("Navigating to " + landingPageURL);
        driver.get(landingPageURL);
    }

    // Check if search bar is visible and enabled
    public boolean isSearchTextVisibleAndEnabled() {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(txtSearchLocation));
        return searchBar.isDisplayed() && searchBar.isEnabled();
    }

    // Search for a specific location
    public void searchLocation(String location) {
        WebElement searchBar = driver.findElement(txtSearchLocation);
        searchBar.clear();
        searchBar.sendKeys(location);
        WebElement locationOption = wait.until(ExpectedConditions.visibilityOfElementLocated(selectListedLocation));
        locationOption.click();
    }

    // Verify if search results contain the Book Now button
    public boolean isSearchedLocationStoreFound() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(btnBookNow));
            return true;
        } catch (Exception e) {
            System.out.println("Book Now button not visible or not found.");
            return false;
        }
    }

    // Select travel date from date picker
    public void selectTravelDate(String date) {
        driver.findElement(dpDate).click();
        WebElement travelDate = wait.until(ExpectedConditions.elementToBeClickable(dtTravelDate));
        travelDate.click();
    }

    // Select number of bags
    public void enterBags(String bags) {
        Select selectBag = new Select(driver.findElement(bagsCount));
        selectBag.selectByValue(bags);
    }

    // Click Find Storage button
    public void findStorage() {
        driver.findElement(btnFindStorage).click();
    }
}
