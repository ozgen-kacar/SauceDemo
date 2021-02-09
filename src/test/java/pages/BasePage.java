package pages;

import Utils.BrowserUtils;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {

        public BasePage() {
            PageFactory.initElements(Driver.get(), this);
        }


@FindBy(className = "product_sort_container")
public WebElement sortIcon;


@FindBy(xpath="//span[@class='fa-layers-counter shopping_cart_badge']")
public WebElement itemNumberOfTheCart;





public String getPageTitle(){
    return Driver.get().getTitle();
}


public void clickSortIcon(){
    sortIcon.click();
}

    public void sortProduct(String string){
      BrowserUtils.waitForClickablility(sortIcon,3);
      clickSortIcon();

      BrowserUtils.wait(1);
      Select options = new Select( Driver.get().findElement(By.className("product_sort_container")));
      options.selectByValue(string);


}
public void totalItemAtTheInventory(){
    List <WebElement> listOfProduct = Driver.get().findElements(By.className("inventory_item"));
    System.out.println("Total item at the inventory is : "+listOfProduct.size());
    BrowserUtils.wait(1);

}
    public void addProductToCart(String string){

        WebElement button = Driver.get().findElement(By.xpath("//*[contains(text(),'"+ string +"')]//following::button[1]"));
        button.click();
        BrowserUtils.wait(1);
        System.out.println("selected item added to the cart");
//verifyCorrectItemAddedToTheCart(string);

    }
    public String numberOfItemAtTheCart(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0,-500)");
    return itemNumberOfTheCart.getText();
    }
public void clickCartIcon(){
    itemNumberOfTheCart.click();
}





 }
