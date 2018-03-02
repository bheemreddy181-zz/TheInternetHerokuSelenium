package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by alexey.reshetnikov on 02.03.2018.
 */
public class BrokenImagesPage {
    public WebDriver driver;
    public BrokenImagesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBys(@FindBy(css = "img"))
    List<WebElement> images;


    public List<WebElement> getImages() {
        return images;
    }
}
