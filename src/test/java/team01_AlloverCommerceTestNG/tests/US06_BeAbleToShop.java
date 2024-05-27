package team01_AlloverCommerceTestNG.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.*;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;

public class US06_BeAbleToShop extends ReusableMethods {

    P6_AccountDetails p6_accountDetails = new P6_AccountDetails();

    // US06_BeAbleToShop : Kullanıcı siteden alışveriş yapabilmeli


    @Test
    public void test01() throws InterruptedException {

        // TC01 : Kullanıcı siteden alışveriş yaparken search boxtan istediği bir ürünü arayabilmeli

        // 1. Web sitesine git
        getDriver().get(ConfigReader.getProperty("alloverUrl"));

        // 2. Sing In butonuna tikla
        click(signIn);

        // 3. Username or email adress kutusuna geçerli bir email adresi gir
        userNameArea.sendKeys(ConfigReader.getProperty("myEmail"));

        // 4. Password alanına geçerli bir password gir
        passwordArea.sendKeys(ConfigReader.getProperty("myPassword"));

        // 5. Sing In butonuna tikla
        click(signInButton);
        visibleWait(signOut, 5);

        // 6. Search kutusuna bir ürün yaz ve entera bas
        searchBox.sendKeys("Blue Ski Boots");
        searchBox.submit();

        // 7. Arama sonuçlarının göründüğünü doğrula
        searchResults.isDisplayed();
        waitForSecond(2);

        //----------------------------------------------------------------------------------

        // TC 02 : Kullanıcı siteden alışveriş yaparken search boxta ürün ismi girmeden arama yaptığında uyarı vermeli

        // 1. Search ikonuna tıkla
        click(searchIcon);

        // 2. Uyarı mesajı verildiğini doğrula
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("alert('Lütfen bu alanı doldurun.')");
        Alert alert = getDriver().switchTo().alert();
        alertWait(2);
        String alertText = alert.getText();
        assertTrue(alertText.contains("Lütfen bu alanı doldurun."));
        waitForSecond(2);
        alertAccept();

        //-----------------------------------------------------------------------------------

        // TC 03 :  Kullanıcı siteden alışveriş yaparken search boxta databasede tanımlı olmayan
        //          bir ürün ismi girdiğinde ürünün olmadığına dair uyarı mesajı vermeli

        // 1. Search kutusuna databasede tanımlı olmayan bir ürün ismi gir
        searchBox.sendKeys("xyz", Keys.ENTER);

        // 2. Uyarı mesajı verildiğini gör
        getDriver().findElement(By.xpath("//p[@class='alert alert-light alert-info woocommerce-info']")).isDisplayed();

        //------------------------------------------------------------------------------------

        // TC 04 : Aranan ürün sepete eklenmeli

        // 1. Search kutusuna bir ürün yaz ve entera bas
        searchBox.sendKeys("Blue Ski Boots", Keys.ENTER);

        // 2. Bulunan ürünü  sepete (Add to cart) ekle ve ürünün sepete eklendiğini doğrula
        String initialCount = P6_AccountDetails.cartCount.getText();
        click(addToCartButton);
        waitForSecond(2);
        String newCount = cartCount.getText();
        assertNotEquals(initialCount, newCount);


        //------------------------------------------------------------------------------------

        // TC 05 : Sepete eklenen ürünler görülebilmeli
        click(cart);
        getDriver().findElement(By.tagName("h4")).isDisplayed();
        getDriver().quit();

    }
}
