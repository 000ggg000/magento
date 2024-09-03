package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenPage extends BasePage {

    @FindBy(linkText = "Pants")
    WebElement womenPants;

    @FindBy(id = "sorter")
    WebElement sorterBar;

    @FindBy(css = ".toolbar-products:nth-child(3) [value='price']")
    WebElement priceOption;

    @FindBy(css = ".product-item:nth-of-type(1) [max-width]")
    WebElement cheapestItem;

    @FindBy(id = "option-label-size-143-item-172")
    WebElement pantsSize;

    @FindBy(id = "option-label-color-93-item-52")
    WebElement colorGrey;

    @FindBy(id = "product-addtocart-button")
    WebElement addToCartButton;

    @FindBy(css = "[data-ui-id='message-success']")
    WebElement messageAdded;

    @FindBy(id = "option-label-color-93-item-50")
    WebElement colorBlue;

    @FindBy(css = ".minicart-wrapper > .action.showcart")
    WebElement cart;

    @FindBy(css = "li:nth-of-type(1) .product-item-name > a")
    WebElement itemInCart;

    @FindBy(css = ".product-item:nth-of-type(2) [max-width]")
    WebElement secondItem;

    @FindBy(css = "li:nth-of-type(1) > .product a[title='Remove item']")
    WebElement removeFirst;

    @FindBy(css = ".action-accept.action-primary")
    WebElement confirmationRemoveMessage;

    @FindBy(css = "button#top-cart-btn-checkout")
    WebElement checkoutButton;


    public WomenPage(WebDriver driver) {
        super(driver);
    }

    public void selectWomenPants() {
        womenPants.click();
    }

    public void selectSorter() {
        sorterBar.click();
    }

    public void setPriceOption() {
        priceOption.click();
    }

    public void chooseFirstItem() {
        cheapestItem.click();
    }

    public void selectPantsSize() {
        pantsSize.click();
    }

    public void selectPantsColor() {
        colorGrey.click();
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public String messageText() {
        return messageAdded.getText();
    }

    public void chooseBlue() {
        colorBlue.click();
    }

    public void clickCart() {
        cart.click();
    }

    public void chooseSecondItem() {
        secondItem.click();
    }

    public void clickRemoveFirst() {
        removeFirst.click();
    }

    public void confirmToRemove() {
        confirmationRemoveMessage.click();
    }

    public String itemInCartMessage() {
        return itemInCart.getText();
    }
    public void clickCheckOut() {
        checkoutButton.click();
    }

}

