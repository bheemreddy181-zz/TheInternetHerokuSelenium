package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class FormAuthenticationSecurePage {
    WebDriver driver;
    public FormAuthenticationSecurePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "flash")
    WebElement flash;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logout;

    public WebElement getFlash() {
        return flash;
    }

    public WebElement getLogout() {
        return logout;
    }
}
