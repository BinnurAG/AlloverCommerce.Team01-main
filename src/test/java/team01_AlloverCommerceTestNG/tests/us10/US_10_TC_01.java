package team01_AlloverCommerceTestNG.tests.us10;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P14_VendorRegisterPage;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US_10_TC_01 {
    P14_VendorRegisterPage p14_VendorRegisterPage = new P14_VendorRegisterPage();
    P1_HomePage p1_HomePage = new P1_HomePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void testTc_01() {
        //Kullanıcı Allover Commerce url adresine gitmelidir
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));
        //Giriş Yap" düğmesine tıklayın
                p1_HomePage.signInButton.click();
        //Giriş Yap" düğmesine tıklayın
                p1_HomePage.singUpButton.click();
        //Satıcı Kayıt Sayfasında gezinmek için "Become a Vendor" a tıklayın
                p1_HomePage.becomeAVendorButton.click();
                //geçerli bir e-posta adresi girin
                P14_VendorRegisterPage.Email.sendKeys(ConfigReader.getProperty("registration_valid_email"));
                ReusableMethods.waitForSecond(2);
        //Click on Re-Send Code
                P14_VendorRegisterPage.reSendCodeButton.click();
        //Geçerli Yeniden Gönder Kodunu "Verifiation Code" kutusuna girin
                p14_VendorRegisterPage.reSendCodeInput.sendKeys(ConfigReader.getProperty("re_send_valid_code"));
        //Parola" metin kutusunda 6 karakterden daha az bir parola girin
                p14_VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("tooShort_password"));
                ReusableMethods.waitForSecond(3);
        ////Doğrulayın "Weak" metin görünür
        Assert.assertTrue(P14_VendorRegisterPage.passwordStrength.getText().contains("Too short"));
        ReusableMethods.waitForSecond(3);

        Driver.getDriver().quit();


    }
}