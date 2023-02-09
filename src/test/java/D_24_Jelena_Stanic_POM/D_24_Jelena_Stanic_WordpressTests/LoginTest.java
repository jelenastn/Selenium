package D_24_Jelena_Stanic_POM.D_24_Jelena_Stanic_WordpressTests;

import D_24_Jelena_Stanic_POM.D_24_Jelena_Stanic_WordpressBase.WordpressBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends WordpressBaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://wordpress.com/");

    }
    @Test
    public void userCanLogIn(){
        wordpressHomePage.clickOnLoginButton();
       wordpressLoginPage.insertUsername("jelenastn30@gmail.com");
       wordpressLoginPage.clickContinueButton();
       wordpressLoginPage.insertPassword("Dunaveplavi30");
       String username = wordpressLoginPage.username();
       wordpressLoginPage.clickOnLogInButton();
       Assert.assertEquals(wordpressDashboardPage.getTitle().getText(), username );

    }
}
