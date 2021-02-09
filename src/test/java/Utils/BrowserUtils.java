package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;


public class BrowserUtils {

    public static void wait(int seconds) {
        try {
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
