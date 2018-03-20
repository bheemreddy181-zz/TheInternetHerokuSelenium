package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class LargeDOMPage {
    WebDriver driver;
    public LargeDOMPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "no-siblings")
    WebElement noSiblings;

    @FindBy(xpath = "//div[@id='sibling-41.2']")
    WebElement divId;

    @FindBy(css = ".row-20 .column-33")
    WebElement tableId;

    public WebElement getDivId() {
        return divId;
    }

    public WebElement getTableId() {
        return tableId;
    }

    public WebElement getNoSiblings() {
        return noSiblings;
    }
}
