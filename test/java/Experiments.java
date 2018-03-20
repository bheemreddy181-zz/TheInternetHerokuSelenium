import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
//        System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver.exe");


        WebDriver driver;
        FirefoxOptions options = new FirefoxOptions();
//        options.addPreference("network.proxy.type", 0);
        options.addPreference("geo.prompt.testing", true);
        options.addPreference("geo.prompt.testing.allow", true);
        driver = new FirefoxDriver(options.toCapabilities());

        driver.get("http://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.xpath("//button")).click();
    }
}
