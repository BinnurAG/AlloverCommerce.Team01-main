package team01_AlloverCommerceTestNG.tests.us05;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_07 {

    Pages pages = new Pages();

    @Test
    public void us05Tc07() {

        //Kullanıcı Account Details (Hesap Detaylarını) Email address  Doldurmadan Ekleme Yapamamalı

        //Web adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        //Sign in butonunu tıklanir
        pages.homePage().signInButton.click();

        //Kullanıcı siteye üye olurken girdiği username'i kutucuğa girmeli //300352
        pages.userVendorLoginPage().emailBox.sendKeys("dimitriy.domminic@floodouts.com");

        //Kullanıcı siteye üye olurken girdiği passwordu kutucuğa girmeli
        pages.userVendorLoginPage().passwordBox.sendKeys("cffed3K&");

        // SIGN IN butonuna tikla
        pages.userVendorLoginPage().signInButton.click();

        //Sayfasinin en altinda bulunan My Account linkine tikla
        ReusableMethods.click(pages.homePage().myAccountButton);

        //Account details butonuna tıkla
        ReusableMethods.click(pages.myAccountPage().accountDetailsButton);

        //Kullanıcı First name Geçerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsFirstNameBox.clear();
        ReusableMethods.waitForSecond(2);
        pages.accountDetails().detailsFirstNameBox.sendKeys("ayse");

        //Kullanıcı Last name Geçerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsLastNameBox.clear();
        pages.accountDetails().detailsLastNameBox.sendKeys("betul");

        //Kullanıcı "Current password leave blank to leave unchanged" şifresini girer
        ReusableMethods.waitForSecond(2);
        pages.accountDetails().detailsCurrentPasswordBox.sendKeys("cffed3K&");

        //Kullanıcı "New password leave blank to leave unchanged" yeni şifre girer
        pages.accountDetails().detailsNewPasswordBox.sendKeys("yvtve8V$");

        //Kullanıcı Confirm password tekrar şifresini girer
        pages.accountDetails().detailsConfirmPasswordBox.sendKeys("yvtve8V$");

        //Kullanıcı SAVE CHANGES tıklar.
        pages.accountDetails().detailsSaveChangesSubmitBox.submit();

        //Account details changed successfully. Yazısını Gördüğünü doğrula
        Assert.assertTrue(pages.accountDetails().detailsSuccessfully.isDisplayed());

        //Kullanıcı siteye üye olurken girdiği username'i kutucuğa girmeli
        pages.userVendorLoginPage().emailBox.sendKeys("dimitriy.domminic@floodouts.com");

        //Kullanıcı siteye üye olurken girdiği passwordu kutucuğa girmeli
        pages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // SIGN IN butonuna tikla
        pages.userVendorLoginPage().signInButton.click();

        //Giris isleminin gerceklestigini dogrula (Sign Out gorulmeli)
        Assert.assertTrue(pages.homePage().signOutButton.isDisplayed());

        // ReusableMethods.logOutClick();


    }

}