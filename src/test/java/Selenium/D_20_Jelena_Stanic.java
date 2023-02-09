package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.List;

import static com.sun.deploy.util.Waiter.get;

public class D_20_Jelena_Stanic {
    public static void main(String[] args) throws InterruptedException {

        Domaci:
        //Otici na YouTube preko Google-a i pustiti pesmu po Vasem izboru.



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.className("gLFyf"));
        searchBox.sendKeys("Youtube");

        WebElement searchButton = driver.findElement(By.className("gNO89b"));
        Thread.sleep(2000);
        searchButton.click();

        WebElement youtubeChoose = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        youtubeChoose.click();
       // Thread.sleep(2000);

        WebElement youtubeBox = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/input"));
        youtubeBox.sendKeys("https://www.youtube.com/watch?v=bfAQT3TRr1I");

       // Thread.sleep(2000);
        WebElement searchIcon = driver.findElement(By.id("search-icon-legacy"));
        searchIcon.click();

        Thread.sleep(2000);

        List<WebElement> findSong = driver.findElements(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string"));
    //   System.out.println(findSong);
        findSong.get(0).click();


    }
}


