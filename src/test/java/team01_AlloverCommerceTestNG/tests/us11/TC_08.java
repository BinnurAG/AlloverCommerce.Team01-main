package team01_AlloverCommerceTestNG.tests.us11;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_08 {
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
    public void tc08a() {

        //Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$9");

        //  SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        //Sayfasinin en altinda bulunan My Account linkine tikla
        ReusableMethods.click(allPages.homePage().myAccountButton);

        //My Account sayfasinin goruntulendigini dogrula
        Assert.assertTrue(allPages.myAccountPage().myAccountTitle.isDisplayed());
           ReusableMethods.logOutClick();
    }


    @Test
    public void tc08b() {

        //Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Kayıtlı password gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        //  SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        //Sayfasinin sag ust kosesinde bulunan Sign Out butonuna tikla
        ReusableMethods.click(allPages.homePage().signOutButton);

        //My Account sayfasinin goruntulendigini dogrula
        Assert.assertTrue(allPages.myAccountPage().myAccountTitle.isDisplayed());
        Driver.getDriver().close();
    }

}
