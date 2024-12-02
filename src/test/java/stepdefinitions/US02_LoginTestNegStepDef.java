package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import pages.LoginPage;


public class US02_LoginTestNegStepDef {



       LoginPage loginPage=new LoginPage();



    @Then("User ensure don't sign in the application")
    public void userEnsureDonTSignInTheApplication() {

        try {
            Assertions.assertTrue(loginPage.loginEmailBox.isDisplayed());

        } catch (NoSuchElementException e) {

            loginPage.logOutButton.click();

            Assertions.assertTrue(loginPage.loginEmailBox.isDisplayed());
        }


    }
}
