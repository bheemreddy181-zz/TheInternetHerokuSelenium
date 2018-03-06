import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.ChallengingDOMPage;
import pajeObject.CheckboxesPage;
import pajeObject.LandingPage;

import java.io.IOException;

/**
 * Created by alexey.reshetnikov on 05.03.2018.
 */
public class Checkboxes extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    @Test
    public void checkCheckboxes(){
        LandingPage lp = new LandingPage(driver);
        lp.getCheckboxes().click();
        CheckboxesPage cb = new CheckboxesPage(driver);
        Assert.assertTrue(!cb.getCheckbox1().isSelected());
        Assert.assertTrue(cb.getCheckbox2().isSelected());

        log.info(cb.getCheckbox1().isSelected());
        log.info(cb.getCheckbox2().isSelected());

        cb.getCheckbox1().click();
        cb.getCheckbox2().click();

        Assert.assertTrue(cb.getCheckbox1().isSelected());
        Assert.assertTrue(!cb.getCheckbox2().isSelected());

        log.info(cb.getCheckbox1().isSelected());
        log.info(cb.getCheckbox2().isSelected());
    }

    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
