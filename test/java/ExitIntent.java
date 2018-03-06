import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.ExitIntentPage;
import pajeObject.LandingPage;

import java.io.IOException;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class ExitIntent extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    @Test
    public void checkExitIntent() {
        LandingPage lp = new LandingPage(driver);
        lp.getExitIntent().click();

        ExitIntentPage ei = new ExitIntentPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        log.info("проверка, что модальное окно не отображается");
        Assert.assertTrue(!ei.getModal().isDisplayed());

        //move mouse out of the window
        Actions actions = new Actions(driver);
        actions.moveByOffset(-10, -10).build().perform();

        wait.until(ExpectedConditions.visibilityOf(ei.getModal()));

        log.info("проверка, что модальное окно отображается");
        Assert.assertTrue(ei.getModal().isDisplayed());

        log.info(ei.getModalTitle().getText());

        ei.getModalClose().click();

        log.info("проверка, что модальное окно не отображается");
        Assert.assertTrue(!ei.getModal().isDisplayed());
    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
