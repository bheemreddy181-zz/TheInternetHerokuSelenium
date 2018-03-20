package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class JSAlertsPage {
    WebDriver driver;
    public JSAlertsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement alert;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement confirm;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement prompt;

    @FindBy(id = "result")
    WebElement result;

    public WebElement getAlert() {
        return alert;
    }

    public WebElement getConfirm() {
        return confirm;
    }

    public WebElement getPrompt() {
        return prompt;
    }

    public WebElement getResult() {
        return result;
    }
}
