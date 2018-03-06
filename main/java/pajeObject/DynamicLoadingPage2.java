package pajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class DynamicLoadingPage2 {
    public WebDriver driver;
    public DynamicLoadingPage2(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#start button")
    WebElement button;

    @FindBy(css = "#finish h4")
    WebElement message;

    By messageBy = By.cssSelector("#finish h4");

    public WebElement getButton() {
        return button;
    }

    public WebElement getMessage() {
        return message;
    }

    public By getMessageBy() {
        return messageBy;
    }
}
