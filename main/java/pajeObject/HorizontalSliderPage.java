package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class HorizontalSliderPage {
    WebDriver driver;
    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[type='range']")
    WebElement slider;

    @FindBy(id = "range")
    WebElement range;

    public WebElement getSlider() {
        return slider;
    }

    public WebElement getRange() {
        return range;
    }
}
