package pages;

import Utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class CheckoutPage extends BasePage{

    @FindBy(xpath = "(//*[@class='inventory_item_name'])[1]")
    public WebElement firstItemName;

    @FindBy(xpath = "(//*[@class='btn_primary btn_inventory'])[1]")
    public WebElement firstItemButton;

    @FindBy(xpath = "(//*[@class='inventory_item_name'])[2]")
    public WebElement secondItemName;

    @FindBy(xpath = "(//*[@class='btn_primary btn_inventory'])[1]")
    public WebElement secondItemButton;

    @FindBy(xpath = "//*[@class='shopping_cart_link fa-layers fa-fw']")
    public WebElement cartIcon;

    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/div[1]/div[3]/div[2]/a/div")
    public WebElement firstItemNameInCart;

    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/div[1]/div[4]/div[2]/a/div")
    public WebElement secondItemNameInCart;

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement zipcode;

    @FindBy(xpath = "//*[@value='CONTINUE']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[text()='FINISH']")
    public WebElement finishButton;

    @FindBy(xpath = "//*[@class='complete-header']")
    public WebElement checkoutCompletedMessage;

    @FindBy(xpath = "//*[contains(text(),'Continue')]")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//*[contains(text(),'REMOVE')]")
    public WebElement removeButton;

    @FindBy(xpath = "//*[contains(text(),'CHECKOUT')]")
    public WebElement checkoutButton;

    public void verifyCorrectItemAddedToTheCart(String string){
        clickCartIcon();
        List<WebElement> addedItem = Driver.get().findElements(By.xpath("//*[@class='inventory_item_name']"));
        for(int i=addedItem.size()-1;i>=0;){
            Assert.assertEquals(addedItem.get(i).getText(),string);
            System.out.println("verifying item is : "+addedItem.get(i).getText());
            break;
        }
        continueShoppingButton.click();
    }

    public void firstItemButton() { firstItemButton.click(); }

    public String firstItemName() { return firstItemName.getText(); }

    public void secondItemButton() {
        secondItemButton.click();
    }

    public String secondItemName() {
        return secondItemName.getText();
    }

    public String firstItemNameInCart() {
        return firstItemNameInCart.getText();
    }

    public String secondItemNameInCart() {
        return secondItemNameInCart.getText();
    }

}





