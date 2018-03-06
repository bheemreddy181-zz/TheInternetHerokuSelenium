package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class DynamicLoadingPage1 {
    public WebDriver driver;
    public DynamicLoadingPage1(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#start button")
    WebElement button;

    @FindBy(css = "#finish h4")
    WebElement message;

    public WebElement getButton() {
        return button;
    }

    public WebElement getMessage() {
        return message;
    }
}
