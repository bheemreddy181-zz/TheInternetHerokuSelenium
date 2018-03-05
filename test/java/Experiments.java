import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * Created by alexey.reshetnikov on 05.03.2018.
 */
public class Experiments {
    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.marionette", "C:\\java\\geckodriver\\geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
//        webDriver= new FirefoxDriver(capabilities);
    }
}
