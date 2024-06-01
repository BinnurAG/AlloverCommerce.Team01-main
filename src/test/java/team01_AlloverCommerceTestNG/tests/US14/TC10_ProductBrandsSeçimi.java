package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC10_ProductBrandsSeçimi {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01(){
        allPages.vendorProductManagerPage().setUp();
        //Product brands başlığı altında bulunan seçeneklerden ürün ile ilişkili olanları seç.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().productCategories);
        WaitUtils.waitFor(1);
        allPages.vendorProductManagerPage().addProductBrands.click();

        //Product brands alanından seçim yapıldığını doğrula.
        softAssert.assertTrue(allPages.vendorProductManagerPage().addProductBrands.isSelected());
        allPages.vendorProductManagerPage().tearDown();
    }
}
