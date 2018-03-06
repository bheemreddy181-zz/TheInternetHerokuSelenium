package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by alexey.reshetnikov on 06.03.2018.
 */
public class FloatingMenuPage {
    public WebDriver driver;
    public FloatingMenuPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBys(@FindBy(xpath = "//div[contains(@class, 'scroll')]/p"))
    List<WebElement> paragraphs;

    @FindBy(xpath = "//a[@href='#home']")
    WebElement home;

    @FindBy(xpath = "//a[@href='#news']")
    WebElement news;

    @FindBy(xpath = "//a[@href='#contact']")
    WebElement contact;

    @FindBy(xpath = "//a[@href='#about']")
    WebElement about;

    public List<WebElement> getParagraphs() {
        return paragraphs;
    }

    public WebElement getHome() {
        return home;
    }

    public WebElement getNews() {
        return news;
    }

    public WebElement getContact() {
        return contact;
    }

    public WebElement getAbout() {
        return about;
    }
}
