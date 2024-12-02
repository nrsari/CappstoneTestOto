package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[text()='Account'])[1]")
    public WebElement accountLink;

    @FindBy(id = "email")
    public WebElement loginEmailBox;

    @FindBy(id = "password")
    public WebElement loginPasswordBox;

    @FindBy(id = "submitlogin")
    public WebElement loginSignInButton;

    @FindBy(xpath = "(//*[text()='Logout'])[2]")
    public WebElement logOutButton;










}
