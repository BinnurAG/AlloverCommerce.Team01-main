package team01_AlloverCommerceTestNG.tests.US18;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P20_VendorCouponsPage;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.*;

public class TC06 extends ReusableMethods {
    private final String testName = "US18 / TC06-Coupon Expiry Date";
    private final String description = "Data must be entered in the Coupon expiry date box.(PASSED)";
    private final String reportMessage = "It has been verified that data can be entered in the Coupon expiry date box.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>target:</span> " + description)
    public void tc01() {
        P20_VendorCouponsPage p20VendorCouponsPage = new P20_VendorCouponsPage();
        P6_AccountDetails p6_accountDetails = new P6_AccountDetails();
        Actions actions = new Actions(Driver.getDriver());

        createExtentReport("TestNGTeam01","burak","Allovercommerce should be able to test");
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Goes to Allovercommerce Page.");

        signIn.click();
        extentTest.info("Sign in to login clicked.");

        userNameArea.sendKeys(ConfigReader.getProperty("vendorUS"));
        extentTest.info("Email address was written in the Email address or Username section.");

        passwordArea.sendKeys(ConfigReader.getProperty("vendorPass"));
        extentTest.info("Password was written in the Password section.");

        rememberMe.click();
        extentTest.info("Remember Me box was clicked.");

        signInButton.click();
        extentTest.info("Clicked the Sign in button to login.");

        Assert.assertTrue(p6_accountDetails.signOut.isDisplayed());
        extentTest.pass("Verified that the SignOut button is displayed for successful login.");

        signOut.click();
        extentTest.pass("Clicked on Sign Out.");

        storeManager.click();
        extentTest.info("Clicked on the Store Manager section.");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        couponButton.click();
        extentTest.info("Clicked on the Coupons section.");

        addNewCouponButton.click();
        extentTest.info("Add New was clicked to add the coupon..");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        expiryDate.sendKeys("2024-09-29");
        String expected = "2024-09-29";
        String actual = ConfigReader.getProperty("couponExpiryDate");
        Assert.assertEquals(actual,expected);
        Assert.assertTrue(p20VendorCouponsPage.expiryDate.isDisplayed());
        extentTest.info(reportMessage);

        waitForSecond(2);

        Driver.closeDriver();

    }
}