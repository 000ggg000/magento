package lt.techin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends BasePageTest {


    @Test
    void clickMenClothes() {
        MainPage mainPage = new MainPage(driver);
        MenPage menPage = new MenPage(driver);
        mainPage.selectMenButton();
        menPage.selectHoodiesButton();
        assertEquals("Hoodies & Sweatshirts", menPage.titleMenDisplayed(), "The page was not redirected to Men page");
    }

    @Test
    void addProductToTheCart() {
        MainPage mainPage = new MainPage(driver);
        MenPage menPage = new MenPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        mainPage.selectMenButton();
        menPage.selectHoodiesButton();
        menPage.openFrankieItem();
        menPage.selectSize();
        menPage.selectColor();
        menPage.selectQty();
        menPage.addToCart();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        wait.until(d -> menPage.messageAddedToCart.isDisplayed());
        assertEquals("2", menPage.checkTheQtyOfItemAdded(), "The quantity of Item was not added.");
        menPage.openCart();
        assertEquals("Frankie Sweatshirt", menPage.checkIfRightItem(), "Wrong item added.");
        wait.until(d -> menPage.proceedCheckout.isDisplayed());
        menPage.closeAdvertisement();
        menPage.setProceedCheckout();
        wait.until(d -> checkoutPage.email.isDisplayed());
        checkoutPage.setEmail();
        checkoutPage.setName();
        checkoutPage.setLastName();
        checkoutPage.setCompany();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 350)");
        checkoutPage.setAddress();
        checkoutPage.setCity();
        checkoutPage.setState();
        checkoutPage.setPostCode();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        checkoutPage.setPhone();
        checkoutPage.setShippingMethod();
        checkoutPage.clickNext();
        wait.until(d -> checkoutPage.placeOrderButton.isDisplayed());
        checkoutPage.removeAdvertisement2();
        checkoutPage.makeOrder();
        assertEquals("Checkout", checkoutPage.titlePurchaseDisplayed(), "The purchase is not completed");
    }

    @Test
    void addWomenProductToTheCart() {
        MainPage mainPage = new MainPage(driver);
        WomenPage womenPage = new WomenPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        mainPage.selectWomenButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 350)");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        womenPage.selectWomenPants();
        womenPage.selectSorter();
        womenPage.setPriceOption();
        womenPage.chooseFirstItem();
        womenPage.selectPantsSize();
        womenPage.selectPantsColor();
        womenPage.clickAddToCart();
        wait.until(d -> womenPage.messageAdded.isDisplayed());
        assertEquals("You added Karmen Yoga Pant to your shopping cart.", womenPage.messageText(), "The Item did not added");
        womenPage.selectWomenPants();
        womenPage.chooseFirstItem();
        womenPage.selectPantsSize();
        womenPage.chooseBlue();
        womenPage.clickAddToCart();
        wait.until(d -> womenPage.messageAdded.isDisplayed());
        assertEquals("You added Portia Capri to your shopping cart.", womenPage.messageText(), "The Item did not added");
        womenPage.clickCart();
        assertEquals("Portia Capri", womenPage.itemInCartMessage(), "The Item did not added");
        womenPage.selectWomenPants();
        womenPage.chooseSecondItem();
        womenPage.selectPantsSize();
        womenPage.chooseBlue();
        womenPage.clickAddToCart();
        womenPage.clickCart();
        wait.until(d -> womenPage.messageAdded.isDisplayed());
        assertEquals("You added Deirdre Relaxed-Fit Capri to your shopping cart.", womenPage.messageText(), "The Item did not added");
        womenPage.clickCart();
        womenPage.clickCart();
        womenPage.clickRemoveFirst();
        wait.until(d -> womenPage.confirmationRemoveMessage.isDisplayed());
        womenPage.confirmToRemove();
        womenPage.clickCheckOut();
        wait.until(d -> checkoutPage.email.isDisplayed());
        checkoutPage.setEmail();
        checkoutPage.setName();
        checkoutPage.setLastName();
        checkoutPage.setCompany();
        js.executeScript("window.scrollTo(0, 350)");
        checkoutPage.setAddress();
        checkoutPage.setCity();
        checkoutPage.setState();
        checkoutPage.setPostCode();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        checkoutPage.setPhone();
        checkoutPage.setShippingMethod();
        checkoutPage.clickNext();
        wait.until(d -> checkoutPage.placeOrderButton.isDisplayed());
        wait.until(d -> checkoutPage.advertisement2.isDisplayed());
        checkoutPage.removeAdvertisement2();
        checkoutPage.makeOrder();
        assertEquals("Checkout", checkoutPage.titlePurchaseDisplayed(), "The purchase is not completed");
    }

}
