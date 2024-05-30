package team01_AlloverCommerceTestNG.tests.us11;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;
public class US11_Merve {

    Pages allPages = new Pages();

    @BeforeMethod
    public void setUp() {
        // Siteye ulaşılmalı
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı");

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmalı
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();
        ExtentReportUtils.extentTestInfo("SIGN IN tıklanır olmalı ve SIGN IN penceresi açıldı");

    }

    @Test(description = "US11")
    public void tc01() {

        // Kayıtlı bir email adresi girilmeli
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        // Sign Out görülmeli
        Assert.assertTrue(allPages.homePage().signOutButton.isDisplayed());
        ReusableMethods.logOut();


        ExtentReportUtils.extentTestPass("Sign Out görüldü");


    }

    @Test(description = "US11")
    public void tc02() {

        // Email box boş bırakılmalı
        allPages.userVendorLoginPage().emailBox.sendKeys("");
        ExtentReportUtils.extentTestInfo("Email box boş bırakıldı");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        // Giriş işlemi gerçekleşmemeli
        String validationMessage = allPages.userVendorLoginPage().emailBox.getAttribute("validationMessage");
        Assert.assertEquals(validationMessage, "Lütfen bu alanı doldurun.");

        ExtentReportUtils.extentTestPass("Giriş işlemi gerçekleşmedi");


    }

    @Test(description = "US11")
    public void tc03() {

        // Email boxa geçersiz bir email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("merve@floodouts.com");
        ExtentReportUtils.extentTestInfo("Email boxa geçersiz bir email girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        // Giriş işlemi gerçekleşmemeli
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

        ExtentReportUtils.extentTestPass("Giriş işlemi gerçekleşmedi");

    }

    @Test(description = "US11")
    public void tc04() {

        // Email boxa geçersiz bir email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("merve@floodouts.com");
        ExtentReportUtils.extentTestInfo("Email boxa geçersiz bir email girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        // Giriş işlemi gerçekleşmemeli
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

        ExtentReportUtils.extentTestPass("Giriş işlemi gerçekleşmedi");

    }

    @Test(description = "US11")
    public void tc05() {

        // Email boxa kayıtlı bir email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Password boxa geçersiz password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("merve");
        ExtentReportUtils.extentTestInfo("Password boxa geçersiz password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        // Giriş işlemi gerçekleşmemeli
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

        ExtentReportUtils.extentTestPass("Giriş işlemi gerçekleşmedi");

    }

    @Test(description = "US11")
    public void tc06() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");
//Burada
        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

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
        ReusableMethods.logOut();
        ExtentReportUtils.extentTestPass("Seçeneklerinin görüldüğü doğrulandı");

    }

    @Test(description = "US11")
    public void tc07() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

        //Store manager butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().storeManagerButton);
        ExtentReportUtils.extentTestInfo("Store manager butonuna tıklandı");

        //Store manager başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.vendorStoreManagerPage().storeManagerTitle.isDisplayed());
        ExtentReportUtils.extentTestPass("Store manager başlığı görüldüğünü doğrulandı");
        ReusableMethods.logOut();


    }

    @Test(description = "US11")
    public void tc08() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

        //Orders butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().ordersButton);
        ExtentReportUtils.extentTestInfo("Orders butonuna tıklandı");

        //Orders başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.myAccountPage().ordersButtonTitle.isDisplayed());
        ExtentReportUtils.extentTestPass("Orders başlığı görüldüğünü doğrulandı");
        ReusableMethods.logOut();

    }

    @Test(description = "US11")
    public void tc09() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

        //Dowloads butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().dowloadsButton);
        ExtentReportUtils.extentTestInfo("Dowloads butonuna tıklandı");

        //Downloads başlığının görüldüğünü doğrula
        Assert.assertTrue(allPages.myAccountPage().dowloadsButtonTitle.isDisplayed());
        ExtentReportUtils.extentTestPass("Downloads başlığı görüldüğünü doğrulandı");
        ReusableMethods.logOut();

    }

    @Test(description = "US11")
    public void tc10() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");


// Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

    //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

    //Addresses butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().addressesButton);
        ExtentReportUtils.extentTestInfo("Addresses butonuna tıklandı");

    //Addresses başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.vendorAddressesPage().addressesTitle.isDisplayed());
        ExtentReportUtils.extentTestPass("Addresses başlığı görüldüğünü doğrulandı");
        ReusableMethods.logOut();
}

    @Test(description = "US11")
    public void tc11() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

        //Account details butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().accountDetailsButton);
        ExtentReportUtils.extentTestInfo("Account butonuna tıklandı");

        //Account details başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.myAccountPage().accountDetailsButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Account başlığı görüldüğünü doğrulandı");
        ReusableMethods.logOut();

    }

    @Test(description = "US11")
    public void tc12() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

        //Wishlist butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().wishlistButton);
        ExtentReportUtils.extentTestInfo("Wishlist butonuna tıklandı");

        //Ticket(s) başlığı görülmeli
        Assert.assertTrue(allPages.wishlistPage().wishlistTitle.isDisplayed());
        ExtentReportUtils.extentTestPass("Ticket(s) başlığı görüldüğünü doğrulandı");
        ReusableMethods.logOut();

    }

    @Test(description = "US11")
    public void tc13() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

        //Support tickets butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().supportTicketsButton);
        ExtentReportUtils.extentTestInfo("Support tickets butonuna tıklandı");

        //Ticket(s) başlığı görülmeli
        Assert.assertTrue(allPages.myAccountPage().supportTicketsButtonTicketsText.isDisplayed());
        ExtentReportUtils.extentTestPass("Ticket(s) başlığı görüldüğünü doğrulandı");
        ReusableMethods.logOut();

    }

    @Test(description = "US11")
    public void tc14() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

        //Followings butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().followingsButton);
        ExtentReportUtils.extentTestInfo("Followings butonuna tıklandı");

        //Actions başlığı görülmeli
        Assert.assertTrue(allPages.myAccountPage().followingButtonActionText.isDisplayed());
        ExtentReportUtils.extentTestPass("Actions başlığı görüldüğünü doğrulandı");
        ReusableMethods.logOut();


    }

    @Test(description = "US11")
    public void tc15() {

        // Kayıtlı bir email adresi girilmeli
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

        //Dashboard altında Log out  menüsüne girildiğini doğrula
        ReusableMethods.click(allPages.myAccountPage().logoutButton);
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Log out başlığı görüldüğünü doğrulandı");

    }

    @Test(description = "US11")
    public void tc16() {

        // Kayıtlı bir email adresi girilmeli
        allPages.userVendorLoginPage().emailBox.sendKeys("ziyang.adithya@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Password boxa basina yeya sonuna space koyarak kayitli olan passwordu gir
        allPages.userVendorLoginPage().passwordBox.sendKeys(" aaaaaaaaaa11");
        ExtentReportUtils.extentTestInfo("Password boxa basina yeya sonuna space koyarak kayitli olan passwordu girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //Giriş yapılmadığını doğrula
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());
        ExtentReportUtils.extentTestFail("Giriş yapıldı");

    }


}

