package team01_AlloverCommerceTestNG.tests;

import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.*;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.*;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;

@Listeners(team01_AlloverCommerceTestNG.utilities.Listeners.class)
public class US06_BeAbleToShop extends ReusableMethods {

    P6_AccountDetails p6_accountDetails = new P6_AccountDetails();

    @BeforeClass
    public void beforeClass() {
        loginToSite();
    }

    @Test
    public void test01_SearchProduct() {
        searchBox.sendKeys("Blue Ski Boots");
        searchBox.submit();
        assertTrue(searchResults.isDisplayed(), "Arama sonuçları görünmüyor.");
        waitForSecond(2);
    }

    @Test
    public void test02_EmptySearch() {
        click(searchIcon);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("alert('Lütfen bu alanı doldurun.')");
        Alert alert = getDriver().switchTo().alert();
        alertWait(2);
        String alertText = alert.getText();
        assertTrue(alertText.contains("Lütfen bu alanı doldurun."));
        waitForSecond(2);
        alertAccept();
    }

    @Test
    public void test03_NonexistentProduct() {
        searchBox.sendKeys("xyz", Keys.ENTER);
        assertTrue(getDriver().findElement(By.xpath("//p[@class='alert alert-light alert-info woocommerce-info']")).isDisplayed(), "Uyarı mesajı alınmadı.");
    }

    @Test
    public void test04_AddToCart() {
        searchBox.sendKeys("Blue Ski Boots", Keys.ENTER);
        String initialCount = P6_AccountDetails.cartCount.getText();
        click(addToCartButton);
        waitForSecond(2);
        String newCount = cartCount.getText();
        assertNotEquals(initialCount, newCount);
        click(cart);
        getDriver().findElement(By.tagName("h4")).isDisplayed();
    }

    @Test
    public void test05_QuantityIncrease() {
        searchBox.sendKeys("Blue Ski Boots");
        searchBox.submit();
        click(addToCartButton);
        click(cart);
        visibleWait(viewCartButton, 5);
        click(viewCartButton);
        visibleWait(orderCompleteButton, 10);
        WebElement quantityInput = getDriver().findElement(By.xpath("//input[@class='input-text qty text']"));
        int initialQuantity = Integer.parseInt(quantityInput.getAttribute("value"));
        click(quantityPlusButton);
        int updatedQuantity = Integer.parseInt(quantityInput.getAttribute("value"));
        assertEquals(updatedQuantity, initialQuantity + 1, "Ürün miktarı artmadı.");
    }

    @Test
    public void test06_QuantityDecrease() {
        increaseQuantity(quantityPlusButton, 5);
        WebElement quantityInput = getDriver().findElement(By.xpath("//input[@class='input-text qty text']"));
        int updatedQuantity2 = Integer.parseInt(quantityInput.getAttribute("value"));
        click(quantityMinusButton);
        int updatedQuantity3 = Integer.parseInt(quantityInput.getAttribute("value"));
        assertNotEquals(updatedQuantity2, updatedQuantity3, "Ürün miktarı azalmadı.");
    }

    @Test
    public void test07_CheckoutWireTransfer() {
        assertTrue(shippingAddress.isDisplayed());
        click(proceedToCheckoutButton);
        click(wireTransfer);
        assertTrue(wireTransfer.isSelected(), "Wire Transfer seçilmedi.");
    }

    @Test
    public void test08_CheckoutPayAtTheDoor() {
        click(payAtTheDoor);
        assertTrue(payAtTheDoor.isSelected(), "Pay at the Door seçilmedi.");
        click(placeOrderButton);
        visibleWait(orderReceived, 15);
        assertTrue(orderReceived.isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        getDriver().quit();
    }
}