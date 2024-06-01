package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC01_DropdownMenu {  // Simple Product, Variable Product, Grouped Product, External - Affiliate Product seçenekleri olmalı (PASS)


    Pages allPages = new Pages();

    @Test(description = "US14 - TC01 / Simple Product, Variable Product, Grouped Product, External - Affiliate Product seçenekleri olmalı")
    public void test01()  {

        allPages.vendorProductManagerPage().setUp();

        //Simple Product dropdown menüsünün görünür olduğunu doğrula.
        allPages.vendorProductManagerPage().dropdownSimpleProduct.isDisplayed();

        //Simple Product dropdown menusune tikla.
        allPages.vendorProductManagerPage().dropdownSimpleProduct.click();
        WaitUtils.waitFor(1);

        //Menüde; Simple Product, Variable Product, Grouped Product ve External/Affiliate Product seçeneklerinin olduğunu doğrula.
        ReusableMethods.ddmIndex(allPages.vendorProductManagerPage().dropdownSimpleProduct, 0);
        ReusableMethods.ddmIndex(allPages.vendorProductManagerPage().dropdownSimpleProduct, 1);
        ReusableMethods.ddmIndex(allPages.vendorProductManagerPage().dropdownSimpleProduct, 2);
        ReusableMethods.ddmIndex(allPages.vendorProductManagerPage().dropdownSimpleProduct, 3);

        allPages.vendorProductManagerPage().tearDown();
    }



}