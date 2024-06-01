package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC11_YeniCategoriesEkleme {
    Pages allPages = new Pages();

    @Test
    public void test02() {
        allPages.vendorProductManagerPage().setUp();
        //Add new category linkine tıkla.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().newCategoriesButton);
        allPages.vendorProductManagerPage().newCategoriesButton.click();

        //Category Name alanına geçerli bir data gir.
        allPages.vendorProductManagerPage().CategoriesBox.sendKeys("bijuteri");

        //Add butonuna tıkla.
        allPages.vendorProductManagerPage().addNewCategories.click();
    }
}
