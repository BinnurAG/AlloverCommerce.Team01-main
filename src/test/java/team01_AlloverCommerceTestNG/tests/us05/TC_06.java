package team01_AlloverCommerceTestNG.tests.us05;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_06 {

    Pages pages = new Pages();

    @Test
    public void us05Tc06() {

        //Kullanıcı Account Details (Hesap Detaylarını) Email address  Doldurmadan Ekleme Yapamamalı

        //Web adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        //Sign in butonunu tıklanir
        pages.homePage().signInButton.click();

        //Kullanıcı siteye üye olurken girdiği username'i kutucuğa girmeli
        pages.userVendorLoginPage().emailBox.sendKeys("bettybrown@gmail.com");

        //Kullanıcı siteye üye olurken girdiği passwordu kutucuğa girmeli
        pages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$9");

        // SIGN IN butonuna tikla
        pages.userVendorLoginPage().signInButton.click();

        //Sayfasinin en altinda bulunan My Account linkine tikla
        ReusableMethods.click(pages.homePage().myAccountButton);

        //Account details butonuna tıkla
        ReusableMethods.click(pages.myAccountPage().accountDetailsButton);

        //Kullanıcı First name Geçerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsFirstNameBox.clear();
        pages.accountDetails().detailsFirstNameBox.sendKeys("Ayse");
        ReusableMethods.waitForSecond(2);

        //Kullanıcı Last name icin gecerli bir veri girer
        pages.accountDetails().detailsLastNameBox.clear();
        pages.accountDetails().detailsLastNameBox.sendKeys("Tekmen");

        //Kullanıcı Email address boş bırak.
        pages.accountDetails().detailsEmailBox.clear();

        //Kullanıcı SAVE CHANGES tıklar.
        pages.accountDetails().detailsSaveChangesSubmitBox.submit();

        //EMAIL ADDRESS is a required field.
        Assert.assertTrue(pages.accountDetails().zorunluAlanYazisiEmail.isDisplayed());
        Driver.closeDriver();
    }


}
