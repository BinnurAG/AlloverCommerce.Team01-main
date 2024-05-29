package team01_AlloverCommerceTestNG.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P12_ComparePage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.*;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;
import static team01_AlloverCommerceTestNG.utilities.ReusableMethods.*;

public class US07_Compare {

    static Pages allPages = new Pages();
    Actions actions = new Actions(getDriver());
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @BeforeClass
    public void beforeClass() {
        ReusableMethods.loginToSite();
    }

    @AfterMethod
    public void tearDown() {
        click(allPages.addressesPage().signOut);
    }

    @Test
    public void test01_AddTwoProductsToCompareList() {
        searchProductAndShowAsList("Bilgisayar");
        visibleWait(allPages.comparePage().compareIcon, 10);
        click(allPages.comparePage().compareIcon);
        AddNewProduct(1);

        // Compare list should have 2 products;
        int count = Integer.parseInt(allPages.comparePage().comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 2, "Products count is not 2.");

        js.executeScript("arguments[0].remove();", allPages.comparePage().comparePopup);
    }

    @Test
    public void test02_MaxFourProductsShouldBeAddedToCompareList() {

        searchProductAndShowAsList("phone");
        click(allPages.comparePage().compareIcon);
        AddNewProduct(3);

        js.executeScript("arguments[0].remove();", allPages.comparePage().comparePopup);
        searchProductAndShowAsList("bilgisayar");
        click(allPages.comparePage().compareIcon);

        int count = Integer.parseInt(allPages.comparePage().comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 4, "Products count is not 4.");
        click(allPages.comparePage().cleanAllButton);

        js.executeScript("arguments[0].remove();", allPages.comparePage().comparePopup);

    }

    @Test

    public void test03_AllProductsShouldBeDeletedFromTheComparisonListAndAddNewOnes() {

        searchProductAndShowAsList("Bilgisayar");
        click(allPages.comparePage().compareIcon);
        AddNewProduct(3);

        deleteProduct(3);
        actions.clickAndHold(allPages.comparePage().scrollBarInComparePopup).moveByOffset(100, 0).perform();
        deleteProduct(1);

        AddNewProduct(2);

        int count = Integer.parseInt(allPages.comparePage().comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 2, "Products count is not 2.");
        click(allPages.comparePage().cleanAllButton);

        js.executeScript("arguments[0].remove();",  allPages.comparePage().comparePopup);
    }

    @Test
    public void test04_DeleteSomeOrAllProductsAndAddNewOnes() {

        searchProductAndShowAsList("phone");
        click(allPages.comparePage().compareIcon);
        AddNewProduct(3);

        deleteProduct(1);

        js.executeScript("arguments[0].remove();", allPages.comparePage().comparePopup);
        click(allPages.comparePage().compareIcon);
        click(allPages.comparePage().cleanAllButton);

        int count = Integer.parseInt(allPages.comparePage().comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 0, "Products count is not 0.");

        js.executeScript("arguments[0].remove();",  allPages.comparePage().comparePopup);
        click(allPages.comparePage().compareIcon);
        AddNewProduct(2);

        assertTrue(allPages.comparePage().startCompareButton.isDisplayed());

    }

    @Test
    public void test05_TwoProductsShouldBeCompared() {
        searchProductAndShowAsList("Bilgisayar");
        click(allPages.comparePage().compareIcon);
        AddNewProduct(1);

        click(allPages.comparePage().startCompareButton);
        visibleWait(allPages.comparePage().compareField, 5);
        assertTrue(allPages.comparePage().compareField.isDisplayed(), "Karşılastırma ekranı açılmadı.");

    }

    @Test
    public void test06_TheCompareScreen() {

        searchProductAndShowAsList("phone");
        click(allPages.comparePage().compareIcon);
        AddNewProduct(3);

        click(allPages.comparePage().startCompareButton);
        visibleWait(allPages.comparePage().compareField, 5);

        deleteProductFromCompareScreen(4);
        visibleWait(allPages.comparePage().noProductsAddedToCompareList, 5);
        assertTrue(allPages.comparePage().noProductsAddedToCompareList.isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        getDriver().quit();
    }
}
