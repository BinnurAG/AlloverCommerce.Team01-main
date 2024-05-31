package team01_AlloverCommerceTestNG.tests.us11.us11;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_11 {
    Pages allPages = new Pages();

    @Test
    public void tc11() {

        // Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sing in butonuna tikla
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Orders butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().ordersButton);

        //Addresses başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.myAccountPage().ordersButtonTitle.isDisplayed());
        Driver.getDriver().close();
    }


}

