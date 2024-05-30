<<<<<<< HEAD:src/test/java/team01_AlloverCommerceTestNG/tests/us11/us11/TC_05.java
package team01_AlloverCommerceTestNG.tests.us11.us11;

=======

package team01_AlloverCommerceTestNG.tests.us11;
>>>>>>> main:src/test/java/team01_AlloverCommerceTestNG/tests/us11/TC_06.java
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_05 {

    Pages allPages = new Pages();

    @Test
    public void tc05() {
        // Siteye ulaşılmalı
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        // SIGN IN tıklanır olmalı ve SIGN IN penceresi açılmalı
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();

        // Kayitli bir email adresi gir
        allPages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        // Password  alanini bos birak
        allPages.userVendorLoginPage().passwordBox.sendKeys("");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        //Giris isleminin gerceklesmedigini dogrula
        Assert.assertTrue(allPages.homePage().signInButton.isDisplayed());
        Driver.getDriver().close();

    }

}

