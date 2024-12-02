package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ProductPage {

    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
}


    @FindBy(xpath = "//button[@class='remove']")
    public WebElement removeButton;

    @FindBy(id = "global-search")
    public WebElement firstItem;

    @FindBy(xpath = "//button[@class='add-to-cart']")
    public WebElement addToCart;


    @FindBy(xpath = "(//span[@class='menu-icon-text'])[3]")
    public WebElement cartButton;

    @FindBy(xpath = "//div[@class='summary-price subTotal']")
    public WebElement cartTotalPrice;

    @FindBy(xpath="//h3[@class='notfoundtxt mt-5']")
    public WebElement emptyCart;

    @FindBy(xpath="//span[@id='priceproduct']")
    public WebElement priceValue;

    @FindBy(xpath="(//label[@class='search-label'])[1]")
    public WebElement searchBox;

    @FindBy(xpath ="(//a[@class='prod-title]')[1])")
    public WebElement selectedProduct;

    @FindBy(className = "prod-img")
    public List<WebElement> productList;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement acceptRemoveButton;
}
