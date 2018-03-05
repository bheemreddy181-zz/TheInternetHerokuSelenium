package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 05.03.2018.
 */
public class DragAndDropPage {
    public WebDriver driver;
    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='columns']/div[1]")
    WebElement columnA;

    @FindBy(xpath = "//div[@id='columns']/div[2]")
    WebElement columnB;

    public WebElement getColumnA() {
        return columnA;
    }

    public WebElement getColumnB() {
        return columnB;
    }
}
