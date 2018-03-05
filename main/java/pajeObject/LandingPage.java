package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 02.03.2018.
 */
public class LandingPage {
    public WebDriver driver;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Basic Auth")
    WebElement basicAuth;

    @FindBy(linkText = "Broken Images")
    WebElement brokenImages;

    @FindBy(linkText = "Challenging DOM")
    WebElement challengingDOM;

    @FindBy(linkText = "Checkboxes")
    WebElement checkboxes;

    @FindBy(linkText = "Context Menu")
    WebElement contextMenu;

    @FindBy(linkText = "Disappearing Elements")
    WebElement disappearingElements;

    public WebElement getBasicAuth() {
        return basicAuth;
    }

    public WebElement getBrokenImages() {
        return brokenImages;
    }

    public WebElement getChallengingDOM() {
        return challengingDOM;
    }

    public WebElement getCheckboxes() {
        return checkboxes;
    }

    public WebElement getContextMenu() {
        return contextMenu;
    }

    public WebElement getDisappearingElements() {
        return disappearingElements;
    }
}
