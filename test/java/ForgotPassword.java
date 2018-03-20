import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.FileDownloadPage;
import pajeObject.ForgotPasswordPage;
import pajeObject.ForgotPasswordSuccessPage;
import pajeObject.LandingPage;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class ForgotPassword extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    @Test
    public void checkForgotPassword() throws IOException, URISyntaxException {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        LandingPage lp = new LandingPage(driver);
        lp.getForgotPassword().click();

        ForgotPasswordPage fp = new ForgotPasswordPage(driver);
        fp.getEmail().sendKeys("mail@mail.com");
        fp.getSubmit().click();

        ForgotPasswordSuccessPage fps = new ForgotPasswordSuccessPage(driver);
        wait.until(ExpectedConditions.visibilityOf(fps.getContent()));

        log.info(fps.getContent().getText());
        Assert.assertTrue(fps.getContent().getText().contains("Your e-mail's been sent!"));


    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
