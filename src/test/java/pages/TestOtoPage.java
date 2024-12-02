package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtoPage {


    public TestOtoPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "global-search")
    public WebElement searchBox;

    @FindBy(className = "product-count-text")
    public WebElement searchProduct;

    @FindBy(className = "prod-img")
    public List<WebElement> productList;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement firstProductName;

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

    @FindBy(xpath = "(//*[@class='cart-count basket-count'])[1]")
    public WebElement cartLinki;

    @FindBy(xpath = "//button[@class='add-to-cart']")
    public WebElement addToCartButonu;

    @FindBy(xpath = "//*[@*='product-title text-center']")
    public WebElement itemsOfCart;


}
