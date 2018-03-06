package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class DynamicLoadingPage {
    public WebDriver driver;
    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "Example 1")
    WebElement example1;

    @FindBy(partialLinkText = "Example 2")
    WebElement example2;

    public WebElement getExample1() {
        return example1;
    }

    public WebElement getExample2() {
        return example2;
    }
}
