
package team01_AlloverCommerceTestNG.tests.us02;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;

public class TC_02 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test(description = "US02 - TC02 The user should not register new with a registered email")
    public void registeredEmailTest() {
//  Siteye daha önce kayıtlı bir email ile kayıt işlemi gerçekleşmemeli
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
       ExtentReportUtils.extentTestPass("Test basarili oldu");
       ExtentReportUtils.addScreenShotToReport();
        Assert.assertFalse(p2_registerPage.plsLogInMsg.getText().contains("Sign Out"));
      Driver.closeDriver();
    }
}
