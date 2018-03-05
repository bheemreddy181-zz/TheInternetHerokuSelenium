import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.DragAndDropPage;
import pajeObject.DropdownPage;
import pajeObject.LandingPage;

import java.io.IOException;

/**
 * Created by alexey.reshetnikov on 05.03.2018.
 */
public class Dropdown extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    @Test
    public void checkBrokenImages() {
        LandingPage lp = new LandingPage(driver);
        lp.getDropdown().click();

        DropdownPage dropPage = new DropdownPage(driver);

        dropPage.getDrpList().selectByValue("2");
        dropPage.getDrpList().selectByIndex(1);
        log.info(dropPage.getDrpList().getFirstSelectedOption().getText());


    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
