package lt.magento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "customer-email")
    WebElement email;

    @FindBy(css = "input[name='firstname']")
    WebElement name;

    @FindBy(css = "input[name='lastname']")
    WebElement lastName;

    @FindBy(css = "input[name='company']")
    WebElement company;

    @FindBy(css = "input[name='street[0]']")
    WebElement address;

    @FindBy(xpath = "//div[@id='shipping-new-address-form']/*[5]/div/input")
    WebElement city;

    @FindBy(css = "select[name='region_id']")
    WebElement state;

    @FindBy(css = "input[name='postcode']")
    WebElement postCode;

    @FindBy(css = "//div[@id='shipping-new-address-form']/*[9]/div/select")
    WebElement country;

    @FindBy(css = "input[name='telephone']")
    WebElement phone;

    @FindBy(css = "input[name='ko_unique_3']")
    WebElement shippingMethod;

    @FindBy(css = "div#shipping-method-buttons-container span")
    WebElement next;

    @FindBy(css = "button[title='Place Order']")
    WebElement placeOrderButton;

    @FindBy(css = ".ea-stickybox-hide")
    WebElement advertisement2;

    @FindBy(css = ".base")
    WebElement purchaseText;


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail() {
        email.sendKeys("twoday@twoday.lt");
    }

    public void setName() {
        name.sendKeys("John");
    }

    public void setLastName() {
        lastName.sendKeys("Dow");
    }

    public void setCompany() {
        company.sendKeys("Twoday");
    }

    public void setAddress() {
        address.sendKeys("The Center 5");
    }

    public void setCity() {
        city.sendKeys("Netherland");
    }

    public void setState() {
        state.sendKeys("Alaska");
    }

    public void setPostCode() {
        postCode.sendKeys("12345-6789");
    }

    public void setCountry() {
        country.sendKeys("United States");
    }

    public void setPhone() {
        phone.sendKeys("12346789");
    }

    public void setShippingMethod() {
        shippingMethod.click();
    }

    public void clickNext() {
        next.click();
    }

    public void makeOrder() {
        placeOrderButton.click();
    }

    public void removeAdvertisement2() {
        advertisement2.click();
    }

    public String titlePurchaseDisplayed() {
        return purchaseText.getText();
    }

}
