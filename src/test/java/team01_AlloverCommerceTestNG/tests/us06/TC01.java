package team01_AlloverCommerceTestNG.tests.us06;

import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.*;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.*;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;

@Listeners(team01_AlloverCommerceTestNG.utilities.Listeners.class)
public class TC01 extends ReusableMethods {

    P6_AccountDetails p6_accountDetails = new P6_AccountDetails();

    @BeforeClass
    public void beforeClass() {
        loginToSite();
    }

    @Test
    public void test_SearchProduct() {
        searchBox.sendKeys("Blue Ski Boots");
        searchBox.submit();
        assertTrue(searchResults.isDisplayed(), "Arama sonuçları görünmüyor.");
        waitForSecond(2);
    }

    @AfterClass
    public void afterClass() {
        getDriver().quit();
    }
}