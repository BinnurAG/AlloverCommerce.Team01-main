package team01_AlloverCommerceTestNG.tests.US19;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.searchBox;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.searchResults;

public class TC01 extends ReusableMethods {
    private final String testName = "US19 / TC01-Search Box";
    private final String description = "Data must be entered in the Search box. (PASSED)";
    private final String reportMessage = "It has been verified that data can be entered in the Search box.";
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
    public void tc01_searchBox() {
        loginToSite();

        searchBox.sendKeys("Dell");
        searchBox.submit();
        extentTest.info("Entered 'Dell' in the search box and submitted.");
        extentTest.info(reportMessage);

        assertTrue(searchResults.isDisplayed(), reportMessage);
        extentTest.pass("Search results are displayed.");


    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
        extent.flush();
    }
}