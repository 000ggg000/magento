package lt.magento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class MainPage extends BasePage {

    @FindBy(id = "ui-id-5")
    WebElement buttonMenSelect;

    @FindBy(linkText = "Women")
    WebElement buttonWomenSelect;

    public MainPage(WebDriver driver) {

        super(driver);
    }

    public void waiting() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void selectMenButton() {
        buttonMenSelect.click();
    }

    public void selectWomenButton() {
        buttonWomenSelect.click();
    }

}
