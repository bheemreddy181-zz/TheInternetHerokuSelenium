import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

/**
 * Created by alexey.reshetnikov on 05.03.2018.
 */
public class Experiments {
    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.marionette", "C:\\java\\geckodriver\\geckodriver");

        WebDriver driver = new FirefoxDriver();

//        webDriver= new FirefoxDriver(capabilities);


        driver.get("http://the-internet.herokuapp.com/exit_intent");

        Actions builder = new Actions(driver);
        builder.moveByOffset(-10, -10).build().perform();
    }
}
