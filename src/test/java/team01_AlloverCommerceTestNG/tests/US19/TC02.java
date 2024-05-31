package team01_AlloverCommerceTestNG.tests.US19;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.searchIcon;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;

public class TC02 extends ReusableMethods {
    private final String testName = "US19 / TC02-Search Box";
    private final String description = "Data must be entered in the Search box. (PASSED)";
    private final String reportMessage = "The search box was left empty, and it was observed that a warning message was received.";
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
    public void tc02_searchBox() {

        loginToSite();
        extentTest.info("Logged in successfully.");

        click(searchIcon);
        extentTest.info("Clicked on the search icon.");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("alert('Please fill out this field.')");
        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();
        assertTrue(alertText.contains("Please fill out this field."), reportMessage);
        extentTest.pass(reportMessage);

        alert.accept();
        waitForSecond(2);
    }

    @AfterMethod
    public void tearDown() {
        extent.flush();
        Driver.closeDriver();
    }
}
