import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.BrokenImagesPage;
import pajeObject.LandingPage;

import java.io.IOException;

/**
 * Created by alexey.reshetnikov on 02.03.2018.
 */
public class BrokenImages extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
        driver.manage().deleteAllCookies();
    }

    @Test
    public void checkBrokenImages(){
        LandingPage lp = new LandingPage(driver);
        lp.getBrokenImages().click();
        BrokenImagesPage brokenImagesPage = new BrokenImagesPage(driver);

        for (WebElement image : brokenImagesPage.getImages())
        {
            if (!imageExists(image)){
                System.out.println(image.getAttribute("outerHTML") + " is broken.");
            }
        }
    }

    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }

    public boolean imageExists(WebElement image)
    {
        return !image.getAttribute("naturalWidth").equals("0");
    }
}
