package pajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class InfiniteScrollPage {
    WebDriver driver;
    public InfiniteScrollPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBys(@FindBy(xpath = "//div[@class='jscroll-added']"))
    List<WebElement> divs;

    By div = By.xpath("//div[@class='jscroll-added']");

    @FindBy(tagName = "body")
    WebElement body;

    public List<WebElement> getDivs() {
        return divs;
    }

    public By getDiv() {
        return div;
    }

    public WebElement getBody() {
        return body;
    }
}
