package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P1_HomePage {

    public P1_HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[.='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[.='Sign Out']")
    public WebElement signOutButton;

    @FindBy(partialLinkText = "My Account")
    public WebElement myAccountButton;

    @FindBy(xpath = "//span[.='Register']")
    public WebElement registerButton;
}

