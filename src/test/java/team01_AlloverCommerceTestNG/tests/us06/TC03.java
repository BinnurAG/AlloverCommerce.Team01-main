package team01_AlloverCommerceTestNG.tests.us06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.searchBox;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.searchIcon;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;

@Listeners(team01_AlloverCommerceTestNG.utilities.Listeners.class)
public class TC03 extends ReusableMethods {

    P6_AccountDetails p6_accountDetails = new P6_AccountDetails();

    @BeforeClass
    public void beforeClass() {
        loginToSite();
    }

    @Test
    public void test_NonexistentProduct() {
        searchBox.sendKeys("xyz", Keys.ENTER);
        assertTrue(getDriver().findElement(By.xpath("//p[@class='alert alert-light alert-info woocommerce-info']")).isDisplayed(), "Uyarı mesajı alınmadı.");
    }

    @AfterClass
    public void afterClass() {
        getDriver().quit();
    }
}