package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P3_UserVendorLoginPage {
    public P3_UserVendorLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "username")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(css = "button[name='login']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[.='Wrong username or password.']")
    public WebElement warningMessage;

}
