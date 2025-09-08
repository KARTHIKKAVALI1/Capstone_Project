package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	WebDriver driver;
	
	By checkoutButton = By.cssSelector("div[class=\"buy-btn\"]");
	By firstName = By.id("firstNameInput"); 
	By lastName = By.id("lastNameInput");
	By Address = By.id("addressLine1Input");
	By State = By.id("provinceInput");
	By postalcode = By.id("postCodeInput");
	By submit = By.id("checkout-shipping-continue");		
    By continueShopping = By.cssSelector("button[class=\"button button--tertiary optimizedCheckout-buttonSecondary\"]");
    
    public CheckoutPage(WebDriver driver) {
    	this.driver = driver;
    }
    
    public void checkoutButton() {
    	driver.findElement(checkoutButton).click();
    }
    public void firstName(String firstname) {
    	driver.findElement(firstName).clear();
    	driver.findElement(firstName).sendKeys(firstname);
    }
    public void lastName(String lastname) {
    	driver.findElement(lastName).clear();
    	driver.findElement(lastName).sendKeys(lastname);
    }
    public void Address(String address) {
    	driver.findElement(Address).clear();
    	driver.findElement(Address).sendKeys(address);
    }
    public void State(String state) {
    	driver.findElement(State).clear();
    	driver.findElement(State).sendKeys(state);
    }
    public void postalCode(String code) {
    	driver.findElement(postalcode).clear();
    	driver.findElement(postalcode).sendKeys(code);
    }
    public void submit() {
    	driver.findElement(submit).click();
    }
    public void continueShopping() {
    	driver.findElement(continueShopping).click();
    }
}
