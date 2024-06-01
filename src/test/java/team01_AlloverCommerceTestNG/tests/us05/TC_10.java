package team01_AlloverCommerceTestNG.tests.us05;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_10 {

    Pages pages = new Pages();

    @Test
    public void us05Tc10() {


        //Kullanıcı Account Details (Hesap Bilgilerini değiştirirken yeni password
        // 12 karakterden az ise password kabul edilmemeli

        //Web adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        //Sign in butonunu tıklanir
        pages.homePage().signInButton.click();

        //Kullanıcı siteye üye olurken girdiği username'i kutucuğa girmeli
        pages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        //Kullanıcı siteye üye olurken girdiği passwordu kutucuğa girmeli
        pages.userVendorLoginPage().passwordBox.sendKeys("2024deployment!");

        // SIGN IN butonuna tikla
        pages.userVendorLoginPage().signInButton.click();

        //Sayfasinin en altinda bulunan My Account linkine tikla
        ReusableMethods.click(pages.homePage().myAccountButton);

        //Account details butonuna tıkla
        ReusableMethods.click(pages.myAccountPage().accountDetailsButton);

        //Kullanıcı First name Geçerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsFirstNameBox.clear();
        ReusableMethods.waitForSecond(2);
        pages.accountDetails().detailsFirstNameBox.sendKeys("Britton");

        //Kullanıcı Last name Geçerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsLastNameBox.clear();
        pages.accountDetails().detailsLastNameBox.sendKeys("Jamesson");

        //Kullanıcı "Current password leave blank to leave unchanged" şifresini girer
        ReusableMethods.waitForSecond(2);
        pages.accountDetails().detailsCurrentPasswordBox.sendKeys("2024deployment!");

        //Kullanıcı "New password leave blank to leave unchanged" ( karakterli yeni şifre girer
        pages.accountDetails().detailsNewPasswordBox.sendKeys("yvtve8V$9");

        //Kullanıcı Confirm password tekrar şifresini girer
        pages.accountDetails().detailsConfirmPasswordBox.sendKeys("yvtve8V$9");

        //Kullanıcı SAVE CHANGES tıklar.
        pages.accountDetails().detailsSaveChangesSubmitBox.submit();

        //Account details changed successfully. yazısını Görmedigini doğrula
        Assert.assertFalse(pages.accountDetails().detailsSuccessfully.isDisplayed());

        //Hint: The password should be at least twelve characters long. To make it stronger, use upper and lower case letters, numbers, and symbols like ! " ? $ % ^ & ).

    } //fail

}





