package team01_AlloverCommerceTestNG.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P14_VendorRegisterPage;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;

public class US_09_TC_01 {
    P14_VendorRegisterPage p14_VendorRegisterPage = new P14_VendorRegisterPage();
    P1_HomePage p1_HomePage = new P1_HomePage();
        Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test0Tc_01() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        p1_HomePage.signInButton.click();
        p1_HomePage.singUpButton.click();
        p1_HomePage.becomeAVendorButton.click();
        p1_HomePage.VendorRegistrationText.isDisplayed();
        P14_VendorRegisterPage.registrationEmail.sendKeys(ConfigReader.getProperty("registration_valid_email"));
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        assertTrue(P14_VendorRegisterPage.verificationCodeText.isDisplayed());
         Driver.getDriver().quit();

    }
}
