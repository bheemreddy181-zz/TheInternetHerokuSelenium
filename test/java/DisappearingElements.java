import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.ContextMenuPage;
import pajeObject.DisappearingElementsPage;
import pajeObject.LandingPage;

import java.io.IOException;

/**
 * Created by alexey.reshetnikov on 05.03.2018.
 */
public class DisappearingElements extends Base {
    private static Logger log = LogManager.getLogger(LandingPage.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("navigated to home page");
    }

    @Test
    public void checkBrokenImages(){
        LandingPage lp = new LandingPage(driver);
        lp.getDisappearingElements().click();
        DisappearingElementsPage disappearingElements = new DisappearingElementsPage(driver);
        log.info(disappearingElements.getElements().size());

        for (WebElement element : disappearingElements.getElements()){
            log.info(element.getText());
        }

        try{
            System.out.println(disappearingElements.getElements().get(4).getText());
        } catch (Exception e){
            System.out.println("Element Gallery is not present");
        }
    }

    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
