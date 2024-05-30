package team01_AlloverCommerceTestNG.tests.us08;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;
import static team01_AlloverCommerceTestNG.utilities.ReusableMethods.*;

public class TC03 {

    static Pages allPages = new Pages();
    Actions actions = new Actions(getDriver());
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @BeforeClass
    public void beforeClass() {
        ReusableMethods.loginToSite();
    }

    @AfterMethod
    public void tearDown() {
        click(allPages.addressesPage().signOut);
    }

    @Test
    public void test_CompleteOrder() {
        searchProductAndShowAsList("Bilgisayar");
        waitForClickablility(allPages.wishlistPage().addWishList, 15);
        click(allPages.wishlistPage().addWishList);
        click(allPages.wishlistPage().wishListIcon);
        click(allPages.wishlistPage().addCartButtonInWishList);
        click(allPages.wishlistPage().viewCartButton);
        click(allPages.accountDetails().proceedToCheckoutButton);
        click(allPages.accountDetails().orderCompleteButton);
        click(allPages.accountDetails().payAtTheDoor);
        click( allPages.accountDetails().placeOrderButton);
        visibleWait( allPages.accountDetails().orderReceived, 20);
        assertTrue( allPages.accountDetails().orderReceived.isDisplayed());
    }


    @AfterClass
    public void afterClass() {
        getDriver().quit();
    }

}