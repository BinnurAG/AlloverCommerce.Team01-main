package team01_AlloverCommerceTestNG.tests.US19;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.invalidSearch;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.searchBox;


public class TC03 extends ReusableMethods {
    private final String testName = "US19 / TC03-Invalid Search";
    private final String description = "Invalid data should be entered in the search box. (PASSED)";
    private final String reportMessage = "It has been confirmed that the data could be entered in the search box. " +
            "No Products Were Found Matching Your Selection.";
    P6_AccountDetails p6_accountDetails = new P6_AccountDetails();

    private ExtentReports extent;
    private ExtentTest extentTest;

    @BeforeMethod
    public void setUp() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extentTest = extent.createTest(testName, description);
    }

    @Test(testName = testName, description = "<span style='font-weight:bold'>target:</span> " + description)
    public void tc03_invalidSearch() {
        loginToSite();

        extentTest.info("Navigated to the site and logged in.");

        searchBox.sendKeys("dsddj", Keys.ENTER);
        extentTest.info("Entered invalid search term 'dsddj' and submitted.");

        assertTrue(invalidSearch.isDisplayed(), reportMessage);
        extentTest.pass("Invalid search results are displayed as expected.");

        extentTest.info(reportMessage);

        waitForSecond(2);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
        extent.flush();
    }
}