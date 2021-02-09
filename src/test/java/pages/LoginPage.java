package pages;

import Utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id="user-name")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;


    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void login(String userName, String password) {
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password, Keys.ENTER);
    }



}
