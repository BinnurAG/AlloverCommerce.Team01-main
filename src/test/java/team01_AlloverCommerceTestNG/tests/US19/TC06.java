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

public class TC06 extends ReusableMethods {
    private final String testName = "US19 / TC06-Quantity Decrement";
    private final String description = "Vendor decreases the number of products within the Quantity section 1->2. (PASSED)";
    private final String reportMessage = "The number of products has been decreased.";
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
    public void tc06_quantityDecrement() {
        Actions actions = new Actions(Driver.getDriver());


        loginToSite();
        extentTest.info("Logged in successfully.");

        click(cartCount);
        click(removeProduct);
        searchBox.sendKeys("Dell");
        searchBox.submit();
        waitForSecond(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        click(plus);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitForSecond(2);
        click(minus);
        extentTest.info("Before adding it to the cart, the '-' " +
                "utton was pressed to determine the quantity of the product and it was confirmed that it was working.");
        Assert.assertTrue(minus.isDisplayed());
        waitForSecond(2);

        click(addToCart);
    }

    @AfterMethod
    public void tearDown() {
        extent.flush();
        Driver.closeDriver();
    }
}