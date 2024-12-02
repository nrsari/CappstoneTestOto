package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.TestOtoPage;

public class US03_SearchProductStepDef {

    TestOtoPage testOtoPage = new TestOtoPage();

    @Then("user put phone in search box")
    public void userPutPhoneInSearchBox() {

        testOtoPage.searchBox.sendKeys("phone" + Keys.ENTER);
    }

    @Then("user put dress in search box")
    public void userPutDressInSearchBox() {

        testOtoPage.searchBox.sendKeys("dress" + Keys.ENTER);
    }
    @Then("user put nutella in search box")
    public void userPutNutellaInSearchBox() {

        testOtoPage.searchBox.sendKeys("nutella" + Keys.ENTER);
    }

    @And("user ensure the item in result")
    public void userEnsureTheItemInResult() {

        String unExpectedResult = "0 Products Found";
        String actualResult = testOtoPage.searchProduct.getText();

        Assertions.assertNotEquals(unExpectedResult,actualResult);

    }

    @And("user ensure the item don't find in result")
    public void userEnsureTheItemDonTFindInResult() {

        String expectedString = "0 Products Found";
        String actualString = testOtoPage.searchProduct
                .getText();

        Assertions.assertEquals(expectedString,actualString);
    }



}
