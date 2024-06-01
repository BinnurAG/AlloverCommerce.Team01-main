package team01_AlloverCommerceTestNG.tests.US15;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC03_InventoryIslemleri2 {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() {
        allPages.vendorProductManagerPage().setUp();

        //SKU(Stock Keeping Unit) alanına geçerli bir veri gir.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().skuBox);
        allPages.vendorProductManagerPage().skuBox.sendKeys("111");

        //Manage Stock kutucuğunu boş bırak ve Stock Status dropdown menüsünden uygun olan seçeneği seç.
        allPages.vendorProductManagerPage().stockStatusDdm.click();
        allPages.vendorProductManagerPage().inStockDdmSelect.click();
        allPages.vendorProductManagerPage().soldIndividually.click();

        //Submit butonuna tıkla.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().submitButton);
        ReusableMethods.waitForSecond(3);
        allPages.vendorProductManagerPage().submitButton.click();
        ReusableMethods.waitForSecond(2);
        softAssert.assertTrue(allPages.vendorProductManagerPage().titleErrorMessage.isDisplayed());

        //Product successfully published" mesajının göründüğünü doğrula.


    }
}
