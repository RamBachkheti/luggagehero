package cucumberOptions;

// Import necessary TestNG and Cucumber classes
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestNGTestRunner sets up the Cucumber test runner with TestNG support.
 * It configures feature file locations, step definitions, plugins for reports, and parallel execution.
 */
@CucumberOptions(
    // Path to the feature files
    features = "src/test/java/features",

    // Package containing step definition classes
    glue = "stepDefinitions",
    
    tags ="@RegressionTest or @SmokeTest",

    // Plugins for pretty console output, HTMLreports
    plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // HTML Extent report
    },

    // Removes unreadable characters from console output
    monochrome = true
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    /**
     * Enables parallel execution of Cucumber scenarios using TestNG DataProvider.
     * 
     * @return scenarios - the set of scenarios to execute in parallel
     */
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}