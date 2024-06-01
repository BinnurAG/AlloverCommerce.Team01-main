package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC12_YeniProductBrandsEkleme {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() {

        allPages.vendorProductManagerPage().setUp();

        //Add new Product brands linkine tıkla.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().addNewProducts);
        WaitUtils.waitFor(1);
        allPages.vendorProductManagerPage().addNewProducts.click();
        WaitUtils.waitFor(1);

        //Product brands name alanına geçerli bir data gir.
        allPages.vendorProductManagerPage().ProductBox.sendKeys("bbb");
        WaitUtils.waitFor(1);

        //Yeni marka eklendiğini doğrula.
        softAssert.assertTrue(allPages.vendorProductManagerPage().verifyAddProduct.isDisplayed());

    }
}
