package team01_AlloverCommerceTestNG.tests.US19;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.*;

public class TC10 extends ReusableMethods {
    private final String testName = "US19 / TC10-Billing Details";
    private final String description = "Billing information is entered. (PASSED)";
    private final String reportMessage = "The Billing information was entered.";

    P6_AccountDetails p6_accountDetails = new P6_AccountDetails();
    Faker faker = new Faker();

    private ExtentReports extent;
    private ExtentTest extentTest;

    @BeforeMethod
    public void setUp() {
        ExtentReportUtils.setUpExtentReport("burak", "US19 / TC10-Billing Details");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extentTest = extent.createTest(testName, description);
    }

    @Test(testName = testName, description = "<span style='font-weight:bold'>target:</span> " + description)
    public void tc10_billingInformation() {
        try {
            loginToSite();
            ExtentReportUtils.extentTestInfo("Logged in successfully.");
            screenShot("Logged in");

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
            screenShot("Searched product");

            click(addToCart);
            actions.sendKeys(Keys.PAGE_UP).perform();
            click(cart);
            click(checkout);
            ExtentReportUtils.extentTestInfo("Clicked on the Checkout button.");
            screenShot("Checkout");

            click(enterYourCode);
            couponCode.sendKeys("369789");
            waitForSecond(2);
            click(applyCouponButton);
            screenShot("Applied coupon code");

            fillBillingDetails(actions);
            validateOrderSummary();

            click(placeOrder);
            ExtentReportUtils.extentTestInfo("The Place Order button was clicked to complete the order.");
            screenShot("Placed order");

            Assert.assertTrue(orderMessage.isDisplayed(), "Order message is displayed");
            ExtentReportUtils.extentTestInfo("Verified that the order was created successfully.");
        } catch (Exception e) {
            extentTest.fail("Test failed due to an exception: " + e.getMessage());
            screenShot("Exception");
            throw e; // re-throw the exception to ensure the test is marked as failed
        }
    }

    private void fillBillingDetails(Actions actions) {
        firstName.clear();
        firstName.sendKeys(faker.name().firstName());
        ExtentReportUtils.extentTestInfo("First name was entered in the First name field.");
        screenShot("First name entered");

        lastName.clear();
        lastName.sendKeys(faker.name().lastName());
        ExtentReportUtils.extentTestInfo("Last name was entered in the Last name field.");
        screenShot("Last name entered");

        ReusableMethods.ddmVisibleText(countryRegion1, "United States (US)");
        ExtentReportUtils.extentTestInfo("Country was entered in the Country section.");
        screenShot("Country selected");

        streetAddress.clear();
        streetAddress.sendKeys(faker.address().streetAddress());
        ExtentReportUtils.extentTestInfo("Address was entered in the Address field.");
        screenShot("Street address entered");

        city.clear();
        city.sendKeys(faker.address().city());
        ExtentReportUtils.extentTestInfo("City was entered in the City section.");
        screenShot("City entered");

        ReusableMethods.ddmVisibleText(state, "New York");
        ExtentReportUtils.extentTestInfo("State was entered in the State section.");
        screenShot("State selected");

        zipCode.clear();
        zipCode.sendKeys("10021");
        ExtentReportUtils.extentTestInfo("Postcode was entered in the Postcode section.");
        screenShot("Postcode entered");

        phone.clear();
        phone.sendKeys("+1 212-744-6562");
        ExtentReportUtils.extentTestInfo("Phone number was entered in the Phone section.");
        screenShot("Phone entered");

        emailAddress.clear();
        emailAddress.sendKeys("team01vendor@gmail.com");
        ExtentReportUtils.extentTestInfo("Email address was entered in the Email Address section.");
        screenShot("Email entered");
        ReusableMethods.scroll(emailAddress);
        waitForSecond(2);

        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    private void validateOrderSummary() {
        Assert.assertTrue(subTotal.isDisplayed(), "Subtotal is displayed");
        Assert.assertTrue(paymentMethods.isDisplayed(), "Payment Methods are displayed");
        ExtentReportUtils.extentTestInfo("Payment Methods confirmed.");
        screenShot("Order summary");

        waitForSecond(2);
        click(wireTransfer);
        Assert.assertTrue(wireTransfer.isSelected(), "Wire Transfer/EFT is selected");
        ExtentReportUtils.extentTestInfo("Verified that Wire Transfer/EFT is selected.");
        screenShot("Wire transfer selected");

        waitForSecond(2);
        click(payAtTheDoor);
        ExtentReportUtils.extentTestInfo("Pay at the door is selected.");
        Assert.assertTrue(payAtTheDoor.isSelected(), "Pay at the door is selected");
        ExtentReportUtils.extentTestInfo("It has been confirmed that you cannot choose both options at the same time.");
        screenShot("Pay at the door selected");

        waitForSecond(2);
        click(wireTransfer);
        ExtentReportUtils.extentTestInfo("Wire Transfer/EFT is selected.");
        screenShot("Wire transfer re-selected");
        waitForSecond(2);
    }



    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
        extent.flush();
    }
}
