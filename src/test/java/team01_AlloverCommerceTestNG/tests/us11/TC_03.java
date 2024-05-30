
package team01_AlloverCommerceTestNG.tests.us11;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_03 {

    Pages allPages = new Pages();
    @Test
    public void tc03() {

        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmali
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();

        //  farkli bir email addressi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ranaloa.coy@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        // "Wrong username or password."mesajini  görulmeli
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

    }
}
