import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.FileDownloadPage;
import pajeObject.FileUploadPage;
import pajeObject.LandingPage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class FileUpload extends Base {
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
        File f = new File("C:\\temp\\untitled.txt");

        LandingPage lp = new LandingPage(driver);
        lp.getUploadFile().click();

        FileUploadPage uploadPage = new FileUploadPage(driver);
        uploadPage.getFileUpload().sendKeys(f.getAbsolutePath());
        uploadPage.getFileSubmit().click();

        wait.until(ExpectedConditions.presenceOfElementLocated(uploadPage.getSuccessUploadBy()));

        Assert.assertEquals(uploadPage.getSuccessUpload().getText(), "File Uploaded!");
        Assert.assertEquals(uploadPage.getUploadedFiles().getText(), f.getName());
        log.info("file " + f.getAbsolutePath() + " successfully uploaded");


    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
