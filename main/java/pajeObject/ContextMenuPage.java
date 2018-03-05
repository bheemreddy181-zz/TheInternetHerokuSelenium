package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 05.03.2018.
 */
public class ContextMenuPage {
    public WebDriver driver;
    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "hot-spot")
    WebElement hotspot;

    @FindBy(linkText = "the-internet")
    WebElement theInternet;


    public WebElement getHotspot() {
        return hotspot;
    }

    public WebElement getTheInternet() {
        return theInternet;
    }
}
