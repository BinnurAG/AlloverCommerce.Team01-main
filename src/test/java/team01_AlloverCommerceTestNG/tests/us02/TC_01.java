
package team01_AlloverCommerceTestNG.tests.us02;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_01 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test(description = "US02 - TC01 The user should not register new with a registered username")
    public void registeredUsernameTest() {
//  Siteye daha önce kayıtlı bir username ile kayıt işlemi gerçekleşmemeli
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
//      ReusableMethods.screenShot("SignOut");
        Assert.assertFalse(p2_registerPage.plsChooseAnotherMsg.getText().contains("Sign Out"));
        // Driver.closeDriver();

    }

}
