package team01_AlloverCommerceTestNG.tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US02_Register_SignUp {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();

    Faker faker = new Faker();

    @Test
    public void testCase01() {
//  Siteye daha önce kayıtlı bir username ile kayıt işlemi gerçekleşmemeli
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
//      ReusableMethods.screenShot("SignOut");
        Assert.assertFalse(p2_registerPage.alreadyRegUserName.getText().contains("Sign Out"));
     // Driver.closeDriver();

    }

    @Test
    public void testCase02() {
//  Siteye daha önce kayıtlı bir email ile kayıt işlemi gerçekleşmemeli
//        Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
//        Register linkine tıkla
        p2_registerPage.register.click();
//        Username alanına bir veri gir
        p2_registerPage.userName.sendKeys(faker.name().username());
//        Your Email address alanına kayıtlı bir veri gir
        p2_registerPage.emailAddress.sendKeys(ConfigReader.getProperty("registeredEmail"));
//        Password alanına 8 karakterli bir veri gir
        p2_registerPage.password.sendKeys(ConfigReader.getProperty("registeredPassword"));
//        I agree to the privacy policy kontrol kutusunu seç
        p2_registerPage.privacyPolicy.click();
//        SIGN UP butonuna tıkla
        p2_registerPage.submitButton.click();
//        Kayıt işleminin gerçekleşmediğini doğrula
        ReusableMethods.visibleWait(p2_registerPage.alreadyRegEmail,10);
//      ReusableMethods.screenShotOfWebElement(p2_registerPage.alreadyRegEmail);
//      ReusableMethods.screenShot("Sign Out");
        Assert.assertFalse(p2_registerPage.alreadyRegEmail.getText().contains("Sign Out"));
//      Driver.closeDriver();
    }

    @Test
    public void testCase03() {
// Siteye daha önce kayıtlı email adres bilgileri girildiginde
// "An account is already registered with your email address.Please log in."uyarısı görülmeli
//        Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
//        Register linkine tıkla
        p2_registerPage.register.click();
//        Username alanına bir veri gir
        p2_registerPage.userName.sendKeys(faker.name().username());
//        Your Email address alanına kayıtlı bir veri gir
        p2_registerPage.emailAddress.sendKeys(ConfigReader.getProperty("registeredEmail"));
//        Password alanına 8 karakterli bir veri gir
        p2_registerPage.password.sendKeys(ConfigReader.getProperty("registeredPassword"));
//        I agree to the privacy policy kontrol kutusunu seç
        p2_registerPage.privacyPolicy.click();
//        SIGN UP butonuna tıkla
        p2_registerPage.submitButton.click();
//        Kayıt işleminin gerçekleşmediğini doğrula
//      ReusableMethods.screenShot("Sign Out");



    }
}
