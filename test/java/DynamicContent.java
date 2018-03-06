import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.DropdownPage;
import pajeObject.DynamicContentPage;
import pajeObject.LandingPage;

import java.io.IOException;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class DynamicContent extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    @Test
    public void checkDynamicContent() {
        LandingPage lp = new LandingPage(driver);
        lp.getDynamicContent().click();

        DynamicContentPage dc = new DynamicContentPage(driver);

        for (WebElement row : dc.getRows()){
            log.info(dc.getImage(row).getAttribute("src"));
            log.info(dc.getText(row).getText());
        }


    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
