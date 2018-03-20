package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class KeyPressesPage {
    WebDriver driver;
    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "result")
    WebElement result;

    @FindBy(tagName = "body")
    WebElement body;

    public WebElement getResult() {
        return result;
    }

    public WebElement getBody() {
        return body;
    }
}
