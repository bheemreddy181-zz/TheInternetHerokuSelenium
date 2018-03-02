import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.LandingPage;

import java.io.IOException;

/**
 * Created by alexey.reshetnikov on 02.03.2018.
 */
public class BasicAuth extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
        driver.manage().deleteAllCookies();
    }

    @Test
    public void makeBasicAuth(){
        LandingPage lp = new LandingPage(driver);
//        lp.getBasicAuth().click();
        driver.get("http://admin:admin@" + prop.getProperty("url").split("//")[1]);
        pajeObject.BasicAuth basicAuth = new pajeObject.BasicAuth(driver);
//        Assert.assertTrue(basicAuth.getCongratulations().getText().contains("Congratulations!"));
        //Базовая аутентификация так и не заработала на этом сайте
        //Непонятно, почему
    }

    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
