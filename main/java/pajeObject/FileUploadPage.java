package pajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class FileUploadPage {
    public WebDriver driver;
    public FileUploadPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#file-upload")
    WebElement fileUpload;

    @FindBy(css = "#file-submit")
    WebElement fileSubmit;

    @FindBy(css= ".example h3")
    WebElement successUpload;

    @FindBy(css= "#uploaded-files")
    WebElement uploadedFiles;

    By successUploadBy = By.cssSelector(".example h3");

    public WebElement getFileUpload() {
        return fileUpload;
    }

    public WebElement getFileSubmit() {
        return fileSubmit;
    }

    public WebElement getSuccessUpload() {
        return successUpload;
    }

    public WebElement getUploadedFiles() {
        return uploadedFiles;
    }

    public By getSuccessUploadBy() {
        return successUploadBy;
    }
}
