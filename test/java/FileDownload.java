import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeObject.FileDownloadPage;
import pajeObject.LandingPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class FileDownload extends Base {
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
        LandingPage lp = new LandingPage(driver);
        lp.getFileDownload().click();

        FileDownloadPage downloadPage = new FileDownloadPage(driver);

        URLStatusChecker urlChecker = new URLStatusChecker(driver);
        String uriSomeFile = downloadPage.getSomeFile().getAttribute("href");
        String uriFrameworkFile = downloadPage.getFrameworkFile().getAttribute("href");
        urlChecker.setURIToCheck(uriSomeFile);
        urlChecker.setHTTPRequestMethod(RequestMethod.GET);
        Assert.assertTrue(urlChecker.getHTTPStatusCode() == 200);

        urlChecker.setURIToCheck(uriFrameworkFile);
        Assert.assertTrue(urlChecker.getHTTPStatusCode() == 200);

        urlChecker.setURIToCheck("http://the-internet.herokuapp.com/download/");
        Assert.assertTrue(urlChecker.getHTTPStatusCode() == 404);

    }
    @AfterTest
    public void teardown(){
        driver.close();
        driver=null;
    }
}
