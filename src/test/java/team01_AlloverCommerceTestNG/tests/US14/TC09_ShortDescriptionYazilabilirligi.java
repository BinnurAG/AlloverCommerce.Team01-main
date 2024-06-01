package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC09_ShortDescriptionYazilabilirligi {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() {
        allPages.vendorProductManagerPage().setUp();
        // "Short Description" alanına veri gir.
        Driver.getDriver().switchTo().frame(0);
        allPages.vendorProductManagerPage().shortDescription.sendKeys("kolye");

        //Girilen verinin göründüğünü doğrula.
        softAssert.assertEquals(allPages.vendorProductManagerPage().shortDescription.getText(), "kolye");
        allPages.vendorProductManagerPage().tearDown();
    }
}


