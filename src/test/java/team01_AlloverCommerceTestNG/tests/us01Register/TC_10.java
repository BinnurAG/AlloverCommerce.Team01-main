package team01_AlloverCommerceTestNG.tests.us01Register;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_10 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test(description = "US01 - TC10 Registration should be possible with a 9 characters password")
    public void boundaryValueAnalysisTest() {
//  Siteye müşteri olarak kayıt olurken 9 karakterli bir password ile kayıt işlemi gerçekleşmeli
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
//        Register linkine tıkla
        p2_registerPage.register.click();
//        Username alanına bir veri gir
        p2_registerPage.userName.sendKeys(faker.name().username());
//        Your Email adrdress alanına bir veri gir
        p2_registerPage.emailAddress.sendKeys(faker.internet().emailAddress());
//        Password alanına 9 karakterli bir veri gir
        p2_registerPage.password.sendKeys(ConfigReader.getProperty("nineCharacterPassword"));
//        I agree to the privacy policy kontrol kutusunu seç
        p2_registerPage.privacyPolicy.click();
//        SIGN UP butonuna tıkla
        p2_registerPage.submitButton.click();
//        Anasayfanın açıldığını ve Sign Out linkinin göründüğünü doğrula
        Assert.assertTrue(p2_registerPage.signOut.isEnabled());
        Driver.closeDriver();
    }
}
