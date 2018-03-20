package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class JQueryUIMenusPage {
    WebDriver driver;
    public JQueryUIMenusPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@id='menu']/li[not(contains(@class, 'ui-state-disabled'))]")
    WebElement menuEnabled;

    @FindBy(xpath = "//ul[@id='menu']/li[not(contains(@class, 'ui-state-disabled'))]/ul/li[1]")
    WebElement menuDownloads;

    @FindBy(xpath = "//ul[@id='menu']/li[not(contains(@class, 'ui-state-disabled'))]/ul/li[2]")
    WebElement backToJQuery;

    @FindBys(@FindBy(xpath = "//ul[@id='menu']/li[not(contains(@class, 'ui-state-disabled'))]/ul/li[1]//li"))
    List<WebElement> downloads;

    public WebElement getMenuEnabled() {
        return menuEnabled;
    }

    public WebElement getMenuDownloads() {
        return menuDownloads;
    }

    public WebElement getBackToJQuery() {
        return backToJQuery;
    }

    public List<WebElement> getDownloads() {
        return downloads;
    }
}
