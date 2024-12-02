package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US01_LoginTestPosStepDef {



     LoginPage loginPage= new LoginPage();


    @Given("User go to toUrl")
    public void userGoToToUrl() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

    }

    @And("User write email {string} in the box")
    public void userWriteEmailInTheBox(String text) {

        loginPage.loginEmailBox
                .sendKeys(ConfigReader.getProperty(text));
    }

    @And("User write password {string} in the box")
    public void userWritePasswordInTheBox(String text) {
        loginPage.loginPasswordBox
                .sendKeys(ConfigReader.getProperty(text));
    }
    @Then("User click signIn button")
    public void userClickSignInButton() {
        loginPage.loginSignInButton
                .click();

    }
    @Then("User click account button")
    public void userClickAccountButton() {
        loginPage.accountLink
                .click();
    }
    @And("User ensure sign in the app successfully")
    public void userEnsureSignInTheAppSuccessfully() {

        Assertions.assertTrue(loginPage.logOutButton.isDisplayed());
    }


    @And("close page")
    public void closePage() {

        Driver.quitDriver();
    }


}
