package D_24_Jelena_Stanic_POM.D_24_Jelena_Stanic_WordpressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressHomePage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement logInButton;

    public WordpressHomePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLogInButton() {
        return driver.findElement(By.linkText("Log In"));
    }
//-------------------------------------------------------------------------

    public void clickOnLoginButton(){
        getLogInButton().click();
    }



}
