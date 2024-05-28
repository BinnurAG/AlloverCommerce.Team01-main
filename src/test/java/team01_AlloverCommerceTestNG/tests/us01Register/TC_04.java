package team01_AlloverCommerceTestNG.tests.us01Register;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_04 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test(description = "US01 - TC04 The user should be able to register in toLowerCase")
    public void toLowerCaseTest() {
// Siteye müşteri olarak kayıt olurken username alanına sadece küçük harf girilebilmeli
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        p2_registerPage.register.click();
//        Username alanına sadece küçük harf gir
        p2_registerPage.userName.sendKeys("dhkhkutng");
//        Your Email address alanına bir veri gir
        p2_registerPage.emailAddress.sendKeys(faker.internet().emailAddress());
//        Password alanına 8 karakterli bir veri gir
        p2_registerPage.password.sendKeys(ConfigReader.getProperty("registeredPassword"));
//        I agree to the privacy policy kontrol kutusunu seç
        p2_registerPage.privacyPolicy.click();
//        SIGN UP butonuna tıkla
        p2_registerPage.submitButton.click();
//        Anasayfanın açıldığını ve Sign Out linkinin göründüğünü doğrula
        Assert.assertTrue(p2_registerPage.signOut.isEnabled());
    }
}
