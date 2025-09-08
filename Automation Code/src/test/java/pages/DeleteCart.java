package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteCart {
	
	WebDriver driver;
	
	By item1 = By.cssSelector("body div[id='__next'] div div[class='App'] div[class='float-cart float-cart--open'] div[class='float-cart__content'] div[class='float-cart__shelf-container'] div:nth-child(1) div:nth-child(1)");
	
	public DeleteCart(WebDriver driver) {
		this.driver = driver;
	}
	
	public void deleteCartItems() {
			driver.findElement(item1).click();
	}
	

}
