import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.KeyPressesPage;
import pajeObject.LandingPage;
import pajeObject.LargeDOMPage;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class LargeDOM extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    @Test
    public void largeDOMCheck() throws IOException, URISyntaxException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Actions builder = new Actions(driver);

        LandingPage lp = new LandingPage(driver);
        lp.getLargeDOM().click();

        LargeDOMPage domPage = new LargeDOMPage(driver);

        Assert.assertEquals(domPage.getNoSiblings().getText(), "No siblings");
        Assert.assertEquals(domPage.getDivId().getText(), "41.2");
        Assert.assertEquals(domPage.getTableId().getText(), "20.33");

    }



    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
