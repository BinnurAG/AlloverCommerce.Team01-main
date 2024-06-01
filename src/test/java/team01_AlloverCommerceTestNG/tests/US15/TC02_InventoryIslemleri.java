package team01_AlloverCommerceTestNG.tests.US15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC02_InventoryIslemleri {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() {

        allPages.vendorProductManagerPage().setUp();

        //SKU(Stock Keeping Unit) alanına geçerli bir veri gir.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().skuBox);
        allPages.vendorProductManagerPage().skuBox.sendKeys("111");

        //Manage Stock kutucuğunu işaretle ve Stock Quantity ile Allow Backorders alanlarının göründüğünü kontrol et.
        allPages.vendorProductManagerPage().manageStockButton.click();
        ReusableMethods.waitForSecond(2);
        softAssert.assertTrue(allPages.vendorProductManagerPage().stockQtyBox.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().backOrdersDdm.isDisplayed());

    }
}
