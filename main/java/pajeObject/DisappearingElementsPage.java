package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by alexey.reshetnikov on 05.03.2018.
 */
public class DisappearingElementsPage {
    public WebDriver driver;
    public DisappearingElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBys(@FindBy(xpath = "//div[@class='example']/ul/li"))
    List<WebElement> elements;

    public List<WebElement> getElements() {
        return elements;
    }
}
