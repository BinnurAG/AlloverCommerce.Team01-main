package team01_AlloverCommerceTestNG.tests.us11.us11;


import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_06 {
    Pages allPages = new Pages();

    @Test
    public void tc06() {

        // Siteye ulaşılmalı
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmalı
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Password alanina farkli bir sifre gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("dyu76@u7");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        //Giris isleminin gerceklesmedigini dogrula
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());
        Driver.getDriver().close();

    }

}
