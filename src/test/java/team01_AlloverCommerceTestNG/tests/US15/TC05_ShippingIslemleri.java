package team01_AlloverCommerceTestNG.tests.US15;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC05_ShippingIslemleri {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() {
        allPages.vendorProductManagerPage().setUp();

        //Shipping butonuna tıkla.
        allPages.vendorProductManagerPage().shipping.click();

        //Açılan alanlardan weight alanına geçerli bir veri gir.
        allPages.vendorProductManagerPage().weightBox.sendKeys("5");

        //Dimensions alanında bulunan "length,width,height" alanına geçerli bir veri gir.
        allPages.vendorProductManagerPage().lengthBox.sendKeys("5");
        allPages.vendorProductManagerPage().widthBox.sendKeys("5");
        allPages.vendorProductManagerPage().heightBox.sendKeys("5");

        //Shipping class alanında "no shipping class" metni olduğunu doğrula.
        allPages.vendorProductManagerPage().shippingClass.isDisplayed();

        //Processing Time dropdown menüsünden bir veri seç.
        ReusableMethods.ddmIndex(allPages.vendorProductManagerPage().processingTime, 1);

        //Submit butonuna tıkla.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().submitButton);
        ReusableMethods.waitForSecond(3);
        allPages.vendorProductManagerPage().submitButton.click();
        ReusableMethods.waitForSecond(2);
        softAssert.assertTrue(allPages.vendorProductManagerPage().titleErrorMessage.isDisplayed());

        //"Product successfully published" mesajının göründüğünü doğrula.

    }
}
