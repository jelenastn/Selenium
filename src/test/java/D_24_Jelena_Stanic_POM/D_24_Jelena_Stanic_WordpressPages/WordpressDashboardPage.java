package D_24_Jelena_Stanic_POM.D_24_Jelena_Stanic_WordpressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressDashboardPage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement title;

    public WordpressDashboardPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTitle() {
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/ekopinkum.wordpress.com"));
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("site__title"))));
        return driver.findElement(By.className("site__title"));

    }

}
