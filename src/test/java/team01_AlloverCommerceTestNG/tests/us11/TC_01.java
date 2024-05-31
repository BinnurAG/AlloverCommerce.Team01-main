package team01_AlloverCommerceTestNG.tests.us11;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_01 {

    Pages allPages = new Pages();

    @BeforeMethod
    public void setUp() {
        // Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        // Sing in butonuna tikla
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();
    }


    @Test
    public void tc01a() {

        // Username or email address alanına gecerli (kayitli) bir email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Password alanına gecerli (kayitli) bir password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // SIGN IN butonu tıkla
        allPages.userVendorLoginPage().signInButton.click();

        //Giris isleminin gerceklestigini dogrula (Sign Out gorulmeli)
        Assert.assertTrue(allPages.homePage().signOutButton.isDisplayed());

        ReusableMethods.logOutClick();

    }


    @Test
    public void tc01b() {

        // Username or email address alanına gecerli (kayitli) bir username gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson");

        // Password alanına gecerli (kayitli) bir password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        // Giris isleminin kayitli email ile  gerceklestigini dogrula
        Assert.assertTrue(allPages.homePage().signOutButton.isDisplayed());
        Driver.getDriver().close();

    }

}
