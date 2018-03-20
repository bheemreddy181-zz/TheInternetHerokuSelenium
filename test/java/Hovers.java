import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.HoversPage;
import pajeObject.LandingPage;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class Hovers extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    @Test
    public void checkFileDownload() throws IOException, URISyntaxException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Actions builder = new Actions(driver);

        LandingPage lp = new LandingPage(driver);
        lp.getHovers().click();

        HoversPage hp = new HoversPage(driver);


        builder.moveToElement(hp.getHover1())
                .build()
                .perform();

        Assert.assertTrue(hp.getName1().isDisplayed());
        Assert.assertTrue(hp.getName1().getText().equals("name: user1"));

        builder.moveToElement(hp.getHover2())
                .build()
                .perform();

        Assert.assertTrue(hp.getName2().isDisplayed());
        Assert.assertTrue(hp.getName2().getText().equals("name: user2"));


    }



    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
