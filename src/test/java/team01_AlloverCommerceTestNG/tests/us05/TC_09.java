package team01_AlloverCommerceTestNG.tests.us05;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_09 {

    Pages pages = new Pages();

    @Test
    public void us05Tc06() {

        //Kullanıcı Account Details (Hesap Detaylarını) Biography'i Doldurmadan  ve Yeni Şifre Girişi Yapmadan Değişiklik Yapabilmeli
        //Web adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        //Sign in butonunu tıklanir
        pages.homePage().signInButton.click();

        //Kullanıcı siteye üye olurken girdiği username'i kutucuğa girmeli
        pages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        //Kullanıcı siteye üye olurken girdiği passwordu kutucuğa girmeli
        pages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // SIGN IN butonuna tikla
        pages.userVendorLoginPage().signInButton.click();

        //Sayfasinin en altinda bulunan My Account linkine tikla
        ReusableMethods.click(pages.homePage().myAccountButton);

        //Account details butonuna tıkla
        ReusableMethods.click(pages.myAccountPage().accountDetailsButton);

        //Kullanıcı First name Geçerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsFirstNameBox.clear();
        pages.accountDetails().detailsFirstNameBox.sendKeys("Betty");
        ReusableMethods.waitForSecond(2);

        //Kullanıcı Last name Gecerli bir Veri Girisi yapar
        pages.accountDetails().detailsLastNameBox.clear();
        pages.accountDetails().detailsLastNameBox.sendKeys("Brown");

        //Kullanıcı Display name Gecerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsDisplayNameBox.clear();
        pages.accountDetails().detailsDisplayNameBox.sendKeys("BB");

        //Kullanıcı Biography Veri Girişi yapmaz
        Driver.getDriver().switchTo().frame(0);
        pages.accountDetails().detailsTextArea.clear();
        Driver.getDriver().switchTo().parentFrame();
        ReusableMethods.waitForSecond(2);

        //Kullanıcı SAVE CHANGES tıklar.
        pages.accountDetails().detailsSaveChangesSubmitBox.submit();

        //Account details changed successfully. Yazısını Gördüğünü doğrula
        Assert.assertTrue(pages.accountDetails().detailsSuccessfully.isDisplayed());
        Driver.closeDriver();
    }

}