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

public class US_09_TC_02 {
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
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("fakeEmailUrl"));
        String fakeEmail = p14_VendorRegisterPage.fakeEmail.getText();

        // geri dönün ve email adress kısmını bu email ile doldurun
        ReusableMethods.switchToWindow(0);
        P14_VendorRegisterPage.emailBox.sendKeys(fakeEmail);
        // Verify "Verification code sent to your email:" text is visible
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        ReusableMethods.waitForSecond(10);
        Assert.assertTrue(P14_VendorRegisterPage.verificationCodeText.isDisplayed());

        Driver.getDriver().close();
    }
}