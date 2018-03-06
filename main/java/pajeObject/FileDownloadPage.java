package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class FileDownloadPage {
    public WebDriver driver;
    public FileDownloadPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "some-file.txt")
    WebElement someFile;

    @FindBy(linkText = "ObjectivityTestAutomationCSHarpFramework.txt")
    WebElement frameworkFile;

    public WebElement getSomeFile() {
        return someFile;
    }

    public WebElement getFrameworkFile() {
        return frameworkFile;
    }
}
