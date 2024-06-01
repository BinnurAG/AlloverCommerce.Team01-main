package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC08_CategoriesSecilebilmeli {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() {

        allPages.vendorProductManagerPage().setUp();

        //Categories başlığı altında bulunan seçeneklerden ürün ile ilişkili olanları seç.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().productCategories);
        WaitUtils.waitFor(1);

        ReusableMethods.click(allPages.vendorProductManagerPage().categoriesBox);

        //Categories alanından seçim yapıldığını doğrula.
        softAssert.assertTrue(allPages.vendorProductManagerPage().categoriesBox.isSelected());
        allPages.vendorProductManagerPage().tearDown();
    }
}
