package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class ExitIntentPage {
    public WebDriver driver;
    public ExitIntentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ouibounce-modal")
    WebElement modal;

    @FindBy(css = ".modal-title h3")
    WebElement modalTitle;

    @FindBy(css = ".modal-footer p")
    WebElement modalClose;

    public WebElement getModal() {
        return modal;
    }

    public WebElement getModalTitle() {
        return modalTitle;
    }

    public WebElement getModalClose() {
        return modalClose;
    }
}
