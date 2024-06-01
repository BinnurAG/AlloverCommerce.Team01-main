
package team01_AlloverCommerceTestNG.tests.us02;

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

    @Test(description = "US02 - TC04 A warning message should appear when the registered username is entered")
    public void registeredUsernameAlertTest() {
//  Siteye daha önce kayıtlı username bilgileri girildiginde
//  "An account is already registered with your that username.Please choose another."uyarısı görülmeli
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        p2_registerPage.register.click();
//        Username alanına kayıtlı bir veri gir
        p2_registerPage.userName.sendKeys(ConfigReader.getProperty("registeredUserName"));
        p2_registerPage.emailAddress.sendKeys(faker.internet().emailAddress());
//        Password alanına 8 karakterli bir veri gir
        p2_registerPage.password.sendKeys(ConfigReader.getProperty("registeredPassword"));
        p2_registerPage.privacyPolicy.click();
        p2_registerPage.submitButton.click();
//        Kayıt işleminin gerçekleşmediğini doğrula
//     ExtentReportUtils.extentTestPass("Test basarili oldu");
//     ExtentReportUtils.addScreenShotToReport();
        String actualMessage2 = p2_registerPage.plsChooseAnotherMsg.getText();
        Assert.assertEquals(actualMessage2,"An account is already registered with that username. Please choose another.");
         Driver.closeDriver();

    }
}
