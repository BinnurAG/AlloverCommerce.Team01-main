
package team01_AlloverCommerceTestNG.tests.us01;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_12 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test(description = "US01 - TC12 Registration should not occur without entering username,password and email")
    public void emptyChTest() {
// Siteye müşteri olarak kayıt olurken
// Username,Email address ve Password girilmeden SIGN UP tıklandığında kayıt gerçekleşmemeli
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        p2_registerPage.register.click();
        p2_registerPage.userName.sendKeys("");
        p2_registerPage.emailAddress.sendKeys("");
        p2_registerPage.password.sendKeys("");
        p2_registerPage.privacyPolicy.click();
        p2_registerPage.submitButton.click();

//      Kayıt işleminin gerçekleşmediğini doğrula
        Assert.assertTrue(p2_registerPage.submitButton.isEnabled());
        Driver.closeDriver();

    }
}
