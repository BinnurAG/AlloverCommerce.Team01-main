package team01_AlloverCommerceTestNG.tests.us11;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;

public class TC_09 {
    Pages allPages = new Pages();

    @Test
    public void tc09() {

        // Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sing in butonuna tikla
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();


        //Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);


        //Dashboard altında  Store manager, orders, downloads, addresses , account details, wishlist, Support tickets, followings ve log out seçeneklerinin görüldüğünü doğrula
        List<String> linkTexts = allPages.myAccountPage().getLinkTexts();
        List<String> expectedTexts = Arrays.asList(
                "Dashboard",
                "Store Manager",
                "Orders",
                "Downloads",
                "Addresses",
                "Account details",
                "Wishlist",
                "Support Tickets",
                "Followings",
                "Logout"
        );
        Assert.assertEquals(linkTexts, expectedTexts);
        Driver.getDriver().close();

    }


}

