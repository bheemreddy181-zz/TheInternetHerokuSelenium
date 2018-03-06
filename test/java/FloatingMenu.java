import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.FloatingMenuPage;
import pajeObject.LandingPage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class FloatingMenu extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    @Test
    public void checkFileDownload() throws IOException, URISyntaxException, InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        LandingPage lp = new LandingPage(driver);
        lp.getFloatingMenu().click();

        FloatingMenuPage fm = new FloatingMenuPage(driver);

        for (WebElement element : fm.getParagraphs()){
            js.executeScript("arguments[0].scrollIntoView();", element);
            fm.getHome().click();
            log.info(fm.getHome().getText());
            fm.getNews().click();
            log.info(fm.getNews().getText());
            fm.getContact().click();
            log.info(fm.getContact().getText());
            fm.getAbout().click();
            log.info(fm.getAbout().getText());
        }

        js.executeScript("window.scrollBy(0,-1000)"); //scroll 1000 pixels higher from the place you are at
//        Thread.sleep(5000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //scroll to bottom
//        Thread.sleep(5000);
        js.executeScript("window.scrollTo(0, 0)"); //scroll to top
//        Thread.sleep(5000);


    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
