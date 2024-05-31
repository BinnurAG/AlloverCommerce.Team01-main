
package team01_AlloverCommerceTestNG.tests.us01;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;

public class TC_04 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test(description = "US01 - TC04 New registration should not be possible with the registered username")
    public void registeredUsernameTest() {
// Siteye müşteri olarak kayıt olurken daha önce kayıtlı bir username ile kayıt işlemi gerçekleşmemeli
//        Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
//        Register linkine tıkla
        p2_registerPage.register.click();
//        Username alanına kayıtlı bir veri gir
        p2_registerPage.userName.sendKeys(ConfigReader.getProperty("registeredUserName"));
//        Your Email address alanına bir veri gir
        p2_registerPage.emailAddress.sendKeys(faker.internet().emailAddress());
//        Password alanına 8 karakterli bir veri gir
        p2_registerPage.password.sendKeys(ConfigReader.getProperty("registeredPassword"));
//        I agree to the privacy policy kontrol kutusunu seç
        p2_registerPage.privacyPolicy.click();
//        SIGN UP butonuna tıkla
        p2_registerPage.submitButton.click();
//        Kayıt işleminin gerçekleşmediğini doğrula

//      ExtentReportUtils.extentTestPass("Test basarili oldu");
//      ExtentReportUtils.addScreenShotToReport();
        String actualMsg = p2_registerPage.plsChooseAnotherMsg.getText();
        Assert.assertEquals
                (actualMsg,"An account is already registered with that username. Please choose another.");
        Driver.closeDriver();
    }

}
