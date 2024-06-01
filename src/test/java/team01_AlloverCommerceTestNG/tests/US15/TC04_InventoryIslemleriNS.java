package team01_AlloverCommerceTestNG.tests.US15;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC04_InventoryIslemleriNS {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void test01() {

        allPages.vendorProductManagerPage().setUp();

        //SKU(Stock Keeping Unit) alanına geçerli olmayan bir veri gir.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().skuBox);
        allPages.vendorProductManagerPage().skuBox.sendKeys("@abc");

        //Submit butonuna tıkla.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().submitButton);
        ReusableMethods.waitForSecond(3);
        allPages.vendorProductManagerPage().submitButton.click();
        ReusableMethods.waitForSecond(2);

        //Hata mesajinin goruldugunu dogrula.

    }
}
