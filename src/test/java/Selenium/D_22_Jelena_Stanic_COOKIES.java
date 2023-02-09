package Selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.List;

public class D_22_Jelena_Stanic_COOKIES {
    public static void main(String[] args) throws InterruptedException {
        //Ulogujte se na demoqa preko cookies-a, dodati dve knjige na svoj nalog,
        // zatim se izlogovati brisanjem cookies-a.
        //Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");

        Cookie cookie1 = new Cookie("userID", "4693c345-3a49-4147-bdcb-2c8cf3060ca4");
        driver.manage().addCookie(cookie1);
        Cookie cookie2 = new Cookie("expires", "2023-01-22T19%3A07%3A37.321Z");
        driver.manage().addCookie(cookie2);
        Cookie cookie3 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImplbGVuYSIsInBhc3N3b3JkIjoiRHVuYXZlcGxhdmkzMCEiLCJpYXQiOjE2NzM4MDk2NTd9.h4jrtsW6EyICwFuOP1Yu18lKIvNW1a62IdzbcBg1mbc");
        driver.manage().addCookie(cookie3);
        Cookie cookie4 = new Cookie("userName", "jelena");
        driver.manage().addCookie(cookie4);
        driver.navigate().refresh();

        Thread.sleep(5000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");

        List <WebElement> bookStoreButton = driver.findElements(By.id("item-2"));
        bookStoreButton.get(4).click();

       Thread.sleep(3000);
        WebElement book1 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        book1.click();

        Thread.sleep(3000);
        List <WebElement> addButton = driver.findElements(By.id("addNewRecordButton"));
        addButton.get(1).click();

        driver.navigate().back();

        WebElement book2 = driver.findElement(By.id("see-book-Speaking JavaScript"));
        book2.click();

        Thread.sleep(2000);
        List <WebElement> addButton2 = driver.findElements(By.id("addNewRecordButton"));
        addButton2.get(1).click();

        driver.navigate().back();

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,350)", "");

        List <WebElement> profileButton = driver.findElements(By.id("item-3"));
        profileButton.get(4).click();

        Thread.sleep(6000);
        List <WebElement> books = driver.findElements(By.className("mr-2"));
         System.out.println(books);
        System.out.println("Na stanju su "+books.size()+" knjige.");
        int booksNumber = books.size();
        Assert.assertEquals(booksNumber, 2);

       Thread.sleep(3000);
       driver.manage().deleteCookieNamed("token");

        driver.navigate().refresh();

        WebElement loginLink = driver.findElement(By.linkText("login"));
        loginLink.click();
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("jelena");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Dunaveplavi30!");
        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();

        Thread.sleep(3000);
        List <WebElement> books1 = driver.findElements(By.className("mr-2"));
        System.out.println(books1);
        System.out.println("Na stanju su i dalje "+books1.size()+" knjige.");

        int booksNumber1 = books1.size();
        Assert.assertEquals(booksNumber1, 2);




    }
}
