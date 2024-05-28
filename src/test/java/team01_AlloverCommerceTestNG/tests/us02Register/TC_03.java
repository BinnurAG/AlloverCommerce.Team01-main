package team01_AlloverCommerceTestNG.tests.us02Register;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_03 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test(description = "US02 - TC03 A warning message should appear when the registered email is entered")
    public void registeredEmailAlertTest() {
//  Siteye daha önce kayıtlı email adres bilgileri girildiginde
//  "An account is already registered with your email address.Please log in."uyarısı görülmeli
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        p2_registerPage.register.click();
        p2_registerPage.userName.sendKeys(faker.name().username());
//        Your Email address alanına kayıtlı bir veri gir
        p2_registerPage.emailAddress.sendKeys(ConfigReader.getProperty("registeredEmail"));
//        Password alanına 8 karakterli bir veri gir
        p2_registerPage.password.sendKeys(ConfigReader.getProperty("registeredPassword"));
        p2_registerPage.privacyPolicy.click();
        p2_registerPage.submitButton.click();
//        Kayıt işleminin gerçekleşmediğini doğrula
        String actualMessage = p2_registerPage.plsLogInMsg.getText();
        Assert.assertEquals
                (actualMessage,"An account is already registered with your email address. Please log in.");

//      Driver.closeDriver();

    }
}
