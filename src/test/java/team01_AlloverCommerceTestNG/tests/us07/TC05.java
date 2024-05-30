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
import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;
import static team01_AlloverCommerceTestNG.utilities.ReusableMethods.*;

public class TC05 {

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
    public void test_TwoProductsShouldBeCompared() {
        searchProductAndShowAsList("Bilgisayar");
        click(allPages.comparePage().compareIcon);
        AddNewProduct(1);

        click(allPages.comparePage().startCompareButton);
        visibleWait(allPages.comparePage().compareField, 5);
        assertTrue(allPages.comparePage().compareField.isDisplayed(), "Karşılastırma ekranı açılmadı.");

    }

    @AfterClass
    public void afterClass() {
        getDriver().quit();
    }

}