package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class P4_MyAccountPage {

    public P4_MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Store Manager")
    public WebElement storeManagerButton;

    @FindBy(linkText = "Orders")
    public WebElement ordersButton;

    @FindBy(linkText = "Downloads")
    public WebElement dowloadsButton;

    @FindBy(linkText = "Addresses")
    public WebElement addressesButton;

    @FindBy(linkText = "Account details")
    public WebElement accountDetailsButton;

    @FindBy(linkText = "Wishlist")
    public WebElement wishlistButton;

    @FindBy(partialLinkText = "Support Tickets")
    public WebElement supportTicketsButton;

    @FindBy(partialLinkText = "Followings")
    public WebElement followingsButton;

    @FindBy(linkText = "Log out")
    public WebElement logoutButton;

    @FindBy(xpath = "//*[.='Actions']")
    public WebElement followingButtonActionText;
    @FindBy(xpath = "//*[.='Ticket(s)']")
    public WebElement supportTicketsButtonTicketsText;

    @FindBy(xpath = "//h4[.='Account Details']")
    public WebElement accountDetailsButtonTitle;

    @FindBy(xpath = "//h4[.='Orders']")
    public WebElement ordersButtonTitle;

    @FindBy(xpath = "//h4[.='Downloads']")
    public WebElement dowloadsButtonTitle;

    @FindBy(xpath = "//h2[.='My Account']")
    public WebElement myAccountTitle;

    @FindBy(xpath = "//a[text()='Browse products']")
    public WebElement browseProduct;

    @FindBy(xpath = "(//nav)[1]")
    public WebElement dashboardMenuTexts;

    public List<String> getLinkTexts() {
        List<WebElement> linkElements = dashboardMenuTexts.findElements(By.tagName("a"));
        List<String> linkTexts = new ArrayList<>();

        for (WebElement linkElement : linkElements) {
            linkTexts.add(linkElement.getText());
        }

        return linkTexts;
    }

}