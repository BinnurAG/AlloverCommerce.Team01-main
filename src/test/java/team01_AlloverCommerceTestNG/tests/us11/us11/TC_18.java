package team01_AlloverCommerceTestNG.tests.us11.us11;


import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_18 {
    Pages allPages = new Pages();

    @Test
    public void tc18() {

        // Siteye ulaşılmalı
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmalı
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();

        // Kayıtlı bir email adresi girilmeli
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Dashboard altında Log out  menüsüne girildiğini doğrula
        ReusableMethods.click(allPages.myAccountPage().logoutButton);
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());
        Driver.getDriver().close();

    }

}

