import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class FormAuthentication extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    @Test
    public void checkFormAuthentication() throws IOException, URISyntaxException {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        LandingPage lp = new LandingPage(driver);
        lp.getFormAuthentication().click();

        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);
        FormAuthenticationSecurePage formAuthenticationSecurePage = new FormAuthenticationSecurePage(driver);

        log.info("cookies before logging in");
        Set<Cookie> allcookies = driver.manage().getCookies();
        for (Cookie cookie : allcookies){
            System.out.println(cookie.toString());
        }

        formAuthenticationPage.getUsername().sendKeys("wrong name");
        formAuthenticationPage.getPassword().sendKeys("wrong password");
        formAuthenticationPage.getSubmit().click();
        wait.until(ExpectedConditions.visibilityOf(formAuthenticationPage.getFlash()));
        Assert.assertTrue(formAuthenticationPage.getFlash().getText().contains("Your username is invalid!"));

        formAuthenticationPage.getUsername().sendKeys("tomsmith");
        formAuthenticationPage.getPassword().sendKeys("SuperSecretPassword!");
        formAuthenticationPage.getSubmit().click();
        wait.until(ExpectedConditions.visibilityOf(formAuthenticationSecurePage.getFlash()));
        Assert.assertTrue(formAuthenticationPage.getFlash().getText().contains("You logged into a secure area!"));

        log.info("cookies after logging in");
        allcookies = driver.manage().getCookies();
        for (Cookie cookie : allcookies){
            System.out.println(cookie.toString());
        }

        formAuthenticationSecurePage.getLogout().click();
        wait.until(ExpectedConditions.visibilityOf(formAuthenticationSecurePage.getFlash()));
        Assert.assertTrue(formAuthenticationPage.getFlash().getText().contains("You logged out of the secure area!"));

        log.info("cookies after logging out");
        allcookies = driver.manage().getCookies();
        for (Cookie cookie : allcookies){
            System.out.println(cookie.toString());
        }


    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
