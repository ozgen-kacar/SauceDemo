package step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BasePage;
import pages.CheckoutPage;

public class HomePageStepDefinitions {
    BasePage basePage = new BasePage();
    CheckoutPage checkoutPage=new CheckoutPage();

    @Then("user verify that pageTitle is {string}")
    public void user_verify_that_pageTitle_is(String string) {

        Assert.assertEquals(string,basePage.getPageTitle());
    }

    @Then("user selected product {string} add to cart")
    public void user_selected_product_add_to_cart(String string) {

        basePage.addProductToCart(string);
        checkoutPage.verifyCorrectItemAddedToTheCart(string);
    }

    @Then("user remove one item from the cart")
    public void user_remove_one_item_from_the_cart() {
        checkoutPage.removeButton.click();
        System.out.println("one item deleted");
    }

}
