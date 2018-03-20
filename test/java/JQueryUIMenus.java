import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.JQueryUIMenusPage;
import pajeObject.LandingPage;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class JQueryUIMenus extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    @Test
    public void jQueryUIMenusCheck() throws IOException, URISyntaxException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Actions builder = new Actions(driver);

        LandingPage lp = new LandingPage(driver);
        lp.getJqueryUIMenus().click();

        JQueryUIMenusPage jqp = new JQueryUIMenusPage(driver);

        builder.moveToElement(jqp.getMenuEnabled()).build().perform();
        builder.moveToElement(jqp.getMenuDownloads()).build().perform();

        URLStatusChecker urlChecker = new URLStatusChecker(driver);
        urlChecker.setHTTPRequestMethod(RequestMethod.GET);
        String uriPDF = jqp.getDownloads().get(0).getAttribute("href");
        String uriCSV = jqp.getDownloads().get(1).getAttribute("href");
        String uriExcel = jqp.getDownloads().get(2).getAttribute("href");

        urlChecker.setURIToCheck(uriPDF);
        Assert.assertTrue(urlChecker.getHTTPStatusCode() == 200);

        urlChecker.setURIToCheck(uriCSV);
        Assert.assertTrue(urlChecker.getHTTPStatusCode() == 200);

        urlChecker.setURIToCheck(uriExcel);
        Assert.assertTrue(urlChecker.getHTTPStatusCode() == 200);


    }



    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
