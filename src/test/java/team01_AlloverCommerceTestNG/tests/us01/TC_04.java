
package team01_AlloverCommerceTestNG.tests.us01;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_04 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test(description = "US01 - TC04 Registration should not occur when username section is empty")
    public void emptyUsernameTest() {
// Siteye müşteri olarak kayıt olurken username alanı boş bırakıldığında kayıt işlemi gerçekleşmemeli
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
//        ExtentReportUtils.extentTestInfo("https://allovercommerce.com/");
//        Register linkine tıkla
        p2_registerPage.register.click();
//        Username alanını boş bırak
        p2_registerPage.userName.sendKeys("");
//        Your Email address alanına bir veri gir
        p2_registerPage.emailAddress.sendKeys(faker.internet().emailAddress());
//        Password alanına 8 karakterli bir veri gir
        p2_registerPage.password.sendKeys(ConfigReader.getProperty("registeredPassword"));
//        I agree to the privacy policy kontrol kutusunu seç
        p2_registerPage.privacyPolicy.click();
//        SIGN UP butonuna tıkla
        p2_registerPage.submitButton.click();
//        Kayıt işleminin gerçekleşmediğini doğrula

//      ExtentReportUtils.extentTestPass("Test basarılı oldu");
//      ExtentReportUtils.addScreenShotToReport();
        Assert.assertTrue(p2_registerPage.register.isEnabled());
        Driver.closeDriver();
    }









}
