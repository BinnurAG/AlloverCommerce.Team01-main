
package team01_AlloverCommerceTestNG.tests.us01;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_07 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test(description = "US01 - TC07 Registration should not be possible with an invalid email")
    public void invalidEmailTest() {
//  Siteye müşteri olarak kayıt olurken
//  email adresi abc@abc.com formatında olmadan kayıt işlemi gerçekleşmemeli
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        p2_registerPage.register.click();
//        Username alanına bir veri gir
        p2_registerPage.userName.sendKeys(faker.name().username());
//        Your Email address alanına geçersiz bir veri gir
        p2_registerPage.emailAddress.sendKeys(ConfigReader.getProperty("invalidEmail"));
//        Password alanına 8 karakterli bir veri gir
        p2_registerPage.password.sendKeys(ConfigReader.getProperty("registeredPassword"));
//        I agree to the privacy policy kontrol kutusunu seç
        p2_registerPage.privacyPolicy.click();
//        SIGN UP butonuna tıkla
        p2_registerPage.submitButton.click();
//        Kayıt işleminin gerçekleşmediğini doğrula
        Assert.assertTrue(p2_registerPage.register.isEnabled());
        Driver.closeDriver();
    }
}
