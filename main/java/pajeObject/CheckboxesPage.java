package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 05.03.2018.
 */
public class CheckboxesPage {
    public WebDriver driver;
    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    WebElement checkbox1;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    WebElement checkbox2;

    public WebElement getCheckbox1() {
        return checkbox1;
    }

    public WebElement getCheckbox2() {
        return checkbox2;
    }
}
