package team01_AlloverCommerceTestNG.tests.us03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

import java.util.List;

public class TestCase10 {

    Pages allpages = new Pages();


    @BeforeMethod
    public void beforeMethod(){
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuB.click();
    }




    @Test
    public void addressTableIsDisplayed() {


        WebElement addressTable = allpages.addressesPage().addressTable;

         List<WebElement> rows = addressTable.findElements(By.tagName("tr"));

        // Her bir satırdaki hücreleri almak ve yazdırmak
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.println(cell.getText());
            }
        }









    }

    @AfterTest
    public void closeWindow(){
        Driver.closeDriver();
    }




}