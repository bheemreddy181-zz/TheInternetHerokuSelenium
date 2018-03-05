import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.DisappearingElementsPage;
import pajeObject.DragAndDropPage;
import pajeObject.LandingPage;

import java.io.IOException;

/**
 * Created by alexey.reshetnikov on 05.03.2018.
 */
public class DragAndDrop extends Base {
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
        lp.getDragAndDrop().click();
        DragAndDropPage dnd = new DragAndDropPage(driver);
        Actions actions = new Actions(driver);
        log.info(dnd.getColumnA().getText());
        dnd.getColumnA().click();
        //на текущем сайте не работает по каким-то причинам. аналогичная операция работает на http://jqueryui.com/droppable/
        actions.dragAndDrop(dnd.getColumnA(), dnd.getColumnB()).build().perform();
    }

    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
