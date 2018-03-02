package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 02.03.2018.
 */
public class BasicAuth {
    public WebDriver driver;
    public BasicAuth(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[@class='example']/p")
    WebElement congratulations;

    public WebElement getCongratulations() {
        return congratulations;
    }
}
