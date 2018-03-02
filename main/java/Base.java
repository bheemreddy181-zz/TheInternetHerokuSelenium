import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by alexey.reshetnikov on 02.03.2018.
 */
public class Base {
    public static WebDriver driver;
    public Properties prop;
    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");


        //chrome
        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        //firefox
        {
            //firefox driver
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;

    }
}
