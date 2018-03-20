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
import pajeObject.InfiniteScrollPage;
import pajeObject.LandingPage;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class InfiniteScroll extends Base {
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
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Actions builder = new Actions(driver);

        LandingPage lp = new LandingPage(driver);
        lp.getInfiniteScroll().click();

        InfiniteScrollPage isp = new InfiniteScrollPage(driver);
        int divSize = isp.getDivs().size();
        log.info(divSize);

//        wait.until(ExpectedConditions.visibilityOf(isp.getDiv()));


        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        for (int i = 0; i < 10; i++){

//            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            isp.getBody().sendKeys(Keys.END);
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(isp.getDiv(), divSize));
            divSize = isp.getDivs().size();
            log.info(divSize);
        }
    }


//
//    @AfterTest
//    public void teardown(){
//        driver.close();
//        driver=null;
//    }
}
