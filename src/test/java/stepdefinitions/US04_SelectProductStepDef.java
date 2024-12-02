package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pages.ProductPage;
import pages.TestOtoPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US04_SelectProductStepDef {

    TestOtoPage testOtoPage = new TestOtoPage();
    ProductPage proPage = new ProductPage();

    @When("user write {string} in search box")
    public void userWriteInSearchBox(String item) {
        testOtoPage.searchBox.sendKeys(item + Keys.ENTER);
    }

    @And("User take a screenshot and save it as{string}")
    public void userTakeAScreenshotAndSaveItAs(String text)throws IOException {
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot(text);
    }

    @Then("User click first product")
    public void userClickFirstProduct() {
        testOtoPage.productList
                .get(0)
                .click();
        System.out.println(testOtoPage.firstProductName.getText());
    }

    @And("User ensure the valid product open")
    public void userEnsureTheValidProductOpen() {
        String expectedString = ConfigReader.getProperty("productName");
        String actualString = testOtoPage
                .firstProductName
                .getText()
                .toLowerCase();
        Assertions.assertTrue(actualString.contains(expectedString));
    }

    @Then("User add to selected product to cart")
    public void userAddToSelectedProductToCart() {
        ReusableMethods.waitFor(2);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", proPage.addToCart);
        ReusableMethods.waitFor(2);
        proPage.addToCart.click();
        ReusableMethods.waitFor(2);

    }

    @Given("User click cart button")
    public void userClickCartButton() {
        ReusableMethods.waitFor(3);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", proPage.cartButton);
        ReusableMethods.waitFor(3);
        proPage.cartButton.click();
    }

    @And("User delete the product from chart")
    public void userDeleteTheProductFromChart() {
        ReusableMethods.waitFor(3);
        proPage.removeButton.click();
        ReusableMethods.waitFor(3);
    }

    @And("User accept delete popup")
    public void userAcceptDeletePopup() {

        proPage.acceptRemoveButton.click();
        ReusableMethods.waitFor(1);
    }

    @Then("User take success message")
    public void userTakeSuccessMessage() {
        ReusableMethods.waitFor(9);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", proPage.emptyCart);
        String successMessage=proPage.emptyCart.getText();
        System.out.println(successMessage);
        ReusableMethods.waitFor(2);
   String expectedMessage = "Shopping cart is empty";

        Assert.assertEquals(successMessage,expectedMessage);


    }
}
