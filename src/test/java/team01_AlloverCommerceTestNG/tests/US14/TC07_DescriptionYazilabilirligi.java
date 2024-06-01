package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC07_DescriptionYazilabilirligi {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() {
        allPages.vendorProductManagerPage().setUp();
        // "Description" alanına veri gir.
        Driver.getDriver().switchTo().frame(1);
        allPages.vendorProductManagerPage().description.sendKeys("kolye");

        //Girilen verinin göründüğünü doğrula.
        softAssert.assertEquals(allPages.vendorProductManagerPage().description.getText(), "kolye");
        allPages.vendorProductManagerPage().tearDown();
    }

}



