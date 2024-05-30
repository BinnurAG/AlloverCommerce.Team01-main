
package team01_AlloverCommerceTestNG.tests.us01Register;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_08 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test(description = "US01 - TC08 Registration should not occur when password section is empty")
    public void emptyPasswordTest() {
// Siteye müşteri olarak kayıt olurken password alanı boş bırakıldığında kayıt işlemi gerçekleşmemeli
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        p2_registerPage.register.click();
//        Username alanına bir veri gir
        p2_registerPage.userName.sendKeys(faker.name().username());
//        Your Email adrdress alanına bir veri gir
        p2_registerPage.emailAddress.sendKeys(faker.internet().emailAddress());
//        Password alanını boş bırak
        p2_registerPage.password.sendKeys("");
//        I agree to the privacy policy kontrol kutusunu seç
        p2_registerPage.privacyPolicy.click();
//        SIGN UP butonuna tıkla
        p2_registerPage.submitButton.click();
//        Kayıt işleminin gerçekleşmediğini doğrula
        Assert.assertTrue(p2_registerPage.register.isEnabled());
        Driver.closeDriver();
    }

}
