package team01_AlloverCommerceTestNG.tests.us09;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P14_VendorRegisterPage;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.JSUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US_09_TC_16 {
<<<<<<< Updated upstream
}
=======
    P14_VendorRegisterPage p14_VendorRegisterPage = new P14_VendorRegisterPage();
    P1_HomePage p1_HomePage = new P1_HomePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test_US_09_TC_12() {

        //User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        String alloverCommerceWebSite = Driver.getDriver().getWindowHandle();

        //Click on "Sign In" button
        p1_HomePage.signInButton.click();
        //Click on "Sign up"
        p1_HomePage.singUpButton.click();
        //Click on "Become a Vendor" to navigate Vendor Registration Page
        p1_HomePage.becomeAVendorButton.click();
        //Enter a valid email address
        p14_VendorRegisterPage.registrationEmail.sendKeys(ConfigReader.getProperty("registration_valid_email1"));
        //Click on Re-Send Code
        p14_VendorRegisterPage.reSendCodeButton.click();
        ReusableMethods.waitForSecond(3);
        //Enter valid Re-Send Code in "Verification Code" box.
        p14_VendorRegisterPage.reSendCodeInput.sendKeys(ConfigReader.getProperty("re_send_valid_code1"));
        ReusableMethods.waitForSecond(1);
        //Geçersiz şifreyi "Password" metin kutusuna girin
        p14_VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("strong_password"));
        //Aynı geçersiz parolayı "Confirm Password" metin kutusuna girin
        p14_VendorRegisterPage.confirmPassword.sendKeys(ConfigReader.getProperty("strong_password"));
        ReusableMethods.waitForSecond(3);
        JSUtils.JSclickWithTimeout(p14_VendorRegisterPage.registerButton);
        //Verify "This Email already exists. Please login to the site and apply as vendor." text is visible
        Assert.assertTrue(P14_VendorRegisterPage.errorMessage.getText().equals("This Email already exists. Please login to the site and apply as vendor."));
        //ReusableMethods.screenShot("test_US_09_TC_16");
    }
}
>>>>>>> Stashed changes
