
package team01_AlloverCommerceTestNG.tests.us11;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_05 {
    Pages allPages = new Pages();

    @Test
    public void tc05() {

        // Siteye ulaşılmalı
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmalı
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();

        // Email boxa kayıtlı bir email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Password boxa geçersiz password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("dyu76@u7");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        // Giriş işlemi gerçekleşmemeli
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

    }
}
