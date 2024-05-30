package team01_AlloverCommerceTestNG.tests.us06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertNotEquals;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.*;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;

@Listeners(team01_AlloverCommerceTestNG.utilities.Listeners.class)
public class TC06 extends ReusableMethods {

    P6_AccountDetails p6_accountDetails = new P6_AccountDetails();

    @BeforeClass
    public void beforeClass() {
        loginToSite();
    }

    @Test
    public void test_QuantityDecrease() {
        increaseQuantity(quantityPlusButton, 5);
        WebElement quantityInput = getDriver().findElement(By.xpath("//input[@class='input-text qty text']"));
        int updatedQuantity2 = Integer.parseInt(quantityInput.getAttribute("value"));
        click(quantityMinusButton);
        int updatedQuantity3 = Integer.parseInt(quantityInput.getAttribute("value"));
        assertNotEquals(updatedQuantity2, updatedQuantity3, "Ürün miktarı azalmadı.");
    }

    @AfterClass
    public void afterClass() {
        getDriver().quit();
    }
}