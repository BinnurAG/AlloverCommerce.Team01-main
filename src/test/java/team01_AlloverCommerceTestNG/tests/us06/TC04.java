package team01_AlloverCommerceTestNG.tests.us06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.*;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.cart;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;

@Listeners(team01_AlloverCommerceTestNG.utilities.Listeners.class)
public class TC04 extends ReusableMethods {

    P6_AccountDetails p6_accountDetails = new P6_AccountDetails();

    @BeforeClass
    public void beforeClass() {
        loginToSite();
    }

    @Test
    public void test_AddToCart() {
        searchBox.sendKeys("Blue Ski Boots", Keys.ENTER);
        String initialCount = P6_AccountDetails.cartCount.getText();
        click(addToCartButton);
        waitForSecond(2);
        String newCount = cartCount.getText();
        assertNotEquals(initialCount, newCount);
        click(cart);
        getDriver().findElement(By.tagName("h4")).isDisplayed();
    }

    @AfterClass
    public void afterClass() {
        getDriver().quit();
    }
}