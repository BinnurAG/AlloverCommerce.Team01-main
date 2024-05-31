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

public class TC04 extends ReusableMethods {
    private final String testName = "US19 / TC04-ADD to CART";
    private final String description = "Data must be entered in the Search box. (PASSED)";
    private final String reportMessage = "Data is searched in the search box and added to the Shopping Cart list.";
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
    public void tc04_addToCart() {
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
        Assert.assertTrue(cartCount.getText() != "0");
        extentTest.info("It has been confirmed that the product has been added to the cart.");

        Assert.assertTrue(shoppingCartList.isDisplayed(), reportMessage);
        extentTest.pass(reportMessage);

        waitForSecond(2);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
        extent.flush();
    }
}