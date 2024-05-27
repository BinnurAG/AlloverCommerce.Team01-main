package team01_AlloverCommerceTestNG.tests.us11;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_02 {
    Pages allPages = new Pages();

    @Test
    public void tc02() {

        // Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sing in butonuna tikla
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();

        // email adresi alanini bos birak
        allPages.userVendorLoginPage().emailBox.sendKeys("");

        // Kayitli bir Password  gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        //Giris isleminin gerceklesmedigi dogrulanir

        // Assert.assertTrue(allPages.homePage().signOutButton.isDisplayed());


    }
}
