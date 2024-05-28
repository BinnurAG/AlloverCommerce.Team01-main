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


    @FindBy(xpath = "//h1[.='Welcome to Allover Commerce!']")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//*[.='Email verification code invalid.']")
    public WebElement codeInvalidMessage;

    @FindBy(xpath = "//*[.='This Email already exists. Please login to the site and apply as vendor.']")
    public WebElement alreadyExistMessage;

    @FindBy(xpath = "//*[.='Registration Successfully Completed.']")
    public WebElement registrationSuccessMessage;
    @FindBy(xpath = "//div[.='Password and Confirm-password are not same.']")
    public WebElement PasswordAndConfirmPasswordAreNotMessage;

    @FindBy(xpath = "(//h1)[2]")
    public WebElement welcomeToAllevorCommerce;

    @FindBy(css= ".wcfm-message.wcfm-error")
    public WebElement emailWrongText;
}

