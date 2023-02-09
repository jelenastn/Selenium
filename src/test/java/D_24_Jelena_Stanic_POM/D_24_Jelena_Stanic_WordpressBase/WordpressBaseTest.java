package D_24_Jelena_Stanic_POM.D_24_Jelena_Stanic_WordpressBase;

import D_24_Jelena_Stanic_POM.D_24_Jelena_Stanic_WordpressPages.WordpressDashboardPage;
import D_24_Jelena_Stanic_POM.D_24_Jelena_Stanic_WordpressPages.WordpressHomePage;
import D_24_Jelena_Stanic_POM.D_24_Jelena_Stanic_WordpressPages.WordpressLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class WordpressBaseTest {
   public WebDriver driver;
  public  WebDriverWait wdwait;
    public WordpressHomePage wordpressHomePage;
    public WordpressLoginPage wordpressLoginPage;
    public WordpressDashboardPage wordpressDashboardPage;
    @BeforeClass
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wordpressHomePage = new WordpressHomePage(driver, wdwait);
        wordpressLoginPage = new WordpressLoginPage(driver, wdwait);
        wordpressDashboardPage = new WordpressDashboardPage(driver, wdwait);

    }

    @AfterClass
    public void tearDown(){

    }


}
