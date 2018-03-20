package pajeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey.reshetnikov on 20.03.2018.
 */
public class HoversPage {
    WebDriver driver;
    public HoversPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='example']/div[1]")
    WebElement hover1;

    @FindBy(xpath = "//div[@class='example']/div[1]/div[@class='figcaption']/h5")
    WebElement name1;

    @FindBy(xpath = "//div[@class='example']/div[2]")
    WebElement hover2;

    @FindBy(xpath = "//div[@class='example']/div[2]/div[@class='figcaption']/h5")
    WebElement name2;

    @FindBy(xpath = "//div[@class='example']/div[3]")
    WebElement hover3;

    @FindBy(xpath = "//div[@class='example']/div[3]/div[@class='figcaption']/h5")
    WebElement name3;

    public WebElement getHover1() {
        return hover1;
    }

    public WebElement getName1() {
        return name1;
    }

    public WebElement getHover2() {
        return hover2;
    }

    public WebElement getName2() {
        return name2;
    }

    public WebElement getHover3() {
        return hover3;
    }

    public WebElement getName3() {
        return name3;
    }
}
