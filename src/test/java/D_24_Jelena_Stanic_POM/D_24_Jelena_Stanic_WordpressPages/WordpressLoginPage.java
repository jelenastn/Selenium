package D_24_Jelena_Stanic_POM.D_24_Jelena_Stanic_WordpressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressLoginPage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement usernameOrEmailField;
    WebElement continueButton;
    WebElement passwordField;
    WebElement logInButton;



    public WordpressLoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUsernameOrEmailField() {
        return driver.findElement(By.id("usernameOrEmail"));
        //return usernameOrEmailField;
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.className("login__form-action"));

    }


    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLogInButton() {
        return driver.findElement(By.cssSelector(".button.form-button.is-primary"));
    }


    //  --------------------------------------------------------------------------
    public void insertUsername(String username) {
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F"));
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("usernameOrEmail"))));
        getUsernameOrEmailField().clear();
        getUsernameOrEmailField().sendKeys(username);
    }
    public void clickContinueButton(){
        getContinueButton().click();
    }
    public void insertPassword(String password){
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("password"))));
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }
    public void clickOnLogInButton(){
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".button.form-button.is-primary"))));
        getLogInButton().click();
    }


    public String username(){
        return getUsernameOrEmailField().getAttribute("value");

    }
}
