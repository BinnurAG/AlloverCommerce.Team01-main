package team01_AlloverCommerceTestNG.tests.us06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P6_AccountDetails;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.pages.P6_AccountDetails.*;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;

@Listeners(team01_AlloverCommerceTestNG.utilities.Listeners.class)
public class TC02 extends ReusableMethods {

    P6_AccountDetails p6_accountDetails = new P6_AccountDetails();

    @BeforeClass
    public void beforeClass() {
        loginToSite();
    }

    @Test
    public void test_EmptySearch() {
        click(searchIcon);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("alert('Lütfen bu alanı doldurun.')");
        Alert alert = getDriver().switchTo().alert();
        alertWait(2);
        String alertText = alert.getText();
        assertTrue(alertText.contains("Lütfen bu alanı doldurun."));
        waitForSecond(2);
        alertAccept();
    }

    @AfterClass
    public void afterClass() {
        getDriver().quit();
    }
}