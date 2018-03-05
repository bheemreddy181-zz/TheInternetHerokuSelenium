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
public class ChallengingDOMPage {
    public WebDriver driver;
    public ChallengingDOMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "table")
    WebElement table;

    @FindBy(xpath = "//*[contains(@class, 'large-2')]/a[@class='button alert']")
    WebElement alertButton;

    @FindBy(xpath = "//*[contains(@class, 'large-10')]/table/tbody/tr[6]/td[4]")
    WebElement sit5;

    @FindBy(xpath = "//*[contains(@class, 'large-10')]/table/tbody/tr[8]/td[7]/a[1]")
    WebElement edit7;

    public WebElement getTable() {
        return table;
    }

    public WebElement getAlertButton() {
        return alertButton;
    }

    public WebElement getSit5() {
        return sit5;
    }

    public WebElement getEdit7() {
        return edit7;
    }
}
