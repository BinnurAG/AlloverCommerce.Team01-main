package team01_AlloverCommerceTestNG.tests.US15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.P18_VendorProductManagerPage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC01_VendorOlarakAdvancedMenuleriGorebilmeli {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() {

        allPages.vendorProductManagerPage().setUp();
        //Tüm menülerin (Inventory, Shipping, Attributes, Linked, Seo, Advanced) görünür olup olmadığını kontrol et.

        ReusableMethods.scroll(allPages.vendorProductManagerPage().inventory);
        ReusableMethods.waitForSecond(3);
        softAssert.assertTrue(allPages.vendorProductManagerPage().inventory.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().shipping.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().attributes.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().linked.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().seo.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().advanced.isDisplayed());
    }
}
