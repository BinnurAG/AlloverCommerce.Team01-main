package team01_AlloverCommerceTestNG.tests.us11.us11;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;

public class US11_VendorSignIn {

    Pages allPages = new Pages();
    private SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        // Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı");

        // Sing in butonuna tikla
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();
        ExtentReportUtils.extentTestInfo("SIGN IN tıklanır olmalı ve SIGN IN penceresi açıldı");
    }

    @Test (description = "US11-TC01a")
    public void tc01a() {

        // Username or email address alanına gecerli (kayitli) bir email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Password alanına gecerli (kayitli) bir password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        // Giris isleminin kayitli email ile  gerceklestigini dogrula ( Sign Out görülmeli)
        Assert.assertTrue(allPages.homePage().signOutButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Sign Out görüldü");
        ReusableMethods.logOutClick();
    }

    @Test(description = "US11-TC01b")
    public void tc01b() {

        // Username or email address alanına gecerli (kayitli) bir username gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir username girildi");

        // Password alanına gecerli (kayitli) bir password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        // Giris isleminin kayitli email ile  gerceklestigini dogrula
        Assert.assertTrue(allPages.homePage().signOutButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Sign Out görüldü");
        ReusableMethods.logOutClick();
    }

    @Test(description = "US11-TC02")
    public void tc02() {

        // email adresi alanini bos birak
        allPages.userVendorLoginPage().emailBox.sendKeys("");
        ExtentReportUtils.extentTestInfo("Email box boş bırakıldı");

        // Kayitli bir Password  gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        // Giris isleminin gerceklesmedigi dogrula
        String validationMessage = allPages.userVendorLoginPage().emailBox.getAttribute("validationMessage");
        Assert.assertEquals(validationMessage, "Please fill out this field.");
        ExtentReportUtils.extentTestPass("Giriş işlemi gerçekleşmedi");
    }

    @Test(description = "US11-TC03")
    public void tc03() {

        // email adresi alanina farkli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ranaloa@floodouts.com");
        ExtentReportUtils.extentTestInfo("Email boxa geçersiz bir email girildi");

        // Kayitli bir Password  gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        // Giris isleminin gerceklesmedigi dogrula
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());
        ExtentReportUtils.extentTestPass("Giriş işlemi gerçekleşmedi");
    }

    @Test(description = "US11-TC04")
    public void tc04() {

        //Kayitli email adresini eksik gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamessn@floodouts.com");
        ExtentReportUtils.extentTestInfo("Email boxa ayni mail eksik bir sekilde girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        // Giriş işlemi gerçekleşmemeli
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());
        ExtentReportUtils.extentTestPass("Giriş işlemi gerçekleşmedi");
    }

    @Test(description = "US11-TC05")
    public void tc05() {

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Password  alanini bos birak
        allPages.userVendorLoginPage().passwordBox.sendKeys("");
        ExtentReportUtils.extentTestInfo("Password alani bos birakildi");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //Giris isleminin gerceklesmedigini dogrula
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Giriş işlemi gerçekleşmedi");
    }

    @Test(description = "US11-TC06")
    public void tc06() {

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Password alanina farkli bir sifre gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("dyu76@u7");
        ExtentReportUtils.extentTestInfo("Password alanina farkli bir sifre gir");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //Giris isleminin gerceklesmedigini dogrula
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Giriş işlemi gerçekleşmedi");
    }

    /*
    @Test(description = "US11-TC07a")
    public void tc07a() {

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Basina space koyarak kayitli olan passwordu gir
        allPages.userVendorLoginPage().passwordBox.sendKeys(" yvtve8V$");
        ExtentReportUtils.extentTestInfo("Basina space koyarak kayitli password girildi");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //Giris isleminin gerceklesmedigini dogrula
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Password hatali girildigi halde giriş işlemi gerçeklesdi");
    }  //fail

    @Test(description = "US11-TC07b")
    public void tc07b() {

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Sonuna space koyarak kayitli olan passwordu gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$ ");
        ExtentReportUtils.extentTestInfo("Sonuna space koyarak kayitli password girildi");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //Giris isleminin gerceklesmedigini dogrula
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Password hatali girildigi halde giriş işlemi gerçeklesdi");
    }  //fail

     */


    @Test(description = "US11-TC08a")
    public void tc08a() {

        //Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        //  SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //Sayfasinin en altinda bulunan My Account linkine tikla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("Sayfanin en altindaki My account linkine tiklandi");

        //My Account sayfasinin goruntulendigini dogrula
       Assert.assertTrue(allPages.myAccountPage().myAccountTitle.isDisplayed());
        ExtentReportUtils.extentTestPass("My Account sayfasi goruntulendi");
        ReusableMethods.logOutClick();
    }


    @Test(description = "US11-TC08b")
    public void tc08b() {

        //Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        //  SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //Sayfasinin sag ust kosesindeki Sign Out linkine tiklandi
        ReusableMethods.click(allPages.homePage().signOutButton);
        ExtentReportUtils.extentTestInfo("Sayfasinin sag ust kosesindeki Sign Out linkine tiklandi");
        //My Account sayfasinin goruntulendigini dogrula
        Assert.assertTrue(allPages.myAccountPage().myAccountTitle.isDisplayed());
        ExtentReportUtils.extentTestPass("My Account sayfasi goruntulendi");
        ReusableMethods.logOutClick();
    }


    @Test(description = "US11-TC09")
    public void tc09() {

        //Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

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
        ExtentReportUtils.extentTestPass("Seçeneklerinin görüldüğü doğrulandı");
        ReusableMethods.logOutClick();
    }

    @Test(description = "US11-TC10")
    public void tc10() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

        //Store manager butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().storeManagerButton);

        //Store manager başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.vendorStoreManagerPage().storeManagerTitle.isDisplayed());
        ExtentReportUtils.extentTestPass("Store manager başlığı görüldüğünü doğrulandı");
        ReusableMethods.logOutClick();
    }

    @Test(description = "US11-TC11")
    public void tc11() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
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
        ReusableMethods.logOutClick();
    }

    @Test(description = "US11-TC12")
    public void tc12() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
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
        ReusableMethods.logOutClick();
    }

    @Test(description = "US11-TC13")
    public void tc13() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
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
        ReusableMethods.logOutClick();
    }

    @Test(description = "US11-TC14")
    public void tc14() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

        //Account details butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().accountDetailsButton);
        ExtentReportUtils.extentTestInfo("Account details butonuna tıklandı");

        //Account details başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.myAccountPage().accountDetailsButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Account details basligi görüldüğünü doğrulandı");
        ReusableMethods.logOutClick();
    }

    @Test(description = "US11-TC15")
    public void tc15() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
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
        ReusableMethods.logOutClick();
    }

    @Test(description = "US11-TC16")
    public void tc16() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
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
        ReusableMethods.logOutClick();
    }

    @Test(description = "US11-TC17")
    public void tc17() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
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
        ReusableMethods.logOutClick();
    }

    @Test(description = "US11-TC18")
    public void tc18() {

        // Kayıtlı bir email adresi girilmeli
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");
        ExtentReportUtils.extentTestInfo("Kayıtlı password girildi");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);
        ExtentReportUtils.extentTestInfo("My Account linkine tıklandı");

        //Dashboard altında Log out menüsüne girildiğini doğrula
        ReusableMethods.click(allPages.myAccountPage().logoutButton);
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Log out başlığı görüldüğünü doğrulandı");
        ReusableMethods.logOutClick();
       // Driver.getDriver().close();
    }

    @Test(description = "US11-TC07a")
    public void tc07a() {

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Basina space koyarak kayitli olan passwordu gir
        allPages.userVendorLoginPage().passwordBox.sendKeys(" yvtve8V$");
        ExtentReportUtils.extentTestInfo("Basina space koyarak kayitli password girildi");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //Giris isleminin gerceklesmedigini dogrula (Sign Out butonu gozukmemeli)
        softAssert.assertFalse(allPages.homePage().signOutButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Password hatali girildigi halde giriş işlemi gerçeklesti");
        ReusableMethods.logOutClick();
        softAssert.assertAll();
    }  //fail

    @Test(description = "US11-TC07b")
    public void tc07b() {

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");
        ExtentReportUtils.extentTestInfo("Kayıtlı bir email adresi girildi");

        // Sonuna space koyarak kayitli olan passwordu gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$ ");
        ExtentReportUtils.extentTestInfo("Sonuna space koyarak kayitli password girildi");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //Giris isleminin gerceklesmedigini dogrula (Sign Out butonu gozukmemeli)
        softAssert.assertFalse(allPages.homePage().signOutButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Password hatali girildigi halde giriş işlemi gerçeklesti");
        ReusableMethods.logOutClick();
        softAssert.assertAll();
    }  //fail


    /*
    public static void logOutClick(){
        allPages.homePage().signOutButton.click();
        allPages.myAccountPage().logoutButton.click();
    }
*/


}
