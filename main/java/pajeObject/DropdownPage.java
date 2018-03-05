package pajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by alexey.reshetnikov on 05.03.2018.
 */
public class DropdownPage {
    public WebDriver driver;
    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public Select getDrpList() {
        return new Select(dropdown);
    }
}
