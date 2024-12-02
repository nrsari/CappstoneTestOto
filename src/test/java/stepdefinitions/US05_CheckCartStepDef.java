package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.ProductPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US05_CheckCartStepDef {

ProductPage proPage= new ProductPage();

    static int cartPrice = 0;
    static int priceSum = 0;

    @And("User search {string} takes price and adds the cart")
    public void userSearchTakesPriceAndAddsTheCart(List<String> productList) {
        ReusableMethods.waitFor(2);
        for (int i = 0; i < productList.size(); i++) {
            ReusableMethods.waitFor(2);
            proPage.searchBox.sendKeys(productList.get(i));
            ReusableMethods.waitFor(1);
            proPage.searchBox.click();
            ReusableMethods.waitFor(1);
            proPage.selectedProduct.click();
            // proPage.firstItem.click();
            ReusableMethods.waitFor(1);
            try {
                String priceItem = proPage.priceValue.getText();
                priceSum = Integer.valueOf(priceItem.substring(1));
                priceSum++;
                System.out.println(priceSum);
            } catch (Exception e) {
            }
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView();", proPage.addToCart);
            ReusableMethods.waitFor(2);
            proPage.addToCart.click();
            ReusableMethods.waitFor(2);
            js.executeScript("arguments[0].scrollIntoView();", proPage.searchBox);

        }
    }



//    @And("User search item takes price and adds the cart")
//    public void userSearchItemTakesPriceAndAddsTheCart(String product) {
//        ReusableMethods1.waitFor(2);
//
//        proPage.searchBox.sendKeys(product);
//        ReusableMethods1.waitFor(1);
//        proPage.searchBox.click();
//        proPage.selectedProduct.click();
//        String priceItem1 = proPage.priceValue.getText();
//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("arguments[0].scrollIntoView();", proPage.addToCart);
//        ReusableMethods1.waitFor(2);
//        proPage.addToCart.click();
//        ReusableMethods1.waitFor(2);
//        js.executeScript("arguments[0].scrollIntoView();", proPage.searchBox);
//
//



//       for (int i = 0; i < productList.size(); i++) {
//
//           ReusableMethods1.waitFor(2);
//           proPage.searchBox.sendKeys(productList.get(i));
//           ReusableMethods1.waitFor(1);
//           proPage.searchBox.click();
//          ReusableMethods1.waitFor(1);
//          proPage.selectedProduct.click();
//         // proPage.firstItem.click();
//          ReusableMethods1.waitFor(1);
//           try {
//               String priceItem = proPage.priceValue.getText();
//               priceSum = Integer.valueOf(priceItem.substring(1));
//                priceSum++;
//               System.out.println(priceSum);
//           } catch (Exception e) {
//           }
//          // JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//           js.executeScript("arguments[0].scrollIntoView();", proPage.addToCart);
//           ReusableMethods1.waitFor(2);
//           proPage.addToCart.click();
//           ReusableMethods1.waitFor(2);
//           js.executeScript("arguments[0].scrollIntoView();", proPage.searchBox);
//
//       }



    @Then("User verify total price to sum of searched items price")
    public void userVerifyTotalPriceToSumOfSearchedItemsPrice() {
        ReusableMethods.waitFor(1);
       // proPage.noButtonProtectionAlert.click();
        ReusableMethods.waitFor(1);
        proPage.cartButton.click();
        try {
            String totalPrice = proPage.cartTotalPrice.getText();
            cartPrice = Integer.valueOf(totalPrice.substring(1));

        }catch(Exception e) {

        }
        System.out.println(cartPrice);
        Assert.assertEquals(priceSum,cartPrice);

    }




    }

