import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.DynamicContentPage;
import pajeObject.DynamicControlsPage;
import pajeObject.LandingPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class DynamicControls extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    //Рабочий вариант с неявными ожиданиями
 /*   @Test
    public void checkDynamicControls() {
        LandingPage lp = new LandingPage(driver);
        lp.getDynamicControls().click();
        DynamicControlsPage dc = new DynamicControlsPage(driver);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        try{
            log.info(dc.getMessage().getText());
        } catch (Exception e){
            log.info("сообщение о наличии/отсутствии чекбокса отсутствует");
        }

        dc.getButton().click();
        log.info("нажата кнопка Remove");
        try{
            log.info(dc.getMessage().getText());
        } catch (Exception e){log.info("сообщение о наличии/отсутствии чекбокса отсутствует");}

        try{
            log.info(dc.getCheckbox().getText());
        } catch (Exception e){log.info("чекбокс отсутствует");}

        dc.getButton().click();
        log.info("нажата кнопка Add");
        try{
            log.info(dc.getMessage().getText());
        } catch (Exception e){log.info("сообщение о наличии/отсутствии чекбокса отсутствует");}

        try{
            log.info(dc.getCheckbox().getText());
        } catch (Exception e){log.info("чекбокс отсутствует");}
    }*/

    @Test
    public void checkDynamicControls() {
        LandingPage lp = new LandingPage(driver);
        lp.getDynamicControls().click();
        DynamicControlsPage dc = new DynamicControlsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        log.info("checking presense of message");
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(dc.getMessageBy(), 1));
        log.info("message is not presented");

        log.info("click button and wait for message");
        dc.getButton().click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(dc.getMessageBy(), 0));
        log.info(dc.getMessage().getText());

        log.info("click button and wait for checkbox to be present");
        dc.getButton().click();
        wait.until(ExpectedConditions.visibilityOf(dc.getMessage()));
        wait.until(ExpectedConditions.visibilityOf(dc.getCheckbox()));
        log.info(dc.getMessage().getText());
    }

    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }

}
