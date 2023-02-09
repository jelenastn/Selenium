package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class D_23_Jelena_Stanic {

    WebDriver driver;
    WebDriverWait wdwait;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void LogIn(){
        driver.navigate().to("https://demoqa.com/books");
        WebElement loginLink = driver.findElement(By.id("login"));
        loginLink.click();
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("jelena");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Dunaveplavi30!");
        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();
        List <WebElement> books = driver.findElements(By.className("mr-2"));
        int booksNumber = books.size();
        Assert.assertEquals(booksNumber, 0);

    }
    @AfterClass
    public void afterMethod()  {
       driver.quit();


    }
    @Test
    public void addABook() throws InterruptedException {

        Thread.sleep(3000);
        WebElement book1 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        book1.click();

        List<WebElement> addButton = driver.findElements(By.id("addNewRecordButton"));
        addButton.get(1).click();

        driver.navigate().back();
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,350)", "");

       List <WebElement> profileButton = driver.findElements(By.id("item-3"));
        profileButton.get(4).click();

        Thread.sleep(3000);
        List<WebElement> books = driver.findElements(By.className("mr-2"));
        System.out.println(books);
        System.out.println("Na stanju: "+books.size()+" knjiga/e.");
        int booksNumber = books.size();
        Assert.assertEquals(booksNumber, 1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");
        WebElement deleteBtn = driver.findElement(By.id("delete-record-undefined"));

        deleteBtn.click();

        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("closeSmallModal-ok"))));

        driver.findElement(By.id("closeSmallModal-ok")).click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();


        WebElement logOutBtn = driver.findElement(By.id("submit"));
        logOutBtn.click();

        //driver.navigate().back();


    }


    @Test
    public void addTwoBooks() throws InterruptedException {

        Thread.sleep(3000);
        WebElement book1 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        book1.click();

        List<WebElement> addButton = driver.findElements(By.id("addNewRecordButton"));
        addButton.get(1).click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        WebElement backToBook = driver.findElement(By.id("addNewRecordButton"));
        backToBook.click();

        WebElement book2 = driver.findElement(By.id("see-book-Speaking JavaScript"));
        book2.click();

        Thread.sleep(2000);
        List <WebElement> addButton2 = driver.findElements(By.id("addNewRecordButton"));
        addButton2.get(1).click();


        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,350)", "");

        List <WebElement> profileButton = driver.findElements(By.id("item-3"));
        profileButton.get(4).click();

        Thread.sleep(3000);
        List <WebElement> books = driver.findElements(By.className("mr-2"));
        System.out.println(books);
        System.out.println("Na stanju: "+books.size()+" knjiga/e.");
        int booksNumber = books.size();
        Assert.assertEquals(booksNumber, 2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");

      List  <WebElement> deleteBtns = driver.findElements(By.id("delete-record-undefined"));
        while (deleteBtns.size() > 0) {
            deleteBtns.get(0).click();

            wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("closeSmallModal-ok"))));

            driver.findElement(By.id("closeSmallModal-ok")).click();

            Thread.sleep(3000);
            driver.switchTo().alert().accept();
            Thread.sleep(3000);

            deleteBtns = driver.findElements(By.id("delete-record-undefined"));
        }

        WebElement logOutBtn = driver.findElement(By.id("submit"));
        logOutBtn.click();

    }
    @Test
    public void addThreeBooks() throws InterruptedException {

        Thread.sleep(3000);
        WebElement book1 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        book1.click();

        List<WebElement> addButton = driver.findElements(By.id("addNewRecordButton"));
        addButton.get(1).click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement backToBook = driver.findElement(By.id("addNewRecordButton"));
        backToBook.click();

        WebElement book2 = driver.findElement(By.id("see-book-Speaking JavaScript"));
        book2.click();

        Thread.sleep(2000);
        List <WebElement> addButton2 = driver.findElements(By.id("addNewRecordButton"));
        addButton2.get(1).click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

         backToBook = driver.findElement(By.id("addNewRecordButton"));
        backToBook.click();

        WebElement book3 = driver.findElement(By.id("see-book-You Don't Know JS"));
        book3.click();

        Thread.sleep(2000);
        List <WebElement> addButton3 = driver.findElements(By.id("addNewRecordButton"));
        addButton3.get(1).click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();



        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,350)", "");

        List <WebElement> profileButton = driver.findElements(By.id("item-3"));
        profileButton.get(4).click();

        Thread.sleep(3000);
        List <WebElement> books = driver.findElements(By.className("mr-2"));
        System.out.println(books);
        System.out.println("Na stanju: "+books.size()+" knjiga/e.");
        int booksNumber = books.size();
        Assert.assertEquals(booksNumber, 3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");

        List  <WebElement> deleteBtns = driver.findElements(By.id("delete-record-undefined"));
        while (deleteBtns.size() > 0) {
            deleteBtns.get(0).click();

            wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("closeSmallModal-ok"))));

            driver.findElement(By.id("closeSmallModal-ok")).click();

            Thread.sleep(3000);
            driver.switchTo().alert().accept();
            Thread.sleep(3000);

            deleteBtns = driver.findElements(By.id("delete-record-undefined"));
        }

        WebElement logOutBtn = driver.findElement(By.id("submit"));
        logOutBtn.click();

    }
    @Test
    public void addFourBooks() throws InterruptedException {

        Thread.sleep(3000);
        WebElement book1 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        book1.click();

        List<WebElement> addButton = driver.findElements(By.id("addNewRecordButton"));
        addButton.get(1).click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement backToBook = driver.findElement(By.id("addNewRecordButton"));
        backToBook.click();

        WebElement book2 = driver.findElement(By.id("see-book-Speaking JavaScript"));
        book2.click();

        Thread.sleep(2000);
        List <WebElement> addButton2 = driver.findElements(By.id("addNewRecordButton"));
        addButton2.get(1).click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        backToBook = driver.findElement(By.id("addNewRecordButton"));
        backToBook.click();

        WebElement book3 = driver.findElement(By.id("see-book-You Don't Know JS"));
        book3.click();

        Thread.sleep(2000);
        List <WebElement> addButton3 = driver.findElements(By.id("addNewRecordButton"));
        addButton3.get(1).click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        backToBook = driver.findElement(By.id("addNewRecordButton"));
        backToBook.click();
        Thread.sleep(3000);
        WebElement book4 = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
        book4.click();

        Thread.sleep(2000);
        List <WebElement> addButton4 = driver.findElements(By.id("addNewRecordButton"));
        addButton4.get(1).click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,350)", "");

        List <WebElement> profileButton = driver.findElements(By.id("item-3"));
        profileButton.get(4).click();

        Thread.sleep(3000);
        List <WebElement> books = driver.findElements(By.className("mr-2"));
        System.out.println(books);
        System.out.println("Na stanju: "+books.size()+" knjiga/e.");
        int booksNumber = books.size();
        Assert.assertEquals(booksNumber, 4);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");

        List  <WebElement> deleteBtns = driver.findElements(By.id("delete-record-undefined"));
        while (deleteBtns.size() > 0) {
            deleteBtns.get(0).click();

            wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("closeSmallModal-ok"))));

            driver.findElement(By.id("closeSmallModal-ok")).click();

            Thread.sleep(3000);
            driver.switchTo().alert().accept();
            Thread.sleep(3000);

            deleteBtns = driver.findElements(By.id("delete-record-undefined"));
        }

        WebElement logOutBtn = driver.findElement(By.id("submit"));
        logOutBtn.click();

    }

}
