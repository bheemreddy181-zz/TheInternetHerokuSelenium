import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.HorizontalSliderPage;
import pajeObject.LandingPage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class HorizontalSlider1 extends Base {
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

        LandingPage lp = new LandingPage(driver);
        lp.getHorizontalSlider().click();

        HorizontalSliderPage hs = new HorizontalSliderPage(driver);
        wait.until(ExpectedConditions.visibilityOf(hs.getSlider()));

        log.info("initial range value is " + hs.getRange().getText());

        Dimension sliderSize = hs.getSlider().getSize();
        int sliderWidth = sliderSize.getWidth();
        int xCoord = hs.getSlider().getLocation().getX();

        Actions builder = new Actions(driver);
        builder.moveToElement(hs.getSlider())
                .click()
                .dragAndDropBy(hs.getSlider(),xCoord+sliderWidth, 0)
                .build()
                .perform();

        int rangeValue = Integer.parseInt(
                hs.getRange().getText());
        Assert.assertEquals(rangeValue, 5);
    }



    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
