package team01_AlloverCommerceTestNG.tests.US19;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.*;


public class TC08 extends ReusableMethods {
    private final String testName = "US19 / TC08-Checkout";
    private final String description = "Click the Checkout button. (PASSED)";
    private final String reportMessage = "The Checkout page was found on the page.";
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
    public void tc08_checkout() {

        Actions actions = new Actions(Driver.getDriver());
        loginToSite();
        extentTest.info("Logged in successfully.");
        if (Integer.parseInt(cartCount.getText()) > 0) {
            cart.click();
            viewCartButton.click();
            clearCart.click();
        }
        searchBox.sendKeys("Dell");
        searchBox.submit();

        waitForSecond(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        click(minus);
        click(addToCart);
        actions.sendKeys(Keys.PAGE_UP).perform();
        click(cart);

        click(checkout);
        extentTest.info("Clicked on the Checkout button.");

        String actualResult = Driver.getDriver().getTitle();
        ReusableMethods.screenShot("Checkout");
        String expectedResult = "Checkout";
        Assert.assertTrue(actualResult.contains(expectedResult), reportMessage);
        extentTest.pass("Checkout page is displayed.");
        waitForSecond(2);

    }
       @AfterMethod
        public void tearDown() {
            Driver.closeDriver();
            extent.flush();

    }
}