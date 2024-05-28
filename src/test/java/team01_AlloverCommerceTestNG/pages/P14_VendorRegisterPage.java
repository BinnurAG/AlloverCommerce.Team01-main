package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P14_VendorRegisterPage {
    public P14_VendorRegisterPage() {

        PageFactory.initElements(Driver.getDriver(), this); }

    //----------Vendor Registration with Sign Up------------------------------------------------------------------
    @FindBy(id = "user_email")
    public static WebElement registrationEmail;

    @FindBy(xpath = "//*[.='Email: This field is required.']")
    public WebElement emailIsRequiredText;

    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-success']")
    public static WebElement verificationCodeText;

    @FindBy(xpath = "//*[.='Please provide a valid email address.']")//Lütfen geçerli bir e-posta adresi girin
    public WebElement provideValidEmailText;

    @FindBy(xpath = "//input[@name='wcfm_email_verified_button']")
    public static WebElement reSendCodeButton;

    @FindBy(xpath = "//input[@name='wcfm_email_verified_input']")
    public WebElement reSendCodeInput;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement codeInvalidText;

    @FindBy(id = "passoword")
    public WebElement password;

    @FindBy(id = "confirm_pwd")
    public WebElement confirmPassword;

    @FindBy(id = "password_strength")
    public static WebElement passwordStrength;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[contains(text(), 'Password strength should be atleast')]")
    public WebElement passwordRules;

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

    @FindBy(xpath = "//h1[.='Welcome to Allover Commerce!']")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//*[.='Email verification code invalid.']")
    public WebElement codeInvalidMessage;

    @FindBy(xpath = "//*[.='This Email already exists. Please login to the site and apply as vendor.']")
    public WebElement alreadyExistMessage;

    @FindBy(xpath = "//*[.='Registration Successfully Completed.']")
    public WebElement registrationSuccessMessage;
    @FindBy(xpath = "//div[.='Password and Confirm-password are not same.']")
    public WebElement PasswordAndConfirmPasswordAreNotMessage;}
    @FindBy(id = "password_strength")
    public WebElement passwordWrongMessage;

    @FindBy(xpath = "(//h1)[2]")
    public WebElement welcomeToAllevorCommerce;

    @FindBy(css= ".wcfm-message.wcfm-error")
    public WebElement emailWrongText;}
