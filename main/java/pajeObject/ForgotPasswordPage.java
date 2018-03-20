package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class ForgotPasswordPage {
    public WebDriver driver;
    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "form_submit")
    WebElement submit;

    public WebElement getEmail() {
        return email;
    }

    public WebElement getSubmit() {
        return submit;
    }
}
