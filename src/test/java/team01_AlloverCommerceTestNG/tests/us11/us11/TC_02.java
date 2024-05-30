<<<<<<< HEAD:src/test/java/team01_AlloverCommerceTestNG/tests/us11/us11/TC_02.java
package team01_AlloverCommerceTestNG.tests.us11.us11;
=======

package team01_AlloverCommerceTestNG.tests.us11;
>>>>>>> main:src/test/java/team01_AlloverCommerceTestNG/tests/us11/TC_02.java

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class TC_02 {
    Pages allPages = new Pages();

    @Test
    public void tc02() {

        // Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sing in butonuna tikla
        Assert.assertTrue(allPages.homePage().signInButton.isEnabled());
        allPages.homePage().signInButton.click();

        // email adresi alanini bos birak
        allPages.userVendorLoginPage().emailBox.sendKeys("");

        // Kayitli bir Password  gir
        allPages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // SIGN IN butonuna tikla
        allPages.userVendorLoginPage().signInButton.click();

        // Giris isleminin gerceklesmedigi dogrula
        String validationMessage = allPages.userVendorLoginPage().emailBox.getAttribute("validationMessage");
        Assert.assertEquals(validationMessage, "Please fill out this field.");

        Driver.getDriver().close();


    }


}
