package team01_AlloverCommerceTestNG.tests.us11.us11;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_07 {

    Pages allPages = new Pages();
    private SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        // Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        // Sing in butonuna tikla
       // Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();
    }

   @Test
    public void tc07a() {

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Basina space koyarak kayitli olan passwordu gir
        allPages.userVendorLoginPage().passwordBox.sendKeys(" yvtve8V$");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

       //Giris isleminin gerceklesmedigini dogrula (Sign Out butonu gozukmemeli)
       softAssert.assertFalse(allPages.homePage().signOutButton.isDisplayed(),"Giris islemi gerceklesmemeli");
       ExtentReportUtils.extentTestPass("Password hatali girildigi halde giriş işlemi gerçeklesti");
       ReusableMethods.logOutClick();
       softAssert.assertAll();
    }  //fail


    @Test
    public void tc07b() {

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Sonuna space koyarak kayitli olan passwordu gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$ ");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        //Giris isleminin gerceklesmedigini dogrula (Sign Out butonu gozukmemeli)
        softAssert.assertFalse(allPages.homePage().signOutButton.isDisplayed(),"Giris islemi gerceklesmemeli");
        softAssert.assertAll(); // Tüm doğrulamaları tamamla
        Driver.getDriver().close();

    }  //fail

   // @AfterMethod
    public void tearDown() {
        // Soft Assertion'ların değerlendirilmesi
      // softAssert.assertAll();

    }

}
