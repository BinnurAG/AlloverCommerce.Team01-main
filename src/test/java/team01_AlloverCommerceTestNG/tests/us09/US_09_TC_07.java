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

public class US_09_TC_07 {
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
        p14_VendorRegisterPage.registrationEmail.sendKeys(ConfigReader.getProperty("registration_invalid_email"));
        //Doğrulama "Verification code sent to your email:" metni görünmüyor
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        ReusableMethods.waitForSecond(3);
        Assert.assertTrue(P14_VendorRegisterPage.provideValidEmailText.getText().contains("Verification code sent to your email:"));
        //ReusableMethods.screenShot("US_09_TC_07");
        Driver.getDriver().close();













}
}
