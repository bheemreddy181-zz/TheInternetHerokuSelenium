import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.JSAlertsPage;
import pajeObject.LandingPage;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class JSAlerts extends Base {
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
        lp.getJsAlerts().click();

        JSAlertsPage jsPage = new JSAlertsPage(driver);

        jsPage.getAlert().click();
        Alert jsAlert = driver.switchTo().alert();
        Assert.assertEquals(jsAlert.getText(), "I am a JS Alert");
        jsAlert.accept();
        Assert.assertEquals(jsPage.getResult().getText(), "You successfuly clicked an alert");

        jsPage.getConfirm().click();
        Alert jsConfirmAccept = driver.switchTo().alert();
        Assert.assertEquals(jsConfirmAccept.getText(), "I am a JS Confirm");
        jsConfirmAccept.accept();
        Assert.assertEquals(jsPage.getResult().getText(), "You clicked: Ok");

        jsPage.getConfirm().click();
        Alert jsConfirmCancel = driver.switchTo().alert();
        Assert.assertEquals(jsConfirmCancel.getText(), "I am a JS Confirm");
        jsConfirmCancel.dismiss();
        Assert.assertEquals(jsPage.getResult().getText(), "You clicked: Cancel");

        jsPage.getPrompt().click();
        Alert jsPrompt = driver.switchTo().alert();
        Assert.assertEquals(jsPrompt.getText(), "I am a JS prompt");
        jsPrompt.sendKeys("super text");
        jsPrompt.accept();
        Assert.assertEquals(jsPage.getResult().getText(), "You entered: super text");

        jsPage.getPrompt().click();
        jsPrompt = driver.switchTo().alert();
        Assert.assertEquals(jsPrompt.getText(), "I am a JS prompt");
        jsPrompt.sendKeys("super text");
        jsPrompt.dismiss();
        Assert.assertEquals(jsPage.getResult().getText(), "You entered: null");


    }



    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
