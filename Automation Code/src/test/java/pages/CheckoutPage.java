package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	WebDriver driver;
	
	By checkoutButton = By.cssSelector("div[class=\"buy-btn\"]");
	By firstName = By.id("firstNameInput"); 
	//firstname.sendKeys("Sanjana");
	//firstname.sendKeys(Keys.ENTER);
	
	By lastName = By.id("lastNameInput");
	//lastname.sendKeys("Penugonda");
	//lastname.sendKeys(Keys.ENTER);
	
	By Address = By.id("addressLine1Input");
	//Address.sendKeys("Gummalladoddi");
	//Address.sendKeys(Keys.ENTER);
	
	By State = By.id("provinceInput");
	//State.sendKeys("Andhra Pradesh");
	//State.sendKeys(Keys.ENTER);
	
	By postalcode = By.id("postCodeInput");
	//postalcode.sendKeys("533289");
	//postalcode.sendKeys(Keys.ENTER);
	
	By submit = By.id("checkout-shipping-continue");		
    By continueShopping = By.cssSelector("button[class=\"button button--tertiary optimizedCheckout-buttonSecondary\"]");
    
    public CheckoutPage(WebDriver driver) {
    	this.driver = driver;
    }
    
    public void checkoutButton() {
    	driver.findElement(checkoutButton).click();
    }
    public void firstName(String firstname) {
    	driver.findElement(firstName).sendKeys(firstname);
    }
    public void lastName(String lastname) {
    	driver.findElement(lastName).sendKeys(lastname);
    }
    public void Address(String address) {
    	driver.findElement(Address).sendKeys(address);
    }
    public void State(String state) {
    	driver.findElement(State).sendKeys(state);
    }
    public void postalCode(String code) {
    	driver.findElement(postalcode).sendKeys(code);
    }
    public void submit() {
    	driver.findElement(submit).click();
    }
    public void continueShopping() {
    	driver.findElement(continueShopping).click();
    }
}
