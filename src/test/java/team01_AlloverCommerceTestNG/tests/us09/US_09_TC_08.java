package team01_AlloverCommerceTestNG.tests.us09;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P14_VendorRegisterPage;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US_09_TC_08 {
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
        // Verify user is on Vendor Registration Page
        p1_HomePage.VendorRegistrationText.isDisplayed();
        //Kullanıcı fake url'den almış olduğu valid Email adresini girer
        p14_VendorRegisterPage.registrationEmail.sendKeys(ConfigReader.getProperty("registration_valid_email"));
        //Kodu Re-send'e tıklayın
        P14_VendorRegisterPage.reSendCodeButton.click();
        //Geçersiz Yeniden Gönder Kodunu "Verifiation Code" kutusuna girin.
        String resendCode = ConfigReader.getProperty("re_send_invalid_code");
        P14_VendorRegisterPage.reSendCodeInput.sendKeys(resendCode);
        P14_VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("good_password"), Keys.TAB);

        //Girdiğiniz passwordu Confirm Password alanına tekrar giriniz
        p14_VendorRegisterPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("good_password"));
        ReusableMethods.waitForSecond(3);
        //Register butonuna tıkla
        P14_VendorRegisterPage.registerButton.click();

        //Kullanıcının Yeniden Gönderme Kodunu girmediğini doğrulayın "Email Verification Code: This field is required." metni görünür
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Email Verification Code: This field is required."));
        ReusableMethods.waitForSecond(5);
        Driver.getDriver().close();
}
}