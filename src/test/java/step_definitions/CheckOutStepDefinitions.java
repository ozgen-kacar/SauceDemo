package step_definitions;

import Utils.BrowserUtils;
import Utils.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.CheckoutPage;
import java.util.LinkedHashMap;
import java.util.Map;

public class CheckOutStepDefinitions {
    BasePage basePage = new BasePage();
    CheckoutPage checkoutPage = new CheckoutPage();


    private String firstProduct = null; //item at the list
    private String secondProduct = null;

    private String selected1name=null;  // item at the cart
    private String selected1price=null;
    private String selected2name=null;
    private String selected2price=null;

    @Then("user stores first product name")
    public void user_stores_first_product_name() {

        firstProduct = checkoutPage.firstItemName();
        System.out.println("First product name is : "+firstProduct);
    }

    @When("user clicks the first add to cart button")
    public void user_clicks_the_first_add_to_cart_button() {

        checkoutPage.firstItemButton();
        BrowserUtils.wait(2);

    }

    @Then("user stores second product name")
    public void user_stores_second_product_name() {
        secondProduct = checkoutPage.secondItemName();
        System.out.println("second product name is: "+secondProduct);
    }

    @Then("user clicks the second add to cart button")
    public void user_clicks_the_second_add_to_cart_button() {
        checkoutPage.secondItemButton();
        BrowserUtils.wait(2);

    }

    @Then("user clicks the cart button")
    public void user_clicks_the_cart_button() {

        checkoutPage.cartIcon.click();

    }

    @Then("user verify that selected products added successfully")
    public void user_verify_that_selected_products_added_successfully() {

        Assert.assertEquals(firstProduct, checkoutPage.firstItemNameInCart());
        Assert.assertEquals(secondProduct, checkoutPage.secondItemNameInCart());

    }

    @Then("user navigate to checkout screen")
    public void user_navigate_to_checkout_screen() {
        basePage.clickCartIcon();
        selected1name = Driver.get().findElement(By.xpath("(//div[@class='cart_item']//div[@class='inventory_item_name'])[1]")).getText();
        selected1price=Driver.get().findElement(By.xpath("(//div[@class='cart_item']//div[@class='inventory_item_price'])[1]")).getText();


        selected2name = Driver.get().findElement(By.xpath("(//div[@class='cart_item']//div[@class='inventory_item_name'])[2]")).getText();
        selected2price=Driver.get().findElement(By.xpath("(//div[@class='cart_item']//div[@class='inventory_item_price'])[2]")).getText();

        checkoutPage.checkoutButton.click();
    }

    @Then("user give{string},{string},{string} information to checkout")
    public void user_give_information_to_checkout(String string, String string2, String string3) {
        checkoutPage.firstName.sendKeys(string);
        checkoutPage.lastName.sendKeys(string2);
        checkoutPage.zipcode.sendKeys(string3);
        BrowserUtils.waitForClickablility(checkoutPage.continueButton, 2);
        checkoutPage.continueButton.click();

    }


    @Then("user verify correct name and price at the checkout")
    public void user_verify_correct_name_and_price_at_the_checkout() {


        Map<String,String> map =new LinkedHashMap<>();
        map.put(selected1name,"$"+selected1price);
        map.put(selected2name,"$"+selected2price);
        System.out.println("Items at the cart: " + map);


    int itemCount=Driver.get().findElements(By.xpath("//div[@class='cart_list']/div[@class='cart_item']")).size();
    Map<String,String>mapCheckout=new LinkedHashMap<>();
    for (int i = 1; i <=itemCount ; i++) {
        String itemName=Driver.get().findElement(By.xpath("(//*[@class='inventory_item_name'])["+i+"]")).getText();
        String itemPrice=Driver.get().findElement(By.xpath("(//*[@class='inventory_item_price'])["+i+"]")).getText();
        mapCheckout.put(itemName,itemPrice);
    }
    System.out.println("Items at the checkout page : "+ mapCheckout);
    Assert.assertEquals(map,mapCheckout);

        BrowserUtils.waitForClickablility(checkoutPage.finishButton, 2);
        checkoutPage.finishButton.click();
        Assert.assertEquals("THANK YOU FOR YOUR ORDER", checkoutPage.checkoutCompletedMessage.getText());
        System.out.println("Order is completed. " + checkoutPage.checkoutCompletedMessage.getText() + " message is received");
}


    }


