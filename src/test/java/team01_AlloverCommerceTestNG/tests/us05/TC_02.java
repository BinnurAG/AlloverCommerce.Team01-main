package team01_AlloverCommerceTestNG.tests.us05;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_02 {

    Pages pages = new Pages();

    @Test
    public void us05Tc02() {

        //Kullanıcı Account Details (Hesap Detaylarını) değiştirebilmeli

        //Web adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        //Sign in butonunu tıklanir
        pages.homePage().signInButton.click();

        //Kullanıcı siteye üye olurken girdiği username'i kutucuğa girmeli
        pages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

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
        ReusableMethods.waitForSecond(2);
        pages.accountDetails().detailsFirstNameBox.sendKeys("ayse");

        //Kullanıcı Last name Geçerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsLastNameBox.clear();
        pages.accountDetails().detailsLastNameBox.sendKeys("betul");

        //Kullanıcı Display name Gecerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsDisplayNameBox.clear();
        pages.accountDetails().detailsDisplayNameBox.sendKeys("aisha");

        //Kullanıcı Email address Geçerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsEmailBox.clear();
        pages.accountDetails().detailsEmailBox.sendKeys("bettybrown@gmail.com");

        //Kullanıcı Biography Veri Girişi Yapar
        Driver.getDriver().switchTo().frame(0);
        pages.accountDetails().detailsTextArea.clear();
        pages.accountDetails().detailsTextArea.sendKeys("Hello World");
        Driver.getDriver().switchTo().parentFrame();

        //Kullanıcı SAVE CHANGES tıklar.
        pages.accountDetails().detailsSaveChangesSubmitBox.submit();

        //Account details changed successfully. Yazısını Gördüğünü doğrula
        Assert.assertTrue(pages.accountDetails().detailsSuccessfully.isDisplayed());
        Driver.closeDriver();
    }
}





