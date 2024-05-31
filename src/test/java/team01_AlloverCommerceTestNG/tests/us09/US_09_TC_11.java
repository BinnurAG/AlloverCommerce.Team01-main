package team01_AlloverCommerceTestNG.tests.us09;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P14_VendorRegisterPage;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US_09_TC_11 {



    P14_VendorRegisterPage p14_VendorRegisterPage = new P14_VendorRegisterPage();
    P1_HomePage p1_HomePage = new P1_HomePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void testName() {
        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        //Kullanıcı Register butonuna tıklar
        p1_HomePage.registerButton.click();
        //Kullanıcı Sign Up ekranından Become a Vendor linkine tıklar
        p1_HomePage.becomeAVendorButton.click();
        //Kullanıcı fake url'den almış olduğu valid Email adresini girer
        p14_VendorRegisterPage.registrationEmail.sendKeys(ConfigReader.getProperty("registration_valid_email"));
        //Kodu Re-send'e tıklayın
        P14_VendorRegisterPage.reSendCodeButton.click();
        //Geçerli Yeniden Gönder Kodunu "Verifiation Code" kutusuna girin
        P14_VendorRegisterPage.reSendCodeInput.sendKeys(ConfigReader.getProperty("re_send_valid_code"));
        //Geçerli parolayı "Şifre" metin kutusuna girin
        P14_VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("good_password"));
        //Şifreyi "Confirm Password:" metin kutusuna tekrar girin
        p14_VendorRegisterPage.confirmPassword.sendKeys(Keys.TAB);
        ReusableMethods.waitForSecond(3);
        P14_VendorRegisterPage.registerButton.click();
       //Doğrulama "Confirm Password: This field is required." metin görünmedigini dogrula
        Assert.assertTrue(P14_VendorRegisterPage.errorMessage.getText().contains("Confirm Password: This field is required."));
        ReusableMethods.waitForSecond(3);
        ReusableMethods.screenShot("US_09_TC_11");
        Driver.getDriver().quit();
}
}

