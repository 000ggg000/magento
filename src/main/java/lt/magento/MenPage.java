package lt.magento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Integer.parseInt;

public class MenPage extends BasePage {

    @FindBy(xpath = "/html//main[@id='maincontent']/div[@class='columns']//div[@class='categories-menu']/ul[1]//a[@href='https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html']")
    WebElement hoodiesSweatshirts;

    @FindBy(id = "page-title-heading")
    WebElement titleMen;

    @FindBy(linkText = "Frankie Sweatshirt")
    WebElement frankieShirt;

    @FindBy(id = "option-label-size-143-item-169")
    WebElement size;

    @FindBy(id = "option-label-color-93-item-60")
    WebElement color;

    @FindBy(id = "qty")
    WebElement qty;

    @FindBy(id = "product-addtocart-button")
    WebElement addToCartButton;

    @FindBy(css = ".counter-number")
    WebElement cartItems;

    @FindBy(css = "[data-ui-id='message-success']")
    WebElement messageAddedToCart;

    @FindBy(css = ".action.viewcart > span")
    WebElement viewCart;

    @FindBy(css = ".col.item  strong > a")
    WebElement itemName;

    @FindBy(css = ".checkout.checkout-methods-items.items.methods  button[title='Proceed to Checkout']")
    WebElement proceedCheckout;

    @FindBy(css = ".ea-stickybox-hide")
    WebElement advertisement;

    @FindBy(css = ".toolbar-products:nth-child(5) [value='12']")
    WebElement showPerPageNumber;

    @FindBy(css = ".product-item:nth-of-type(12)")
    WebElement element12;

    public MenPage(WebDriver driver) {
        super(driver);
    }

    public void selectHoodiesButton() {
        hoodiesSweatshirts.click();
    }

    public String titleMenDisplayed() {
        return titleMen.getText();
    }

    public void openFrankieItem() {
        frankieShirt.click();
    }

    public void selectSize() {
        size.click();
    }

    public void selectColor() {
        color.click();
    }

    public void selectQty() {
        qty.clear();
        qty.sendKeys("2");
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public String checkTheQtyOfItemAdded() {
        return cartItems.getText();
    }

    public void openCart() {
        cartItems.click();
        viewCart.click();
    }

    public String checkIfRightItem() {
        return itemName.getText();
    }

    public void setProceedCheckout() {
        proceedCheckout.click();
    }

    public void closeAdvertisement() {
        advertisement.click();
    }

    public String numberPerPage() {
        return showPerPageNumber.getText();
    }
}
