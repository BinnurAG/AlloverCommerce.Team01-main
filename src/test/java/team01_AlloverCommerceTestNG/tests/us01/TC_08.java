
package team01_AlloverCommerceTestNG.tests.us01;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_08 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test(description = "US01 - TC08 Registration should not be possible with a 7 character password")
    public void boundaryValueAnalysisTest() {//BUG RAPORA YANSIT //BOUNDARY VALUA ANALYS
// Siteye müşteri olarak kayıt olurken 7 karakterli bir password ile kayıt işlemi gerçekleşmemeli
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportUtils.extentTestInfo("Kullanıcıweb sitesine gider");
//        Register linkine tıkla
        p2_registerPage.register.click();
//        Username alanına bir veri gir
        p2_registerPage.userName.sendKeys(faker.name().username());
//        Your Email adrdress alanına bir veri gir
        p2_registerPage.emailAddress.sendKeys(faker.internet().emailAddress());
//        Password alanına 7 karakterli bir veri gir
        p2_registerPage.password.sendKeys("08*24Lu");
//        I agree to the privacy policy kontrol kutusunu seç
        p2_registerPage.privacyPolicy.click();
//        SIGN UP butonuna tıkla
        p2_registerPage.submitButton.click();
        ReusableMethods.waitForSecond(5);
//       Kayıt işleminin gerçekleşmediğini doğrula

       ExtentReportUtils.extentTestFail("gecersiz password ile kayıt islemi gerceklesti");
        Assert.assertTrue(p2_registerPage.register.isEnabled());
        Driver.closeDriver();
    }

}
