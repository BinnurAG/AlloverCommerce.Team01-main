package team01_AlloverCommerceTestNG.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P12_ComparePage;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.pages.P12_ComparePage.*;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;

public class US07_Compare extends ReusableMethods {

    //Pages allPages = new Pages();

    P12_ComparePage p12_comparePage = new P12_ComparePage();
    P6_AccountDetails p6_accountDetails = new P6_AccountDetails();
    Actions actions = new Actions(getDriver());
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @BeforeClass
    public void beforeClass() {
        loginToSite();
    }

    @AfterMethod
    public void tearDown() {
        click(P6_AccountDetails.signOut);
    }

    @Test
    public void test01_AddTwoProductsToCompareList() {
        searchProductAndShowAsList("Bilgisayar");
        AddNewProduct(1);

        // Sol taraftaki yazan ürün sayısı;
        int count = Integer.parseInt(comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 2, "Products count is not 2.");

        js.executeScript("arguments[0].remove();", comparePopup);
    }

    @Test
    public void test02_MaxFourProductsShouldBeAddedToCompareList() {

        searchProductAndShowAsList("Bilgisayar");

        AddNewProduct(3);

        js.executeScript("arguments[0].remove();", comparePopup);
        searchProductAndShowAsList("phone");

        int count = Integer.parseInt(comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 4, "Products count is not 4.");
        click(cleanAllButton);

        js.executeScript("arguments[0].remove();", comparePopup);

    }

    @Test

    public void test03_AllProductsShouldBeDeletedFromTheComparisonListAndAddNewOnes() {

        searchProductAndShowAsList("Bilgisayar");

        AddNewProduct(3);

     //   deleteProduct(3);

        Actions action = new Actions(getDriver());
        actions.clickAndHold(scrollBarInComparePopup).moveByOffset(100, 0).perform();

    //    deleteProduct(1);

        AddNewProduct(2);

        int count = Integer.parseInt(comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 2, "Products count is not 2.");
        click(cleanAllButton);

        js.executeScript("arguments[0].remove();", comparePopup);
    }

    @Test
    public void test04_DeleteSomeOrAllProductsAndAddNewOnes() {

        searchProductAndShowAsList("Bilgisayar");

        AddNewProduct(3);

      //  deleteProduct(1);

        js.executeScript("arguments[0].remove();", comparePopup);
        searchProductAndShowAsList("phone");
        click(cleanAllButton);

        int count = Integer.parseInt(comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 0, "Products count is not 0.");

        js.executeScript("arguments[0].remove();", comparePopup);
        searchProductAndShowAsList("phone");

        assertTrue(startCompareButton.isDisplayed());
        click(cleanAllButton);

        js.executeScript("arguments[0].remove();", comparePopup);
    }

    @Test
    public void test05_TwoProductsShouldBeCompared() {
        searchProductAndShowAsList("Bilgisayar");

        AddNewProduct(1);

        click(startCompareButton);
        visibleWait(compareField, 5);
        assertTrue(compareField.isDisplayed(), "Karşılastırma ekranı açılmadı.");
      //  deleteProductFromCompareScreen(2);
    }

    @Test
    public void test06_TheCompareScreen() {

        searchProductAndShowAsList("Bilgisayar");

        AddNewProduct(3);

        click(startCompareButton);
        visibleWait(compareField, 5);

    //    deleteProductFromCompareScreen(4);
        visibleWait(noProductsAddedToCompareList, 5);
        assertTrue(noProductsAddedToCompareList.isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        getDriver().quit();
    }
}
