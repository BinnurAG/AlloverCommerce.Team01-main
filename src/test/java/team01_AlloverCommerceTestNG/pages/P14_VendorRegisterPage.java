package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P14_VendorRegisterPage {
    public P14_VendorRegisterPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user_email")
    public WebElement emailBox;
    @FindBy(css = "input[placeholder='Verification Code']")
    public WebElement verificationCodeBox;
    @FindBy(id = "passoword")
    public WebElement passwordBox;
    @FindBy(id = "confirm_pwd")
    public WebElement confirmPasswordBox;
    @FindBy(id = "wcfm_membership_register_button")
    public WebElement registerButton;

    @FindBy(id = "password_strength")
    public WebElement passwordWrongMessage;
}