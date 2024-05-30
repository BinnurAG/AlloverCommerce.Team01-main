package team01_AlloverCommerceTestNG.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;
import static team01_AlloverCommerceTestNG.utilities.ReusableMethods.*;

public class US08_Register_WishList {

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
    public void test01_AddToWishList() {
        searchProductAndShowAsList("Bilgisayar");
        click(allPages.wishlistPage().addWishList);
        click(allPages.wishlistPage().wishListIcon);
        visibleWait(allPages.wishlistPage().quickViewButton, 15);
        assertTrue(allPages.wishlistPage().quickViewButton.isDisplayed());
        click(allPages.wishlistPage().quickViewButton);
        visibleWait(allPages.wishlistPage().quickViewCloseButton, 15);
        assertTrue(allPages.wishlistPage().quickViewCloseButton.isDisplayed());
        click(allPages.wishlistPage().quickViewCloseButton);

    }

    @Test
    public void test02_AddToCartFromWishList() {
        searchProductAndShowAsList("phone");
        click(allPages.wishlistPage().addWishList);
        click(allPages.wishlistPage().wishListIcon);
        click(allPages.wishlistPage().addCartButtonInWishList);
        assertTrue(allPages.wishlistPage().viewCartButton.isDisplayed());
        click(allPages.wishlistPage().viewCartButton);

    }

    @Test
    public void test03_CompleteOrder() {
        searchProductAndShowAsList("Bilgisayar");
        click(allPages.wishlistPage().addWishList);
        click(allPages.wishlistPage().wishListIcon);
        click(allPages.wishlistPage().addCartButtonInWishList);
        click(allPages.wishlistPage().viewCartButton);
        allPages.accountDetails();
        click(P6_AccountDetails.proceedToCheckoutButton);
        allPages.accountDetails();
        click(P6_AccountDetails.orderCompleteButton);
        allPages.accountDetails();
        click(P6_AccountDetails.payAtTheDoor);
        allPages.accountDetails();
        click(P6_AccountDetails.placeOrderButton);
        allPages.accountDetails();
        visibleWait(P6_AccountDetails.orderReceived, 20);
        allPages.accountDetails();
        assertTrue(P6_AccountDetails.orderReceived.isDisplayed());
    }


}