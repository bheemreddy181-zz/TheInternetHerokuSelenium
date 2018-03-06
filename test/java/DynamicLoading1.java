import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.DynamicContentPage;
import pajeObject.DynamicLoadingPage;
import pajeObject.DynamicLoadingPage1;
import pajeObject.LandingPage;

import java.io.IOException;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class DynamicLoading1 extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    @Test
    public void checkDynamicLoading1() {
        LandingPage lp = new LandingPage(driver);
        lp.getDynamicLoading().click();

        DynamicLoadingPage dl = new DynamicLoadingPage(driver);
        dl.getExample1().click();

        DynamicLoadingPage1 dl1 = new DynamicLoadingPage1(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        if (!dl1.getMessage().isDisplayed()){
            log.info("message is present not dispalyed");
        } else {
            log.info("message is present and dispalyed");
        }

        dl1.getButton().click();
        log.info("нажата кнопка");

        wait.until(ExpectedConditions.visibilityOf(dl1.getMessage()));
        if (!dl1.getMessage().isDisplayed()){
            log.info("message is present not dispalyed");
        } else {
            log.info("message is present and dispalyed");
        }

        log.info(dl1.getMessage().getText());


    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
