package team01_AlloverCommerceTestNG.tests.us11;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_01 {

    Pages allPages = new Pages();

    @Test
    public void tc01() {
        // Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sing  in butonuna tikla
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();

        // Username or email address alanına gecerli (kayitli) bir email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Password alanına gecerli (kayitli) bir password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // SIGN IN butonu tıkla
        allPages.userVendorLoginPage().signInButton.click();

        //Giris isleminin gerceklestigini dogrula (Sign Out gorulmeli)
        Assert.assertTrue(allPages.homePage().signOutButton.isDisplayed());

    }

}