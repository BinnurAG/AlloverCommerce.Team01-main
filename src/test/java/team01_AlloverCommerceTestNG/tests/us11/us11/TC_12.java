<<<<<<< HEAD:src/test/java/team01_AlloverCommerceTestNG/tests/us11/us11/TC_12.java
package team01_AlloverCommerceTestNG.tests.us11.us11;

=======

package team01_AlloverCommerceTestNG.tests.us11;
>>>>>>> main:src/test/java/team01_AlloverCommerceTestNG/tests/us11/TC_09.java
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_12 {
    Pages allPages = new Pages();

    @Test
    public void tc12() {

        // Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sing in butonuna tikla
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();


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
        ReusableMethods.logOutClick();

    }

}

