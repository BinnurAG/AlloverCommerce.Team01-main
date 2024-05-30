package team01_AlloverCommerceTestNG.tests.us09;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P14_VendorRegisterPage;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

import static org.testng.Assert.assertTrue;

public class US_09_TC_01 {
    P14_VendorRegisterPage p14_VendorRegisterPage = new P14_VendorRegisterPage();
    P1_HomePage p1_HomePage = new P1_HomePage();
        Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test0Tc_01() {
        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        //Kullanıcı Register butonuna tıklar
        p1_HomePage.signInButton.click();
        p1_HomePage.singUpButton.click();
        //Kullanıcı Sign Up ekranından Become a Vendor linkine tıklar
        p1_HomePage.becomeAVendorButton.click();
        //Vendor Registration sayfasının erişildiğini dogrular
        p1_HomePage.VendorRegistrationText.isDisplayed();


         Driver.getDriver().quit();

    }
}