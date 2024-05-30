package team01_AlloverCommerceTestNG.tests.us07;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertEquals;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;
import static team01_AlloverCommerceTestNG.utilities.ReusableMethods.*;

public class TC02 {

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
    public void test_MaxFourProductsShouldBeAddedToCompareList() {

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

    @AfterClass
    public void afterClass() {
        getDriver().quit();
    }
}