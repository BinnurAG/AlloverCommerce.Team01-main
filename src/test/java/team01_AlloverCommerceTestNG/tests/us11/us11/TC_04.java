package team01_AlloverCommerceTestNG.tests.us11.us11;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_04 {
    Pages allPages = new Pages();

    @Test
    public void tc04() {

        // Siteye ulaşılmalı
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmalı
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();

        //Kayitli email adresini eksik gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamessn@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        // Giriş işlemi gerçekleşmemeli
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());
        Driver.getDriver().close();

    }

}
