package team01_AlloverCommerceTestNG.tests;

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
        Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));

                p1_HomePage.signInButton.click();
                p1_HomePage.singUpButton.click();
                p1_HomePage.becomeAVendorButton.click();
                P14_VendorRegisterPage.registrationEmail.sendKeys(ConfigReader.getProperty("registration_valid_email"));
                ReusableMethods.waitForSecond(2);
                P14_VendorRegisterPage.reSendCodeButton.click();
                p14_VendorRegisterPage.reSendCodeInput.sendKeys(ConfigReader.getProperty("re_send_valid_code"));
                p14_VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("tooShort_password"));
                ReusableMethods.waitForSecond(3);
        Assert.assertTrue(P14_VendorRegisterPage.passwordStrength.getText().contains("Too short"));
        ReusableMethods.waitForSecond(3);

        Driver.getDriver().quit();


    }
}