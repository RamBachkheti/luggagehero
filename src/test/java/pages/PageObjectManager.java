package pages;

import org.openqa.selenium.WebDriver;

/**
 * PageObjectManager is responsible for managing Page Object instances.
 * It helps to initialize page objects only when they are needed (Lazy Initialization).
 */
public class PageObjectManager {
    
    private LandingPage landingPage;
    private final WebDriver driver;

    // Constructor to initialize WebDriver
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns the LandingPage instance.
     * Initializes it only once (Lazy Initialization) to avoid re-creating objects.
     * @return LandingPage instance
     */
    public LandingPage getLandingPage() {
        if (landingPage == null) {
            landingPage = new LandingPage(driver);
        }
        return landingPage;
    }
}
