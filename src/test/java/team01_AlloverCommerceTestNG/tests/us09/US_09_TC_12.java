package team01_AlloverCommerceTestNG.tests.us09;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P14_VendorRegisterPage;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US_09_TC_12 {
<<<<<<< Updated upstream
}
=======
    P14_VendorRegisterPage p14_VendorRegisterPage = new P14_VendorRegisterPage();
    P1_HomePage p1_HomePage = new P1_HomePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test_US_09_TC_12()  {

        // STEP: User should enter password again.

        //User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));


        //Click on "Sign In" button
        p1_HomePage.signInButton.click();

        //Click on "Sign up"
        p1_HomePage.singUpButton.click();

        //Click on "Become a Vendor" to navigate Vendor Registration Page
        p1_HomePage.becomeAVendorButton.click();

        //Kullanıcı fake url'den almış olduğu valid Email adresini girer
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("fakeEmailUrl"));
        String fakeEmail = p14_VendorRegisterPage.fakeEmail.getText();
        // geri dönün ve email adress kısmını bu email ile doldurun
        ReusableMethods.switchToWindow(0);
        P14_VendorRegisterPage.emailBox.sendKeys(fakeEmail);
        P14_VendorRegisterPage.reSendCodeButton.click();
ReusableMethods.waitForSecond(3);
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("fakeEmailUrl"));
        String verificationCodeTextfakemail = p14_VendorRegisterPage.verificationCodeTextfakemail.getText();
        ReusableMethods.switchToWindow(0);
        P14_VendorRegisterPage. verificationCodeBox.sendKeys(verificationCodeTextfakemail);
ReusableMethods.waitForSecond(1);
        //Enter valid password in "Password" text box
        p14_VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("good_password"));
        //Enter different password  in "Confirm Password" text box
        p14_VendorRegisterPage.confirmPassword.sendKeys(ConfigReader.getProperty("weak_password"));
        ReusableMethods.waitForSecond(3);
        p14_VendorRegisterPage.registerButton.click();

        //Doğrulayın "Password and Confirm-password are not same." metni görünür
        Assert.assertTrue(p14_VendorRegisterPage.errorMessage.isDisplayed());

        //ReusableMethods.screenShot("test_US_09_TC_12");

        //Driver.getDriver().close();
    }

}
>>>>>>> Stashed changes
