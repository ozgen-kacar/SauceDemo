package step_definitions;

import Utils.ConfigurationReader;
import Utils.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.BasePage;
import pages.LoginPage;

public class LoginPageStepDefinitions {
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("I am on the login page");
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @And("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {

        System.out.println("Login with valid credentials");
        String userName = ConfigurationReader.getProperty("userName");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(userName, password);
    }




    @Then("user sort the products list by {string}")
    public void user_sort_the_products_list_by(String string) {

      basePage.sortProduct(string);
      basePage.totalItemAtTheInventory();

    }




    @Then("user verify number of item at the cart is {string}")
    public void user_verify_number_of_item_at_the_cart_is(String int1) {
        String count= basePage.numberOfItemAtTheCart();
        System.out.println("number of item at the cart is : "+ count);
        Assert.assertEquals("added number of item is true", count,int1);
    }


}
