package pajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class DynamicContentPage {
    public WebDriver driver;
    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBys(@FindBy(xpath = "//div[contains(@id, 'content') and contains(@class, 'large-centered')]/div"))
    List<WebElement> rows;

    public WebElement getImage(WebElement row){
        return row.findElement(By.xpath("div[contains(@class, 'large-2')]/img"));
    }

    public WebElement getText(WebElement row){
        return row.findElement(By.xpath("div[contains(@class, 'large-10')]"));
    }

    public List<WebElement> getRows() {
        return rows;
    }
}
