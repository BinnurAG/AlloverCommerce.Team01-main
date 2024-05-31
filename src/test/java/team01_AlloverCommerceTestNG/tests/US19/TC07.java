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

public class TC07 extends ReusableMethods {
    private final String testName = "US19 / TC07-View Cart";
    private final String description = "View Cart should be used and the product should be visible. (PASSED)";
    private final String reportMessage = "View Cart could be clicked and the product on the page was viewed.";
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
    public void tc05_viewCart() {


        loginToSite();
        extentTest.info("Logged in successfully.");
        if (Integer.parseInt(cartCount.getText()) > 0) {
            cart.click();
            viewCartButton.click();
            clearCart.click();
        }
        searchBox.sendKeys("Dell");
        searchBox.submit();
        extentTest.info("Entered 'Dell' in the search box and submitted.");

        Actions actions = new Actions(Driver.getDriver());


        waitForSecond(2);
        click(closeButton);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        click(addToCart);
        extentTest.info("Clicked 'Add to Cart'.");

        click(cartCount);
        click(viewCartButton);
        extentTest.info("Clicked on 'View Cart'.");

        String actualResult = Driver.getDriver().getTitle();
        ReusableMethods.screenShot2("Shopping Cart");
        String expectedResult = "Cart";
        Assert.assertTrue(actualResult.contains(expectedResult), reportMessage);
        extentTest.pass("Shopping Cart page and product are displayed.");
        waitForSecond(2);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
        extent.flush();
    }
}