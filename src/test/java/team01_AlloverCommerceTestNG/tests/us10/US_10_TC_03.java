package team01_AlloverCommerceTestNG.tests.us10;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P14_VendorRegisterPage;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US_10_TC_03 {
        P14_VendorRegisterPage p14_VendorRegisterPage = new P14_VendorRegisterPage();
        P1_HomePage p1_HomePage = new P1_HomePage();
        Actions actions = new Actions(Driver.getDriver());

        @Test
        public void PasswordLevelweak() {
            // //User should navigate to Allover Commerce url
            Driver.getDriver().get(ConfigReader.getProperty("all_over_commerce_url"));
            //Click on "Sign In" button
            p1_HomePage.signInButton.click();
            //Click on "Sign Up" button
            p1_HomePage.singUpButton.click();
            //Click on "Become a Vendor" to navigate Vendor Registration Page
            p1_HomePage.becomeAVendorButton.click();
//Enter valid Re-Send Code in "Verification Code" box.
            p14_VendorRegisterPage.reSendCodeInput.sendKeys(ConfigReader.getProperty("registration_valid_email"));
            ReusableMethods.waitForSecond(3);
            P14_VendorRegisterPage.reSendCodeButton.click();
            //Enter valid Re-Send Code in "Verification Code" box
            ReusableMethods.waitForSecond(3);
            p14_VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("re_send_valid_code"));
            ReusableMethods.waitForSecond(3);
            //"Parola" metin kutusuna sadece rakamlar veya sadece alfabetik karakterler içeren 5 karakterden fazla bir parola girin
            p14_VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("weak_password"));
            //Verify "Weak"  text is visible
            Assert.assertTrue(P14_VendorRegisterPage.passwordStrength.getText().contains("Weak"));
            ReusableMethods.waitForSecond(3);
            Driver.getDriver().close();
        }
}

