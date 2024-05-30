
package team01_AlloverCommerceTestNG.tests.us11;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US11_VendorSignIn {

    // @Listeners(team01_AlloverCommerceTestNG.utilities.Listeners.class)

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

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        // Giris isleminin kayitli email ile  gerceklestigini dogrula
        Assert.assertTrue(allPages.homePage().signOutButton.isDisplayed());

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
    }

    @Test
    public void tc02() {

        // email adresi alanini bos birak
        allPages.userVendorLoginPage().emailBox.sendKeys("");

        // Kayitli bir Password  gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        // Giris isleminin gerceklesmedigi dogrula
        String validationMessage = allPages.userVendorLoginPage().emailBox.getAttribute("validationMessage");
        Assert.assertEquals(validationMessage, "Please fill out this field.");
    }

    @Test
    public void tc03() {

        // email adresi alanina farkli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("ranaloa@floodouts.com");

        // Kayitli bir Password  gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        // Giris isleminin gerceklesmedigi dogrula
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

    }

    @Test
    public void tc04() {

        //Kayitli email adresini eksik gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamessn@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        // Giriş işlemi gerçekleşmemeli
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

    }


    @Test
    public void tc05() {

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Password  alanini bos birak
        allPages.userVendorLoginPage().passwordBox.sendKeys("");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        //Giris isleminin gerceklesmedigini dogrula
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

    }

    @Test
    public void tc06() {

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Password alanina farkli bir sifre gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("dyu76@u7");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        //Giris isleminin gerceklesmedigini dogrula
        Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

    }


    @Test
    public void tc07a() {

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Basina space koyarak kayitli olan passwordu gir
        allPages.userVendorLoginPage().passwordBox.sendKeys(" dyu76@u7");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        //Giris isleminin gerceklesmedigini dogrula
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());
    }  //fail

    @Test
    public void tc07b() {

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Sonuna space koyarak kayitli olan passwordu gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("dyu76@u7 ");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        //Giris isleminin gerceklesmedigini dogrula
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());
        // Assert.assertTrue(allPages.userVendorLoginPage().warningMessage.isDisplayed());

    }  //fail


    @Test
    public void tc08a() {

        //Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        //  SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        //Sayfasinin en altinda bulunan My Account linkine tikla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //My Account sayfasinin goruntulendigini dogrula
        Assert.assertTrue(allPages.myAccountPage().myAccountTitle.isDisplayed());

    }


    @Test
    public void tc08b() {

        //Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        //  SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        //Sayfasinin en altinda bulunan My Account linkine tikla
        ReusableMethods.click(allPages.homePage().signOutButton);

        //My Account sayfasinin goruntulendigini dogrula
        Assert.assertTrue(allPages.myAccountPage().myAccountTitle.isDisplayed());

    }


    @Test
    public void tc09() {

        //Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Burayi ekle


        //Dashboard altında  Store manager, orders, downloads, addresses , account details, wishlist, Support tickets, followings ve log out seçeneklerinin görüldüğünü doğrula

    }

    @Test
    public void tc10() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Store manager butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().storeManagerButton);

        //Store manager başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.vendorStoreManagerPage().storeManagerTitle.isDisplayed());

    }

    @Test
    public void tc11() {

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

    }

    @Test
    public void tc12() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Dowloads butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().dowloadsButton);

        //Downloads başlığının görüldüğünü doğrula
        Assert.assertTrue(allPages.myAccountPage().dowloadsButtonTitle.isDisplayed());

    }

    @Test
    public void tc13() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Addresses butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().addressesButton);

        //Addresses başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.vendorAddressesPage().addressesTitle.isDisplayed());

    }

    @Test
    public void tc14() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Account details butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().accountDetailsButton);

        //Account details başlığı görüldüğünü doğrula
        Assert.assertTrue(allPages.myAccountPage().accountDetailsButton.isDisplayed());

    }

    @Test
    public void tc15() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Wishlist butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().wishlistButton);

        //Ticket(s) başlığı görülmeli
        Assert.assertTrue(allPages.wishlistPage().wishlistTitle.isDisplayed());

    }

    @Test
    public void tc16() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Support tickets butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().supportTicketsButton);

        //Ticket(s) başlığı görülmeli
        Assert.assertTrue(allPages.myAccountPage().supportTicketsButtonTicketsText.isDisplayed());

    }

    @Test
    public void tc17() {

        // Email boxa kayıtlı email gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password girilmeli
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // Sign In butonu tıklanır olmalı
        allPages.userVendorLoginPage().signInButton.click();

        //My Account linkine tıkla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //Followings butonuna tıkla
        ReusableMethods.click(allPages.myAccountPage().followingsButton);

        //Actions başlığı görülmeli
        Assert.assertTrue(allPages.myAccountPage().followingButtonActionText.isDisplayed());


    }

    @Test
    public void tc18() {

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

    }

    @AfterMethod
    public void tearDown() {
//   Driver.getDriver().close();
    }


}
