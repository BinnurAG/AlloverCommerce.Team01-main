package team01_AlloverCommerceTestNG.tests.us10;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P14_VendorRegisterPage;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US_10_TC_04 {


    P14_VendorRegisterPage p14_VendorRegisterPage = new P14_VendorRegisterPage();
    P1_HomePage p1_HomePage = new P1_HomePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void PasswordLevel2() {
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
        //Enter a password with less than 6 characters   in "Password" text box
        p14_VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("tooShort_password"));
        //Verify "Weak"  text is not visible
        ReusableMethods.waitForSecond(3);
        Assert.assertTrue(P14_VendorRegisterPage.passwordStrength.getText().contains("Weak"));
        Driver.getDriver().close();

}
}
