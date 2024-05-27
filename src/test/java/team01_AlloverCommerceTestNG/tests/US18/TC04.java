package team01_AlloverCommerceTestNG.tests.US18;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P20_VendorCouponsPage;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.*;

public class TC04 extends ReusableMethods {
    private final String testName = "US18 / TC04-Discount Type Section";
    private final String description = "Fixed Product discount option should be selected from the Discount Type section.(PASSED)";
    private final String reportMessage = "It has been confirmed that the Fixed Product discountoption can be selected in the Discount Type section..";

    @Test(testName = testName, description = "<span style='font-weight:bold'>target:</span> " + description)
    public void tc04() {
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
        waitForSecond(2);


        Assert.assertTrue(p20VendorCouponsPage.discountType.isDisplayed());
        extentTest.info("Verified that Percentage Discount option is seen as default.");

        waitForSecond(3);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();

        Select select = new Select(p20VendorCouponsPage.discountType);
        select.selectByIndex(1);
        String expectedSection = "Fixed Product Discount";
        String actualSection = select.getFirstSelectedOption().getText();
        extentTest.info("The selectability of the Fixed Product Discount option was checked in the Discount Type section.");

        Assert.assertEquals(expectedSection, actualSection);
        extentTest.info(reportMessage);

        waitForSecond(2);

        Driver.closeDriver();

    }
}