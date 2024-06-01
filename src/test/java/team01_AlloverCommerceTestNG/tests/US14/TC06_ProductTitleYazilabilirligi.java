package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC06_ProductTitleYazilabilirligi {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() {

        allPages.vendorProductManagerPage().setUp();
        //"Product Title" alanına veri gir.
        allPages.vendorProductManagerPage().productTitle.sendKeys("kolye");

        //Girilen verinin göründüğünü doğrula.
        String actualResultText = "kolye";
        softAssert.assertEquals(actualResultText, allPages.vendorProductManagerPage().productTitleBox.getText());

        allPages.vendorProductManagerPage().tearDown();
    }
}
