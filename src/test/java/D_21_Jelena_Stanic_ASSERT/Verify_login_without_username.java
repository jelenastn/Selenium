package D_21_Jelena_Stanic_ASSERT;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class Verify_login_without_username {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");
        WebElement clickPage = driver.findElement(By.id("menu-item-20"));
        clickPage.click();

        WebElement clickForm = driver.findElement(By.linkText("Test Login Page"));
        clickForm.click();
        String loggedInURL = driver.getCurrentUrl();

        WebElement inputUser = driver.findElement(By.id("username"));
        inputUser.sendKeys("");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        String validMessage = "Your username is invalid!";
        WebElement errorMessage = driver.findElement(By.id("error"));
        Thread.sleep(2000);
        System.out.println(errorMessage.getText());
        Assert.assertEquals(errorMessage.getText(), validMessage);


        Assert.assertEquals(driver.getCurrentUrl(), loggedInURL);




    }
}
