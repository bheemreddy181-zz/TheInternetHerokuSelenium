package pajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class DynamicControlsPage {
    public WebDriver driver;
    public DynamicControlsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By messageBy = By.cssSelector("#message");

    @FindBys(@FindBy(css = "#message"))
    List<WebElement> messages;

    @FindBy(css = "#message")
    WebElement message;

    @FindBys(@FindBy(css = "#btn"))
    List<WebElement> buttons;

    @FindBy(css = "#btn")
    WebElement button;

    By checkboxBy = By.cssSelector("#checkbox");

    @FindBys(@FindBy(css= "#checkbox"))
    List<WebElement> checkboxes;

    @FindBy(css= "#checkbox")
    WebElement checkbox;

    public WebElement getMessage() {
        return message;
    }

    public WebElement getButton() {
        return button;
    }

    public WebElement getCheckbox() {
        return checkbox;
    }

    public List<WebElement> getMessages() {
        return messages;
    }

    public List<WebElement> getButtons() {
        return buttons;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public By getMessageBy() {
        return messageBy;
    }

    public By getCheckboxBy() {
        return checkboxBy;
    }
}
