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

public class US_09_TC_09 {
    P14_VendorRegisterPage p14_VendorRegisterPage = new P14_VendorRegisterPage();
    P1_HomePage p1_HomePage = new P1_HomePage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void testName() {

        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        //Register linkine tıkla
        p1_HomePage.registerButton.click();
        //SİNG UP sekmesini kullanarak "Become a Vendor" linkine tıkla
        p1_HomePage.becomeAVendorButton.click();
        //Geçerli bir email gir
        p14_VendorRegisterPage.registrationEmail.sendKeys(ConfigReader.getProperty("registration_valid_email"));
        //Açılan pop un sayfasında herhangi bir boş alana tıkla
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
       // Verification Code kutusunu bos birak
        //Password alanına bir şifre gir
        P14_VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("good_password"),Keys.TAB);
        ReusableMethods.waitForSecond(3);
        //Girdiğiniz passwordu Confirm Password alanına tekrar giriniz
        p14_VendorRegisterPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("good_password"));
        //Register butonuna tıkla
        P14_VendorRegisterPage.registerButton.click();
        ReusableMethods.waitForSecond(3);
       // Kayıt işleminin gerçekleşmediğini doğrulayin
        Assert.assertTrue(P14_VendorRegisterPage.emailWrongText.getText().contains("Email Verification Code: This field is required."));

        Driver.getDriver().close();


        }
}
