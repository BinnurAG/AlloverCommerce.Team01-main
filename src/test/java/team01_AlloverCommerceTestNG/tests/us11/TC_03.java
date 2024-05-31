package team01_AlloverCommerceTestNG.tests.us11;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_03 {

    Pages allPages = new Pages();

    @Test
    public void tc03() {

        //Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmali
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();

        // email adresi alanina farkli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ranaloa@floodouts.com");

        // Kayitli bir Password  gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        // Giris isleminin gerceklesmedigi dogrula
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());
        Driver.getDriver().close();

    }


}
