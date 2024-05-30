package team01_AlloverCommerceTestNG.tests.us06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.*;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.wireTransfer;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;

@Listeners(team01_AlloverCommerceTestNG.utilities.Listeners.class)
public class TC07 extends ReusableMethods {

    P6_AccountDetails p6_accountDetails = new P6_AccountDetails();

    @BeforeClass
    public void beforeClass() {
        loginToSite();
    }

    @Test
    public void test_CheckoutWireTransfer() {
        assertTrue(shippingAddress.isDisplayed());
        click(proceedToCheckoutButton);
        click(wireTransfer);
        assertTrue(wireTransfer.isSelected(), "Wire Transfer seçilmedi.");
    }

    @AfterClass
    public void afterClass() {
        getDriver().quit();
    }

}