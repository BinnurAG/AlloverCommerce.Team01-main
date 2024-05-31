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

public class TC09 extends ReusableMethods {
    private final String testName = "US19 / TC09-Code Add";
    private final String description = "Adding discount code. (PASSED)";
    private final String reportMessage = "The code was added and the message 'Coupon code applied successfully.' was displayed.";
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
    public void tc09_codeAdd() {
        try {
            loginToSite();
            extentTest.info("Logged in successfully.");

            Actions actions = new Actions(Driver.getDriver());
            if (Integer.parseInt(cartCount.getText()) > 0) {
                cart.click();
                viewCartButton.click();
                clearCart.click();
            }

            searchBox.sendKeys("Dell");
            searchBox.submit();
            waitForSecond(2);
            actions.sendKeys(Keys.PAGE_DOWN).perform();

            click(addToCart);
            actions.sendKeys(Keys.PAGE_UP).perform();
            click(cart);
            click(checkout);
            extentTest.info("Clicked on the Checkout button.");

            click(enterYourCode);
            couponCode.sendKeys("369789");
            waitForSecond(2);
            click(applyCouponButton);

            Assert.assertTrue(couponAlertMessage.isDisplayed(), "Coupon code applied successfully message is displayed");
            extentTest.pass(reportMessage);
        } catch (Exception e) {
            extentTest.fail("Test failed due to an exception: " + e.getMessage());
            throw e; // re-throw the exception to ensure the test is marked as failed
        }
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
        extent.flush();
    }
}
