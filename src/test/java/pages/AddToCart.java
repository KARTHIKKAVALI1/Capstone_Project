package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCart {

    WebDriver driver;

    // Locator for all "Add to Cart" buttons
    By productsLocator = By.className("shelf-item__buy-btn");

    // Constructor
    public AddToCart(WebDriver driver) {
        this.driver = driver;
    }

    // Add first product to cart
    public void addProduct1() throws InterruptedException {
        List<WebElement> products = driver.findElements(productsLocator);
        if (!products.isEmpty()) {
            WebElement firstProduct = products.get(0);
            System.out.println("First Product: " + firstProduct.getText());
            firstProduct.click();
            Thread.sleep(3000);
        } else {
            System.out.println("No products found!");
        }
    }

    // Add last product to cart
    public void addProduct2() throws InterruptedException {
        List<WebElement> products = driver.findElements(productsLocator);
        if (!products.isEmpty()) {
            WebElement lastProduct = products.get(products.size() - 1);
            System.out.println("Last Product: " + lastProduct.getText());
            lastProduct.click();
            Thread.sleep(3000);
        } else {
            System.out.println("No products found!");
        }
    }

    public void findItems() {
        List<WebElement> products = driver.findElements(productsLocator);
        if (!products.isEmpty()) {
            WebElement firstProduct = products.get(0);
            System.out.println("First Product: " + firstProduct.getText());

            WebElement lastProduct = products.get(products.size() - 1);
            System.out.println("Last Product: " + lastProduct.getText());
        } else {
            System.out.println("No products found!");
        }
    }
}
